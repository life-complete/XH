package com.sybercare.hospital.common.jobs;

public class PressureVo {
    private Number id;
    private String  pid;
    private Number systolic;
    private Number diastolic;
    private Number pluse;
    private String measure_time;
    private String operate_type;

    public Number getId() {
        return id;
    }

    public void setId(Number id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public Number getSystolic() {
        return systolic;
    }

    public void setSystolic(Number systolic) {
        this.systolic = systolic;
    }

    public Number getDiastolic() {
        return diastolic;
    }

    public void setDiastolic(Number diastolic) {
        this.diastolic = diastolic;
    }

    public Number getPluse() {
        return pluse;
    }

    public void setPluse(Number pluse) {
        this.pluse = pluse;
    }

    public String getMeasure_time() {
        return measure_time;
    }

    public void setMeasure_time(String measure_time) {
        this.measure_time = measure_time;
    }

    public String getOperate_type() {
        return operate_type;
    }

    public void setOperate_type(String operate_type) {
        this.operate_type = operate_type;
    }
}
