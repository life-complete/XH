package com.sybercare.hospital.common.utils;
/**
 * 自定义通用用户异常
 * 
 * @author GZW
 * @since 2010.10.11
 */
public class UserException extends Exception {

	private static final long serialVersionUID = -118202675280995465L;

	private int errorCatalog;// 错误目录
	private int errorNo;// 错误编号
	private String errorModule;// 所属单元

	public UserException(String errorMessage) {
		super(errorMessage);
	}

	public UserException(int errorCatalog, int errorNo, String errorModule,
			String errorMessage) {
		super(errorMessage);
		this.errorCatalog = errorCatalog;
		this.errorNo = errorNo;
		this.errorModule = errorModule;
	}

	public int getErrorCatalog() {
		return errorCatalog;
	}

	public int getErrorNo() {
		return errorNo;
	}

	public String getErrorModule() {
		return errorModule;
	}

}

