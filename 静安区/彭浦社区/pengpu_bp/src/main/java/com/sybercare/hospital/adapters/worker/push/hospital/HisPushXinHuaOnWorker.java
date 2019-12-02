package com.sybercare.hospital.adapters.worker.push.hospital;

import java.util.Observable;

import com.sybercare.hospital.adapters.worker.push.manufacturer.HisSiChuanYiXingOnWorker;

/**
 * 功能：崇明新华HIS对接业务实现
 * 
 * @author 任梁荣
 * */
public class HisPushXinHuaOnWorker extends HisSiChuanYiXingOnWorker {

	@Override
	public void update(Observable o, Object arg) {
		super.setBasicDataOnWorker(this);
		super.update(o, arg);
	}

	@Override
	public String versionName() {
		return String.valueOf("崇明新华医院");
	}
}
