package com.sybercare.hospital.health.dao;

import com.sybercare.hospital.common.utils.IHibernateBaseDao;
import com.sybercare.hospital.health.entity.BloodGlucose;
import com.sybercare.hospital.health.entity.PatientBmiView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PatientBmiViewDao {
    protected static final Logger LOGGER = LoggerFactory.getLogger(BloodGlucoseDAO.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private IHibernateBaseDao<PatientBmiView> hibernateBmiDao;

    public List<PatientBmiView> getBmiByState(String operateState) {
        List<PatientBmiView> patientbmi = null;
        try {
            patientbmi = hibernateBmiDao.getList(PatientBmiView.class, "status", operateState);
        } catch (Exception e) {
            LOGGER.debug("getBloodGlucoseByOperateState: " + e);
        }
        return patientbmi;
    }

    public void updateBmiState(Long id, short operateState) {
        this.jdbcTemplate.update("update patient_bmi_view set status = ? where id = ?","1", id);
    }

}
