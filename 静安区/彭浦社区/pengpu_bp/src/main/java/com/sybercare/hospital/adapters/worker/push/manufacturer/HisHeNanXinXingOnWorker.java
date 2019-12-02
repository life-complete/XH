package com.sybercare.hospital.adapters.worker.push.manufacturer;

import java.util.Observable;

import com.sybercare.hospital.adapters.worker.data.HisDataEvents;
import com.sybercare.hospital.adapters.worker.push.HisBasePushOnWorker;

/**
 * 功能：河南新星HIS厂商实现
 * 
 * @author 任梁荣
 * */
public class HisHeNanXinXingOnWorker extends HisBasePushOnWorker {

	@Override
	public void update(Observable o, Object arg) {
		super.setBasicDataOnWorker(this);
		super.update(o, arg);
	}

	@Override
	public String versionName() {
		return String.valueOf("河南新星HIS厂商");
	}

	@Override
	public HisDataEvents dataSources() {
		return HisDataEvents.MSSQL;
	}

}
