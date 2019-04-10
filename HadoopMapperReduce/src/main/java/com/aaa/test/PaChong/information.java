package com.aaa.test.PaChong;

public class information {
    private String jobname;//工作名称
    private String company;//公司名称
    private String address;//公司地点
    private String money;//薪资
    private String msdate;//面试时间
    private Long Requirement;//能力要求

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getMsdate() {
        return msdate;
    }

    public void setMsdate(String msdate) {
        this.msdate = msdate;
    }

    public Long getRequirement() {
        return Requirement;
    }

    public void setRequirement(Long requirement) {
        Requirement = requirement;
    }

    public  void information(String jobname, String company, String address, String money, String msdate, Long requirement) {
        this.jobname = jobname;
        this.company = company;
        this.address = address;
        this.money = money;
        this.msdate = msdate;
        Requirement = requirement;
    }
}
