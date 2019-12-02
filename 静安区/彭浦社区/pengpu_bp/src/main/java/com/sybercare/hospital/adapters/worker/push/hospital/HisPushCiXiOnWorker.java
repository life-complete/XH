package com.sybercare.hospital.adapters.worker.push.hospital;

import java.util.Observable;

import com.sybercare.hospital.adapters.worker.push.HisBasePushOnWorker;

/**
 * 功能：慈溪HIS对接业务逻辑实现
 * 
 * @author 任梁荣
 * */
public class HisPushCiXiOnWorker extends HisBasePushOnWorker {

	@Override
	public String versionName() {
		return String.valueOf("慈溪人民医院");
	}

	@Override
	public void update(Observable o, Object arg) {
		super.setBasicDataOnWorker(this);
		super.update(o, arg);
	}
}
