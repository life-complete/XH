package com.sybercare.hospital.health.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prpmaxno")
public class PrpMaxNo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 标志字段 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String flag;

	private String prpmaxno;

	private String groupno;

	private String maxno;

	private String tablename;

	public PrpMaxNo() {
	}

	@Column(name = "flag")
	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	@Column(name = "prpmaxno")
	public String getPrpmaxno() {
		return prpmaxno;
	}

	public void setPrpmaxno(String prpmaxno) {
		this.prpmaxno = prpmaxno;
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
