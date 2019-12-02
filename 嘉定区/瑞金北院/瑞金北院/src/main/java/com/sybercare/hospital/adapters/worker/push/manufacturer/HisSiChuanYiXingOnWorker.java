package com.sybercare.hospital.adapters.worker.push.manufacturer;

import java.util.Observable;

import com.sybercare.hospital.adapters.worker.data.HisDataEvents;
import com.sybercare.hospital.adapters.worker.push.HisBasePushOnWorker;

/**
 * 功能：四川医星HIS厂商对接业务实现
 * */
public class HisSiChuanYiXingOnWorker extends HisBasePushOnWorker {

	@Override
	public void update(Observable o, Object arg) {
		super.setBasicDataOnWorker(this);
		super.update(o, arg);
	}

	@Override
	public String versionName() {
		return String.valueOf("四川医星HIS厂商");
	}

	@Override
	public HisDataEvents dataSources() {
		return HisDataEvents.MSSQL;
	}

}
