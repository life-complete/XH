package com.sybercare.hospital.adapters.worker;

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

import com.sybercare.hospital.adapters.worker.push.HisBasePushOnWorker;
import com.sybercare.hospital.adapters.worker.push.hospital.HisPushChiFengYiYuan;
import com.sybercare.hospital.adapters.worker.push.hospital.HisPushCiXiOnWorker;
import com.sybercare.hospital.adapters.worker.push.hospital.HisPushDaQingOnWorker;
import com.sybercare.hospital.adapters.worker.push.hospital.HisPushDongGuanZhongYiYuanOnWork;
import com.sybercare.hospital.adapters.worker.push.hospital.HisPushMianYangSanYuanOnWorker;
import com.sybercare.hospital.adapters.worker.push.hospital.HisPushMuDanJiangOnWorker;
import com.sybercare.hospital.adapters.worker.push.hospital.HisPushNanChuanRenMinYiYuanOnWork;
import com.sybercare.hospital.adapters.worker.push.hospital.HisPushQiXiaZhongYiYuanOnWork;
import com.sybercare.hospital.adapters.worker.push.hospital.HisPushWenZhouYiYuanOnWorker;
import com.sybercare.hospital.adapters.worker.push.hospital.HisPushEEDuoSiZXYiYuanOnWorker;
import com.sybercare.hospital.adapters.worker.push.hospital.HisPushGeJiuYiYuan;
import com.sybercare.hospital.adapters.worker.push.hospital.HisPushHaShiYiYuan;
import com.sybercare.hospital.adapters.worker.push.hospital.HisPushLiJinYiYuan;
import com.sybercare.hospital.adapters.worker.push.hospital.HisPushXinHuaOnWorker;
import com.sybercare.hospital.adapters.worker.push.hospital.HisPushXiNingHaiHuOnWorker;
import com.sybercare.hospital.adapters.worker.push.hospital.HisPushTaiAnZXYYOnWorker;
import com.sybercare.hospital.adapters.worker.push.manufacturer.HisHeNanXinXingOnWorker;
import com.sybercare.hospital.adapters.worker.push.manufacturer.HisSiChuanYiXingOnWorker;
import com.sybercare.hospital.adapters.worker.push.manufacturer.HisTianPengHengYuOnWorker;
import com.sybercare.hospital.adapters.worker.recv.HisRecvDongGuanZhongYYOnWorker;
import com.sybercare.hospital.adapters.worker.recv.HisRecvDongHuaOnWorker;
import com.sybercare.hospital.adapters.worker.recv.HisRecvMianYangSanYuanOnWorker;
import com.sybercare.hospital.adapters.worker.recv.HisRecvNanChuanRenMinYYOnWorker;
import com.sybercare.hospital.adapters.worker.recv.HisRecvWenZhouYiYuanOnWorker;
import com.sybercare.hospital.common.utils.BaseObservable;
import com.sybercare.hospital.common.utils.BaseObserver;
import com.sybercare.hospital.common.utils.WorkAutowired;

/**
 * 功能：HIS医院
 * 
 * @author 任梁荣
 */
@Component
public class HisWorkManagers {

	@Autowired
	private ApplicationContext applicationContext;

	protected static final Logger logger = LoggerFactory.getLogger(HisWorkManagers.class);
	public static ConcurrentHashMap<HisWorkEvents, BaseObservable> events = new ConcurrentHashMap<HisWorkEvents, BaseObservable>();

	public synchronized boolean onEvents(HisWorkEvents names, Object... args) {
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
	protected boolean addEventListener(HisWorkEvents names, Class clazz)
			throws InstantiationException, IllegalAccessException {
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
		this.addEventListener(HisWorkEvents.HISBASIC, HisBasePushOnWorker.class);
		this.addEventListener(HisWorkEvents.HISCIXI, HisPushCiXiOnWorker.class);
		this.addEventListener(HisWorkEvents.HISDAQING, HisPushDaQingOnWorker.class);
		this.addEventListener(HisWorkEvents.HISMUDANJIANG, HisPushMuDanJiangOnWorker.class);
		this.addEventListener(HisWorkEvents.HISXINHUA, HisPushXinHuaOnWorker.class);
		this.addEventListener(HisWorkEvents.HISHENANXINXING, HisHeNanXinXingOnWorker.class);
		this.addEventListener(HisWorkEvents.HISSICHUANYIXING, HisSiChuanYiXingOnWorker.class);
		this.addEventListener(HisWorkEvents.HISTIANPENGHENGYU, HisTianPengHengYuOnWorker.class);
		this.addEventListener(HisWorkEvents.HISRECVDONGHUA, HisRecvDongHuaOnWorker.class);
		this.addEventListener(HisWorkEvents.HISPUSHMIANYANGSANYUAN, HisPushMianYangSanYuanOnWorker.class);
		this.addEventListener(HisWorkEvents.HISRECVMIANYANGSANYUAN, HisRecvMianYangSanYuanOnWorker.class);
		this.addEventListener(HisWorkEvents.HISPUSHWENZHOUYIYUAN, HisPushWenZhouYiYuanOnWorker.class);
		this.addEventListener(HisWorkEvents.HISRECVWENZHOUYIYUAN, HisRecvWenZhouYiYuanOnWorker.class);
		this.addEventListener(HisWorkEvents.HISPUSHEEDUOSIZXYIYUAN, HisPushEEDuoSiZXYiYuanOnWorker.class);
		this.addEventListener(HisWorkEvents.HISPUSHXININGHAIHU, HisPushXiNingHaiHuOnWorker.class);
		this.addEventListener(HisWorkEvents.HISPUSHTAIANZXYY, HisPushTaiAnZXYYOnWorker.class);
		this.addEventListener(HisWorkEvents.HISPUSHLIJINYIYUAN, HisPushLiJinYiYuan.class);
		this.addEventListener(HisWorkEvents.HISPUSHCHIFENGYIYUAN, HisPushChiFengYiYuan.class);
		this.addEventListener(HisWorkEvents.HISPUSHGEJIUYIYUAN, HisPushGeJiuYiYuan.class);
		this.addEventListener(HisWorkEvents.HISPUSHHASHIYIYUAN, HisPushHaShiYiYuan.class);
		this.addEventListener(HisWorkEvents.HISPUSHNANCHUANRenMinYIYUAN, HisPushNanChuanRenMinYiYuanOnWork.class);
		this.addEventListener(HisWorkEvents.HISPUSHQIXIAZHONGYIYUAN, HisPushQiXiaZhongYiYuanOnWork.class);
		this.addEventListener(HisWorkEvents.HISRECVNANCHUANRENMINYIYUAN, HisRecvNanChuanRenMinYYOnWorker.class);
		//东莞中YY
		this.addEventListener(HisWorkEvents.HISPUSHDONGGUANZHONGYIYUAN, HisPushDongGuanZhongYiYuanOnWork.class);
		this.addEventListener(HisWorkEvents.HISRECVDONGGUANZHONGYIYUAN, HisRecvDongGuanZhongYYOnWorker.class);
	}

	protected Object getBean(Class<?> bean) {
		return this.applicationContext.getBean(bean);
	}
}
