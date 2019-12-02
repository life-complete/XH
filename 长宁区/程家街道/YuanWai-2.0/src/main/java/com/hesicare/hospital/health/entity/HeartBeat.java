package com.hesicare.hospital.health.entity;

public class HeartBeat {
    private String hostdevicecode;
    private String deviceCode;
    private String deviceType;
    private String hospatilid;
    private String hosttime;

    public String getHostdevicecode() {
        return hostdevicecode;
    }

    public void setHostdevicecode(String hostdevicecode) {
        this.hostdevicecode = hostdevicecode;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getHospatilid() {
        return hospatilid;
    }

    public void setHospatilid(String hospatilid) {
        this.hospatilid = hospatilid;
    }

    public String getHosttime() {
        return hosttime;
    }

    public void setHosttime(String hosttime) {
        this.hosttime = hosttime;
    }

    public String tostrinng(){
        return "{\"hostDeviceCode\""+":"+"\""+hostdevicecode+"\",\"deviceCode\":"+"\""+deviceCode+"\",\"devicetype\":"+"\""+deviceType+"\","+"\"hospatilid\""+":"+"\""+hospatilid+"\",\"hosttime\":"+"\""+hosttime+"\"}";
    }
}
