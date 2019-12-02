package com.sybercare.hospital.adapters.worker.recv;

import java.util.Observable;

import com.sybercare.hospital.adapters.worker.data.HisDataEvents;

/**
 * 功能：接收血糖数据
 *
 * @author 任梁荣
 * @version 创建时间：Sep 22, 2017 4:40:43 PM
 * */
public class HisRecvWenZhouYiYuanOnWorker extends HisBaseRecvOnWorker {

	@Override
	public String versionName() {
		return String.valueOf("温州一院血糖数据上传实现");
	}

	@Override
	public void update(Observable o, Object arg) {
		super.update(o, arg);
	}

	@Override
	public Object dataSources() {
		return HisDataEvents.ORACLE;
	}

}
