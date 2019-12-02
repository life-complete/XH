package com.sybercare.hospital.common.utils;

public interface IDataOnWorker {

	/** 版本名称 */
	public String versionName();

	/** 获取同步数据 */
	public Object readData(Object woker, Object params);

	/** 接收推送数据 */
	public boolean recvData(Object args);
}
