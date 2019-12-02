package com.hesicare.hospital.common.utils;
public enum HospitalEnum {
    yp_yh("殷航社区","42508581200");
    /*cn_ts("天山","42505239100"),
    cn_hq("虹桥","68403988800"),
    cn_cj("程家","42503452100"),
    cn_zjq("周家桥","22985100300"),
    cn_js("江苏","42503317400"),*/
            ;
    private String comcode;
    private String name;
    private HospitalEnum(String name,String comcode){
        this.name=name;
        this.comcode=comcode;

    }

    public String getComcode() {
        return comcode;
    }

    public void setComcode(String comcode) {
        this.comcode = comcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name= name;
    }
}
