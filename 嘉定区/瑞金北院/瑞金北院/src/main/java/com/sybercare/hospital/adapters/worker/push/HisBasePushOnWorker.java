package com.sybercare.hospital.adapters.worker.push;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import com.sybercare.hospital.adapters.worker.data.HisDataEvents;
import com.sybercare.hospital.common.utils.BaseObserver;
import com.sybercare.hospital.common.utils.Constants;
import com.sybercare.hospital.common.utils.WorkAutowired;
import com.sybercare.hospital.health.worker.SybWorkEvents;
import com.sybercare.hospital.health.worker.SybWorkManagers;

/**
 * 功能：HIS对接业务,康之元默认版
 * 
 * @author 任梁荣
 * */
public class HisBasePushOnWorker extends HisPushDataOnWorker implements BaseObserver {

	@WorkAutowired
	private SybWorkManagers sybWorkManagers;
	private HisPushDataOnWorker basicDataOnWorker;

	@Override
	public String versionName() {
		return String.valueOf("康之元默认实现版本");
	}

	@Override
	public HisDataEvents dataSources() {
		return HisDataEvents.MYSQL;
	}

	@Override
	public void update(Observable o, Object arg) {
		this.setBasicDataOnWorker(this);
		Object[] args = (Object[]) arg;
		if (args != null && args.length > 0) {
			SybWorkEvents events = SybWorkEvents.nvalueOf(args[0].toString());
			List<String> params = new ArrayList<String>();
			if (Constants.params.containsKey(events)) {
				params = Constants.params.get(events);
			}
			if (params.size() > 0) {
				for (String p : params) {
					this.sybWorkManagers.onEvents(events, this.basicDataOnWorker.loadData(events, p), events);
				}
			} else {
				this.sybWorkManagers.onEvents(events, this.basicDataOnWorker.loadData(events, null), events);
			}
		}
	}

	@Override
	public Object analysis(Object obList, Object params, Object woker) {
		return obList;
	}

	public HisPushDataOnWorker getBasicDataOnWorker() {
		return basicDataOnWorker;
	}

	public void setBasicDataOnWorker(HisPushDataOnWorker basicDataOnWorker) {
		this.basicDataOnWorker = basicDataOnWorker;
	}
}
