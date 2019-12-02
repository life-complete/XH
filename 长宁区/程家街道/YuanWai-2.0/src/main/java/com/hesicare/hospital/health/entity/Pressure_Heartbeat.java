package com.hesicare.hospital.health.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "pressure_heartbeat")
public class Pressure_Heartbeat {
    private String id;
    private String mearsure_time;
    private String dept_name;
    private String equipment_sn;
    private String status;
    private String dept_id;
    @GenericGenerator(name = "generator", strategy = "identity")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "id", unique = true, nullable = false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @Column(name = "measure_time")
    public String getMearsure_time() {
        return mearsure_time;
    }

    public void setMearsure_time(String mearsure_time) {
        this.mearsure_time = mearsure_time;
    }
    @Column(name = "equipment_sn")
    public String getEquipment_sn() {
        return equipment_sn;
    }

    public void setEquipment_sn(String equipment_sn) {
        this.equipment_sn = equipment_sn;
    }
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    @Column(name = "dept_id")

    public String getDept_id() {
        return dept_id;
    }

    public void setDept_id(String dept_id) {
        this.dept_id = dept_id;
    }
    @Column(name = "dept_name")
    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }
}
