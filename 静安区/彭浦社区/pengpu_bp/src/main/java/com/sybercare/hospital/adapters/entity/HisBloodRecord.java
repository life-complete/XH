package com.sybercare.hospital.adapters.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 血糖记录 HisBlXiangmubcjl
 * @author wangzhi
 *
 */
public class HisBloodRecord {
    private BigDecimal jiluxh;

    private BigDecimal bingrenid;

    private String binganhao;

    private String mobanlx;

    private BigDecimal dwbh;

    private String xiangmusj;

    private BigDecimal zuixinbz;

    private Timestamp jilusj;

    private String jiluren;

    private String jilurxm;

    private String beizhu;

    private String xiugairen;

    private Timestamp xiugaisj;

    private String yingerid;

    private String yuanquid;

    private String caijisjd;

    private String mobanid;

    private String mobanlb;

    private String neirong;
    
    private String shujuly;//增加字段表示数据来源 2表示康之源

    public String getShujuly() {
		return shujuly;
	}

	public void setShujuly(String shujuly) {
		this.shujuly = shujuly;
	}

	public BigDecimal getJiluxh() {
        return jiluxh;
    }

    public void setJiluxh(BigDecimal jiluxh) {
        this.jiluxh = jiluxh;
    }

    public BigDecimal getBingrenid() {
        return bingrenid;
    }

    public void setBingrenid(BigDecimal bingrenid) {
        this.bingrenid = bingrenid;
    }

    public String getBinganhao() {
        return binganhao;
    }

    public void setBinganhao(String binganhao) {
        this.binganhao = binganhao;
    }

    public String getMobanlx() {
        return mobanlx;
    }

    public void setMobanlx(String mobanlx) {
        this.mobanlx = mobanlx;
    }

    public BigDecimal getDwbh() {
        return dwbh;
    }

    public void setDwbh(BigDecimal dwbh) {
        this.dwbh = dwbh;
    }

    public String getXiangmusj() {
        return xiangmusj;
    }

    public void setXiangmusj(String xiangmusj) {
        this.xiangmusj = xiangmusj;
    }

    public BigDecimal getZuixinbz() {
        return zuixinbz;
    }

    public void setZuixinbz(BigDecimal zuixinbz) {
        this.zuixinbz = zuixinbz;
    }

    public String getJiluren() {
        return jiluren;
    }

    public void setJiluren(String jiluren) {
        this.jiluren = jiluren;
    }

    public String getJilurxm() {
        return jilurxm;
    }

    public void setJilurxm(String jilurxm) {
        this.jilurxm = jilurxm;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    public String getXiugairen() {
        return xiugairen;
    }

    public void setXiugairen(String xiugairen) {
        this.xiugairen = xiugairen;
    }

    public String getYingerid() {
        return yingerid;
    }

    public void setYingerid(String yingerid) {
        this.yingerid = yingerid;
    }

    public String getYuanquid() {
        return yuanquid;
    }

    public void setYuanquid(String yuanquid) {
        this.yuanquid = yuanquid;
    }

    public String getCaijisjd() {
        return caijisjd;
    }

    public void setCaijisjd(String caijisjd) {
        this.caijisjd = caijisjd;
    }

    public String getMobanid() {
        return mobanid;
    }

    public void setMobanid(String mobanid) {
        this.mobanid = mobanid;
    }

    public String getMobanlb() {
        return mobanlb;
    }

    public void setMobanlb(String mobanlb) {
        this.mobanlb = mobanlb;
    }

    public String getNeirong() {
        return neirong;
    }

    public void setNeirong(String neirong) {
        this.neirong = neirong;
    }

	public Timestamp getJilusj() {
		return jilusj;
	}

	public void setJilusj(Timestamp jilusj) {
		this.jilusj = jilusj;
	}

	public Timestamp getXiugaisj() {
		return xiugaisj;
	}

	public void setXiugaisj(Timestamp xiugaisj) {
		this.xiugaisj = xiugaisj;
	}

	@Override
	public String toString() {
		return "HisBlXiangmubcjl [jiluxh=" + jiluxh + ", bingrenid=" + bingrenid + ", binganhao=" + binganhao
				+ ", mobanlx=" + mobanlx + ", dwbh=" + dwbh + ", xiangmusj=" + xiangmusj + ", zuixinbz=" + zuixinbz
				+ ", jilusj=" + jilusj + ", jiluren=" + jiluren + ", jilurxm=" + jilurxm + ", beizhu=" + beizhu
				+ ", xiugairen=" + xiugairen + ", xiugaisj=" + xiugaisj + ", yingerid=" + yingerid + ", yuanquid="
				+ yuanquid + ", caijisjd=" + caijisjd + ", mobanid=" + mobanid + ", mobanlb=" + mobanlb + ", neirong="
				+ neirong + "]";
	}
    
}