package com.sybercare.hospital.health.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sybercare.hospital.common.utils.IHibernateBaseDao;
import com.sybercare.hospital.health.entity.BloodGlucose;

@Repository
@Transactional
public class BloodGlucoseDAO {

	protected static final Logger LOGGER = LoggerFactory.getLogger(BloodGlucoseDAO.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private IHibernateBaseDao<BloodGlucose> hibernateBloodGlucoseDao;

	public List<BloodGlucose> getBloodGlucoseByOperateState(Integer operateState) {
		List<BloodGlucose> bloodGlucoses = null;
		try {
			bloodGlucoses = hibernateBloodGlucoseDao.getList(BloodGlucose.class, "operateState", operateState);
		} catch (Exception e) {
			LOGGER.debug("getBloodGlucoseByOperateState: " + e);
		}
		return bloodGlucoses;
	}
	
	public void updateBloodGlucoseOperateState(Long id, short operateState) {
		this.jdbcTemplate.update("update data_blood_glucose set operate_state = ? where id = ?", operateState, id);
	}

}
