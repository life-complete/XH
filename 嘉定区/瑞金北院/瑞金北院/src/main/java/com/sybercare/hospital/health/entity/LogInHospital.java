package com.sybercare.hospital.health.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "log_in_hospital")
public class LogInHospital implements java.io.Serializable {
	
	private static final long serialVersionUID = 3685512407258149317L;

//	private String id;
	
	private Timestamp hospitalDate;

    private Timestamp dischargeDate;

    private String userId;

    private String hospitalizationNumber;

    private String doctorName;
    
    public LogInHospital() {
	}

    @Id
	@Column(name = "hospital_date")
	public Timestamp getHospitalDate() {
		return hospitalDate;
	}

	public void setHospitalDate(Timestamp hospitalDate) {
		this.hospitalDate = hospitalDate;
	}

	@Column(name = "discharge_date")
	public Timestamp getDischargeDate() {
		return dischargeDate;
	}

	public void setDischargeDate(Timestamp dischargeDate) {
		this.dischargeDate = dischargeDate;
	}

	@Column(name = "user_id")
	public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Column(name = "hospitalization_number")
    public String getHospitalizationNumber() {
        return hospitalizationNumber;
    }

    public void setHospitalizationNumber(String hospitalizationNumber) {
        this.hospitalizationNumber = hospitalizationNumber;
    }

    @Column(name = "doctor_name")
    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
}