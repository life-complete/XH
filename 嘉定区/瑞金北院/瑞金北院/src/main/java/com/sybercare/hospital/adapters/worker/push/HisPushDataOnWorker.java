package com.sybercare.hospital.adapters.worker.push;

import com.sybercare.hospital.adapters.worker.data.HisDataEvents;
import com.sybercare.hospital.adapters.worker.data.HisDataManagers;
import com.sybercare.hospital.common.utils.IBeanParse;
import com.sybercare.hospital.common.utils.IDataOnWorker;
import com.sybercare.hospital.common.utils.WorkAutowired;
import com.sybercare.hospital.health.worker.SybWorkEvents;

/**
 * 功能：获取当前要处理的数据
 * 
 * @author 任梁荣
 * */
public abstract class HisPushDataOnWorker implements IBeanParse {

	@WorkAutowired
	private HisDataManagers dataManagers;

	@Override
	public String versionName() {
		return String.valueOf("基础默认实现");
	}

	/**
	 * 功能：加载需要处理的数据
	 * */
	@Override
	public Object loadData(Object woker, Object params) {
		if (this.dataSources() instanceof HisDataEvents) {
			HisDataEvents events = (HisDataEvents) this.dataSources();
			IDataOnWorker basicOnWorker = this.dataManagers.proxy(events);
			if (basicOnWorker != null && woker instanceof SybWorkEvents) {
				SybWorkEvents $woker = (SybWorkEvents) woker;
				Object obList = basicOnWorker.readData($woker, params);
				return this.analysis(obList, params, $woker);
			}
		}
		return null;
	}
}
