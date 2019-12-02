package com.sybercare.hospital.common.utils;
public enum HospitalEnum {
    ja_lf("http://192.168.9.114:9071","临汾","42508125600","/measure/api/patSignSubmit","/measure/api/patSignSubmit","code","1"),
    ja_tm("http://192.168.9.114:9071","天目","79569710300","/measure/api/chronic/submit","/measure/api/patSignSubmit","errno","0");
    private String url;
    private String name;
    private String comcode;
    private String bptype;
    private String othertype;
    private String resultname;
    private String resultnum;
    private HospitalEnum(String url, String name, String comcode, String bptype, String othertype,String resultname,String resultnum){
        this.url=url;
        this.name=name;
        this.comcode=comcode;
        this.bptype=bptype;
        this.othertype=othertype;
        this.resultname=resultname;
        this.resultnum=resultnum;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getComcode() {
        return comcode;
    }

    public void setComcode(String comcode) {
        this.comcode = comcode;
    }


    public String getBptype() {
        return bptype;
    }

    public void setBptype(String bptype) {
        this.bptype = bptype;
    }

    public String getOthertype() {
        return othertype;
    }

    public void setOthertype(String othertype) {
        this.othertype = othertype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResultname() {
        return resultname;
    }

    public void setResultname(String resultname) {
        this.resultname = resultname;
    }

    public String getResultnum() {
        return resultnum;
    }

    public void setResultnum(String resultnum) {
        this.resultnum = resultnum;
    }
}
