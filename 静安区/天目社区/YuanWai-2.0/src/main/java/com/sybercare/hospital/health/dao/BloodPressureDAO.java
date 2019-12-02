package com.sybercare.hospital.health.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sybercare.hospital.common.utils.IHibernateBaseDao;
import com.sybercare.hospital.health.entity.BloodPressure;

@Repository
@Transactional
public class BloodPressureDAO {

	protected static final Logger LOGGER = LoggerFactory.getLogger(BloodPressureDAO.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private IHibernateBaseDao<BloodPressure> hibernateBloodPressureDao;

	public List<BloodPressure> getBloodPressureByOperateState(String data_status) {
		List<BloodPressure> bloodPressures = null;
		try {
			//bloodPressures = hibernateBloodPressureDao.getListIsNotNull(BloodPressure.class,"idCard");		
			bloodPressures = hibernateBloodPressureDao.getList(BloodPressure.class, "data_status", data_status);
			
		} catch (Exception e) {
			LOGGER.debug("getBloodPressureByOperateState: " + e);
		}
		return bloodPressures;
	}
	
	public List<BloodPressure> getBloodPressureByCardNumber() {
		List<BloodPressure> bloodPressures = null;
		try {
			bloodPressures = hibernateBloodPressureDao.getListIsNotNull(BloodPressure.class,"cardNumber");	
		} catch (Exception e) {
			LOGGER.debug("getBloodPressureByCardNumber: " + e);
		}
		return bloodPressures;
	}
	
	public List<BloodPressure> getBloodPressureByIdCard() {
		List<BloodPressure> bloodPressures = null;
		try {
			bloodPressures = hibernateBloodPressureDao.getListIsNotNull(BloodPressure.class,"idCard");	
	
			//bloodGlucoses = hibernateBloodPressureDao.getList(BloodPressure.class, "data_status", data_status);
		} catch (Exception e) {
			LOGGER.debug("getBloodPressureByIdCard: " + e);
		}
		return bloodPressures;
	}
	
	public void updateBloodGlucoseOperateState(Long id, short operateState) {
		this.jdbcTemplate.update("update patient_blood_pressure_view set status = ? where id = ?", operateState, id);
	}
	
	public void updateUserHandbyidCard(String hand, String idCard) {
		this.jdbcTemplate.update("update user set hand = ? where identify_card = ?", hand, idCard);
	}
	
	public void updateUserbyCardNumber(String idCard, String name, String hand, String cardNumber) {
		this.jdbcTemplate.update("update user set  identify_card = ? and name = ? and hand = ?and where identify_card = ?", hand, idCard);
	}
	

}
