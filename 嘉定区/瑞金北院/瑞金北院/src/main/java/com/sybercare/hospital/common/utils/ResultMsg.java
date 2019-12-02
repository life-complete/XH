package com.sybercare.hospital.common.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能：接口返回数据结构
 * 
 * @author 任梁荣 2017-04-05
 * */
public class ResultMsg implements Serializable {

	private static final long serialVersionUID = 4268580517239051068L;

	/** 反馈状态码 */
	private String syb_status;
	/** 反馈信息 */
	private String syb_info;
	/** 返回数据结构 */
	private List<Object> syb_data = new ArrayList<Object>();

	public String getSyb_status() {
		return syb_status;
	}

	public void setSyb_status(String syb_status) {
		this.syb_status = syb_status;
	}

	public String getSyb_info() {
		return syb_info;
	}

	public void setSyb_info(String syb_info) {
		this.syb_info = syb_info;
	}

	public List<Object> getSyb_data() {
		return syb_data;
	}

	public void setSyb_data(List<Object> syb_data) {
		this.syb_data = syb_data;
	}
}
