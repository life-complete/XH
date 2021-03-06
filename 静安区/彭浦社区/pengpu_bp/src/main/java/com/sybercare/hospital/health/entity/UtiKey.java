package com.sybercare.hospital.health.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UtiKey generated by Tools.Don't edit.
 */
@Entity
@Table(name = "utikey")
public class UtiKey implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 表名 */
	private String tableName;

	/** 字段名 */
	private String fieldName;

	/** 名称 */
	private String fieldMeaning;

	/** 单号长度 */
	private Integer colLength;

	/** 单号首字符 */
	private String headId;

	/** 标志字段 */
	private String flag;

	public UtiKey() {
	}

	/**       
	 * 表名
	 */
	@Id
	@Column(name = "tablename")
	public String getTableName() {
		return this.tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**       
	 * 字段名
	 */

	@Column(name = "fieldname")
	public String getFieldName() {
		return this.fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	/**       
	 * 名称
	 */

	@Column(name = "fieldmeaning")
	public String getFieldMeaning() {
		return this.fieldMeaning;
	}

	public void setFieldMeaning(String fieldMeaning) {
		this.fieldMeaning = fieldMeaning;
	}

	/**       
	 * 单号长度
	 */

	@Column(name = "collength")
	public Integer getColLength() {
		return this.colLength;
	}

	public void setColLength(Integer colLength) {
		this.colLength = colLength;
	}

	/**       
	 * 单号首字符
	 */

	@Column(name = "headid")
	public String getHeadId() {
		return this.headId;
	}

	public void setHeadId(String headId) {
		this.headId = headId;
	}

	/**       
	 * 标志字段
	 */

	@Column(name = "flag")
	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

}
