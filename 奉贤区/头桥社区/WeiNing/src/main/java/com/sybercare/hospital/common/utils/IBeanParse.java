package com.sybercare.hospital.common.utils;

public interface IBeanParse {

	/** 实现版本名称 */
	public String versionName();

	/** 获取数据 */
	public Object loadData(Object woker, Object params);

	/** 数据来源 */
	public Object dataSources();

	/** 格式编码 */
	public Object analysis(Object obList, Object params, Object woker);
}
