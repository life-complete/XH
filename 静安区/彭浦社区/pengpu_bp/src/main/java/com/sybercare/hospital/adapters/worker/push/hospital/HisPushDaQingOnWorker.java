package com.sybercare.hospital.adapters.worker.push.hospital;

import java.util.Observable;

import com.sybercare.hospital.adapters.worker.push.manufacturer.HisTianPengHengYuOnWorker;

/**
 * 功能：大庆HIS对接业务实现
 * */
public class HisPushDaQingOnWorker extends HisTianPengHengYuOnWorker {

	@Override
	public void update(Observable o, Object arg) {
		super.setBasicDataOnWorker(this);
		super.update(o, arg);
	}

	@Override
	public String versionName() {
		return String.valueOf("大庆HIS");
	}

}
