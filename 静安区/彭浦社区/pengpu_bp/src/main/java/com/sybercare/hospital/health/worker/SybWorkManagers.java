package com.sybercare.hospital.health.worker;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.sybercare.hospital.common.utils.BaseObservable;
import com.sybercare.hospital.common.utils.BaseObserver;
import com.sybercare.hospital.common.utils.WorkAutowired;
import com.sybercare.hospital.health.worker.push.SybPushXueTangOnWorker;
import com.sybercare.hospital.health.worker.recv.SybRecvDepartmentOnWorker;
import com.sybercare.hospital.health.worker.recv.SybRecvPatientOnWorker;
import com.sybercare.hospital.health.worker.recv.SybRecvPrescriptionOtherOnWorker;
import com.sybercare.hospital.health.worker.recv.SybRecvStaffOnWorker;
import com.sybercare.hospital.health.worker.recv.SybRecvWardareaOnWorker;

/**
 * 功能：院内数据工作模块
 * 
 * @author 任梁荣
 * */
@Component
public class SybWorkManagers {

	@Autowired
	private ApplicationContext applicationContext;

	protected static final Logger logger = LoggerFactory.getLogger(SybWorkManagers.class);

	public static ConcurrentHashMap<SybWorkEvents, BaseObservable> events = new ConcurrentHashMap<SybWorkEvents, BaseObservable>();

	public synchronized boolean onEvents(SybWorkEvents names, Object... args) {
		try {
			if (events != null && events.size() == 0)
				this.onLoadEventListener();
			if (events.containsKey(names)) {
				BaseObservable base = events.get(names);
				base.setChanged();
				base.notifyObservers(args);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@SuppressWarnings("rawtypes")
	protected boolean addEventListener(SybWorkEvents names, Class clazz) throws InstantiationException, IllegalAccessException {
		if (!events.containsKey(names)) {
			try {
				BaseObservable baseObs = new BaseObservable();
				BaseObserver observer = (BaseObserver) clazz.newInstance();
				List<Field> fileds = new ArrayList<Field>() {
					private static final long serialVersionUID = -7153556867475157193L;
					{
						Class tempClass = clazz;
						while (tempClass != null) {
							addAll(Arrays.asList(tempClass.getDeclaredFields()));
							tempClass = tempClass.getSuperclass();
						}
					}
				};
				for (Field field : fileds) {
					if (field.isAnnotationPresent(WorkAutowired.class)) {
						Class<?> beanClass = field.getType();
						field.setAccessible(true);
						field.set(observer, getBean(beanClass));
					}
				}
				baseObs.addObserver(observer);
				events.put(names, baseObs);
				return true;
			} catch (InstantiationException | IllegalAccessException e) {
			}
		}
		return false;
	}

	protected void onLoadEventListener() throws InstantiationException, IllegalAccessException {
		this.addEventListener(SybWorkEvents.SYBSTAFF, SybRecvStaffOnWorker.class);
		this.addEventListener(SybWorkEvents.SYBPATIENT, SybRecvPatientOnWorker.class);
		this.addEventListener(SybWorkEvents.SYBPOTHER, SybRecvPrescriptionOtherOnWorker.class);
		this.addEventListener(SybWorkEvents.SYBDEPARTMENT, SybRecvDepartmentOnWorker.class);
		this.addEventListener(SybWorkEvents.SYBWARDAREA, SybRecvWardareaOnWorker.class);
		this.addEventListener(SybWorkEvents.SYBPUSHXUETANG, SybPushXueTangOnWorker.class);
	}

	protected Object getBean(Class<?> bean) {
		return this.applicationContext.getBean(bean);
	}
}
