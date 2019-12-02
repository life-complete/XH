package com.hesicare.hospital.common.utils;
public enum HospitalEnum {
    hp_wt("外滩","42503639100"),
    hp_yy("豫园","42502884200"),
    hp_wl("五里桥","79705627000");
    private String name;
    private String comcode;
    private HospitalEnum(String name, String comcode){
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
        this.name = name;
    }
}
