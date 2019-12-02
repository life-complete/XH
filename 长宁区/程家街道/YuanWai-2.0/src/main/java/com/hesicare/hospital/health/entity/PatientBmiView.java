package com.hesicare.hospital.health.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
//@Table(name = "data_blood_glucose_clinic")
@Table(name = "patient_bmi_view")
public class PatientBmiView implements java.io.Serializable{
    private Long id;
    private String idcard;
    private String height;
    private String weight;
    private String mearsuretime;
    private String status;
    private String deptid;
    @GenericGenerator(name = "generator", strategy = "identity")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Column(name = "idcard")

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }
    @Column(name = "hight")
    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
    @Column(name = "weight")
    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
    @Column(name = "mearsure_time")

    public String getMearsuretime() {
        return mearsuretime;
    }

    public void setMearsuretime(String mearsuretime) {
        this.mearsuretime = mearsuretime;
    }
    @Column(name = "status")

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    @Column(name = "deptid")
    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid;
    }
}
