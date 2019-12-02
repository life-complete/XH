package com.hesicare.hospital.health.dao;

import com.hesicare.hospital.common.utils.IHibernateBaseDao;
import com.hesicare.hospital.health.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class PressureHeartDao {
    protected static final Logger LOGGER = LoggerFactory.getLogger(BloodPressureDAO.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private IHibernateBaseDao<Pressure_Heartbeat> hibernateheartbeatDao;
    @Autowired
    private IHibernateBaseDao<Glucose_Heartbeat> hibernateglucoseheartbeatDao;
    @Autowired
    private IHibernateBaseDao<Pressure_Heartbeat_End> hibernateheartbeatLastDao;
    public List<Pressure_Heartbeat>  getheartbeat() {
        List<Pressure_Heartbeat> pressure_heartbeats = null;
        try {
            //bloodPressures = hibernateBloodPressureDao.getListIsNotNull(BloodPressure.class,"idCard");
            pressure_heartbeats=hibernateheartbeatDao.getListIsNotNull(Pressure_Heartbeat.class,"id");
        } catch (Exception e) {
            LOGGER.debug("getBloodPressureByOperateState: " + e);
        }
        return pressure_heartbeats;
    }
    public List<Glucose_Heartbeat>  getglucoseheartbeat() {
        List<Glucose_Heartbeat> glucose_heartbeats = null;
        try {
            //bloodPressures = hibernateBloodPressureDao.getListIsNotNull(BloodPressure.class,"idCard");
            glucose_heartbeats=hibernateglucoseheartbeatDao.getListIsNotNull(Glucose_Heartbeat.class,"id");
        } catch (Exception e) {
            LOGGER.debug("getBloodPressureByOperateState: " + e);
        }
        return glucose_heartbeats;
    }
    public List<Pressure_Heartbeat_End>  getheartbeatLast() {
        List<Pressure_Heartbeat_End> pressure_heartbeats = null;
        try {
            pressure_heartbeats=hibernateheartbeatLastDao.getList(Pressure_Heartbeat_End.class,"","");

        } catch (Exception e) {
            LOGGER.debug("getBloodPressureByOperateState: " + e);
        }
        return pressure_heartbeats;
    }
    public void updateheartbeat(String id) {
        this.jdbcTemplate.update("update sys_blood_pressure set heart_status='1' where id=?",new Object[] {id});
    }
    public void updateglucoseheartbeat(String id) {
        this.jdbcTemplate.update("update sys_blood_glucose set heart_status='1' where id=?",new Object[] {id});
    }
}
