package com.sybercare.hospital.adapters.worker.recv;

import java.util.Observable;

import com.sybercare.hospital.adapters.worker.data.HisDataEvents;

public class HisRecvDongGuanZhongYYOnWorker extends HisBaseRecvOnWorker{
	@Override
	public String versionName() {
		return String.valueOf("东莞中医院血糖数据上传实现");
	}

	@Override
	public void update(Observable o, Object arg) {
		super.update(o, arg);
	}

	@Override
	public Object dataSources() {
		return HisDataEvents.MSSQL;
	}
}
