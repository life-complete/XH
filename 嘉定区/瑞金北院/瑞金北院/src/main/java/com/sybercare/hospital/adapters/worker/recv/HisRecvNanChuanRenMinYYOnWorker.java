package com.sybercare.hospital.adapters.worker.recv;

import java.util.Observable;

import com.sybercare.hospital.adapters.worker.data.HisDataEvents;

public class HisRecvNanChuanRenMinYYOnWorker extends HisBaseRecvOnWorker {

	@Override
	public String versionName() {
		return String.valueOf("南川人民医院血糖数据上传实现");
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
