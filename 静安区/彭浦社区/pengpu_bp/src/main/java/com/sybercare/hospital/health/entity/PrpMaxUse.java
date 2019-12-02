package com.sybercare.hospital.health.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prpmaxuse")
public class PrpMaxUse implements java.io.Serializable {

	private static final long serialVersionUID = -3620335070309787836L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String groupno;

	private String maxno;

	private String tablename;
	/** 终端号 */
	private String ttyName;

	/** 标志字段 */
	private String flag;

	public PrpMaxUse() {
	}

	@Column(name = "ttyname")
	public String getTtyName() {
		return this.ttyName;
	}

	public void setTtyName(String ttyName) {
		this.ttyName = ttyName;
	}

	@Column(name = "flag")
	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	@Column(name = "groupno")
	public String getGroupno() {
		return groupno;
	}

	public void setGroupno(String groupno) {
		this.groupno = groupno;
	}

	@Column(name = "maxno")
	public String getMaxno() {
		return maxno;
	}

	public void setMaxno(String maxno) {
		this.maxno = maxno;
	}

	@Column(name = "tablename")
	public String getTablename() {
		return tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

}
