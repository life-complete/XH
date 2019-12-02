package com.sybercare.hospital.adapters.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 功能：信息更新表
 * 
 * @author 任梁荣
 * */
public class HisDataChangeRecord implements Serializable {

	private static final long serialVersionUID = 7134821469757990131L;

	/** 消息id */
	private BigDecimal id;
	/** 操作的数据表名称 */
	private String dataName;
	/** 操作类型(1：增加2：修改3：删除) */
	private BigDecimal operation;
	/** 操作表主键取值(对应操作表的主键取值) */
	private String keyWord;
	/** 操作表主键取值扩展(对应操作表主键不唯一，联合主键使用) */
	private String keyWordExt;
	/** 同步状态(0：未处理1：已处理2、失败) */
	private BigDecimal processState;
	/** 同步时间(格式：2016-01-01 10:20:21) */
	private Date timestamp;
	/** 备注 */
	private String remark;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getDataName() {
		return dataName;
	}

	public void setDataName(String dataName) {
		this.dataName = dataName;
	}

	public BigDecimal getOperation() {
		return operation;
	}

	public void setOperation(BigDecimal operation) {
		this.operation = operation;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public String getKeyWordExt() {
		return keyWordExt;
	}

	public void setKeyWordExt(String keyWordExt) {
		this.keyWordExt = keyWordExt;
	}

	public BigDecimal getProcessState() {
		return processState;
	}

	public void setProcessState(BigDecimal processState) {
		this.processState = processState;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}