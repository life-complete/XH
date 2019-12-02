package com.sybercare.hospital.adapters.worker.data;

import java.util.List;

import com.sybercare.hospital.adapters.service.ITuserService;
import com.sybercare.hospital.common.utils.IDataOnWorker;
import com.sybercare.hospital.common.utils.WorkAutowired;

/**
 * 功能：HIS对接业务实现,MYSQL版
 * 
 * @author 任梁荣
 * */
public class HisDataMySqlOnWorker implements IDataOnWorker {

	@WorkAutowired
	private ITuserService tuserService;

	@Override
	public String versionName() {
		return String.valueOf("MYSQL实现版本");
	}

	/**
	 * 功能：用于推送读取数据库
	 * */
	@Override
	public List<?> readData(Object woker, Object params) {
		return this.tuserService.readTuserList();
	}

	/**
	 * 功能：接收到数据写入数据库
	 * */
	@Override
	public boolean recvData(Object args) {

		return false;
	}
}
