package com.hesicare.hospital.health.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 患者疾病及生活方式表 sys_patient_other_info
 * 
 * @author hesicare
 * @date 2019-08-19
 */
public class SysPatientOtherInfo extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键id */
	private Long id;
	/** 患者id */
	private Long patientId;
	/** 既往史 json格式*/
	private String pastHistory;
	/** 家族史json格式 */
	private String familyHistory;
	/** 药物禁忌 json格式
	 * */
	private String drugTaboos;
	
	
	/**  吸烟 0无 1偶尔(每周1根以上) 2 经常(每周10根以上) 3 过量(每周20根以上) */
	private String smoking;
	/** 饮酒 0 无 1偶尔(每周1次以上) 2经常(每周4次以上) 3过量(每周20瓶以上) */
	private String drink;
	/** 运动0无1 偶尔(每周1次以上)2经常(每周2次以上)3过量(每周4次以上) */
	private String sport;
	/** 主要运动方式 */
	private String sportRemark;
	/** 用户类型 bloodPressure高血压 bloodGlucos糖尿病 heart心血管疾病 other其他 */
	private String userType;

	
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setPatientId(Long patientId) 
	{
		this.patientId = patientId;
	}

	public Long getPatientId() 
	{
		return patientId;
	}
	public void setPastHistory(String pastHistory) 
	{
		this.pastHistory = pastHistory;
	}

	public String getPastHistory() 
	{
		return pastHistory;
	}
	public void setFamilyHistory(String familyHistory) 
	{
		this.familyHistory = familyHistory;
	}

	public String getFamilyHistory() 
	{
		return familyHistory;
	}
	public void setDrugTaboos(String drugTaboos) 
	{
		this.drugTaboos = drugTaboos;
	}

	public String getDrugTaboos() 
	{
		return drugTaboos;
	}
	public void setSmoking(String smoking) 
	{
		this.smoking = smoking;
	}

	public String getSmoking() 
	{
		return smoking;
	}
	public void setDrink(String drink) 
	{
		this.drink = drink;
	}

	public String getDrink() 
	{
		return drink;
	}
	public void setSport(String sport) 
	{
		this.sport = sport;
	}

	public String getSport() 
	{
		return sport;
	}
	public void setSportRemark(String sportRemark) 
	{
		this.sportRemark = sportRemark;
	}

	public String getSportRemark() 
	{
		return sportRemark;
	}

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("patientId", getPatientId())
            .append("pastHistory", getPastHistory())
            .append("familyHistory", getFamilyHistory())
            .append("drugTaboos", getDrugTaboos())
            .append("smoking", getSmoking())
            .append("drink", getDrink())
            .append("sport", getSport())
            .append("sportRemark", getSportRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
