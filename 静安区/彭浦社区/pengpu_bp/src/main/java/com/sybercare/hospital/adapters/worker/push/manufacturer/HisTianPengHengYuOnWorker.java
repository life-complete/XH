package com.sybercare.hospital.adapters.worker.push.manufacturer;

import java.util.Observable;

import com.sybercare.hospital.adapters.worker.data.HisDataEvents;
import com.sybercare.hospital.adapters.worker.push.HisBasePushOnWorker;

/**
 * 功能：北京天鹏恒宇HIS厂商业务对接实现
 * */
public class HisTianPengHengYuOnWorker extends HisBasePushOnWorker {

	@Override
	public void update(Observable o, Object arg) {
		super.setBasicDataOnWorker(this);
		super.update(o, arg);
	}

	@Override
	public String versionName() {
		return String.valueOf("北京天鹏恒宇HIS厂商");
	}

	@Override
	public HisDataEvents dataSources() {
		return HisDataEvents.ORACLE;
	}

}
