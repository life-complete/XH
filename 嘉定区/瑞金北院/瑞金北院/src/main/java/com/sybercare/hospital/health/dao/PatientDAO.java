package com.sybercare.hospital.health.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sybercare.hospital.health.entity.*;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sybercare.hospital.common.utils.IHibernateBaseDao;

/**
 * 功能：患者数据处理
 *
 * @author 任梁荣
 * @version 创建时间：Sep 22, 2017 6:12:07 PM
 */
@Repository
@Transactional
public class PatientDAO {

	protected static final Logger LOGGER = LoggerFactory.getLogger(PatientDAO.class);

	@Autowired
	private IHibernateBaseDao<User> hibernateUserDao;

	@Autowired
	private IHibernateBaseDao<UserPatient> hibernateUserPatientDao;

	@Autowired
	private IHibernateBaseDao<LogInHospital> hibernateLogInHospitalDao;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public User readUserByPatientId(String patientId) {
		User user = null;
		try {
			if (StringUtils.isNotBlank(patientId)) {
				user = this.hibernateUserDao.get(User.class, "inHospitalId", patientId);
			}
		} catch (Exception e) {
			LOGGER.debug("readUserByPatientId: " + e);
		}
		return user;
	}

	public List<UserPatient> readUserPatientByStatus(Integer status) {
		List<UserPatient> userPatients = null;
		try {
			if (StringUtils.isNotBlank(String.valueOf(status))) {
				userPatients = this.hibernateUserPatientDao.getList(UserPatient.class, "update_status", status);
			}
		} catch (Exception e) {
			LOGGER.debug("readUserByCardNumber " + e);
		}
		return userPatients;
	}

	public User readUserByCardNumber(String cardNumber) {
		User user = null;
		try {
			if (StringUtils.isNotBlank(cardNumber)) {
				user = this.hibernateUserDao.get(User.class, "cardNumber", cardNumber);
			}
		} catch (Exception e) {
			LOGGER.debug("readUserByCardNumber " + e);
		}
		return user;
	}
	public List<User> readUserByCardNumber() {
		List<User>  user= new ArrayList();
		try {

				//user = this.hibernateUserDao.getList(User.class, "zylsh", "");
				//user=this.jdbcTemplate.query("select  user_id,card_number,employee_card from user where card_number is not null or card_number <> '' and LENGTH(card_number) <>18 and ISNULL(user_id_in) or user_id_in ='' ",(Object[]) null,new BeanPropertyRowMapper(User.class));
			user=this.jdbcTemplate.query("select  user_id,card_number,employee_card from user where  LENGTH(card_number)<18 and  identify_card<>''  and  (user_id_in ='' or ISNULL(user_id_in)) and  (card_number<>'' OR employee_card<> '')",(Object[]) null,new BeanPropertyRowMapper(User.class));
		} catch (Exception e) {
			LOGGER.debug("readUserByCardNumber " + e);
		}
		return user;
	}
	public void UpdateUserByUserId(User user) {
		try {

			this.hibernateUserDao.update(user);

		} catch (Exception e) {
			LOGGER.debug("readUserByCardNumber " + e);
		}
	}
	public UserPatient readUserPatientByUserId(String userId) {
		UserPatient userPatient = null;
		try {
			if (StringUtils.isNotBlank(userId)) {
				userPatient = this.hibernateUserPatientDao.get(UserPatient.class, "userId", userId);
			}
		} catch (Exception e) {
			LOGGER.debug("readUserPatientByUserId: " + e);
		}
		return userPatient;
	}

	/**
	 * 功能：新增患者基本信息
	 */
	public void saveUser(User user) {
		try {
			if (user != null) {
				this.hibernateUserDao.save(user);
			}
		} catch (Exception e) {
			LOGGER.debug("saveUser: " + e);
		}
	}

	/**
	 * 功能：新增患者入院信息
	 */
	public void saveUserPatient(UserPatient userPatient) {
		try {
			if (userPatient != null) {
				this.hibernateUserPatientDao.save(userPatient);
			}
		} catch (Exception e) {
			LOGGER.debug("saveUserPatient: " + e);
		}
	}

	/**
	 * 功能：新增患者入院信息
	 */
	public void saveLogInHospital(LogInHospital logInHospital) {
		try {
			if (logInHospital != null) {
				this.hibernateLogInHospitalDao.save(logInHospital);
			}
		} catch (Exception e) {
			LOGGER.debug("saveLogInHospital: " + e);
		}
	}

	public UserPatient readUserPatientByCardNumber(String cardNumber) {
		UserPatient userPatient = null;
		try {
			if (StringUtils.isNotBlank(cardNumber)) {
				userPatient = this.hibernateUserPatientDao.get(UserPatient.class, "cardNumber", cardNumber);
			}
		} catch (Exception e) {
			LOGGER.debug("readUserPatientByCardNumber: " + e);
		}
		return userPatient;
	}
	
	public UserPatient readUserPatientByPatientId(String patientId) {
		UserPatient userPatient = null;
		try {
			if (StringUtils.isNotBlank(patientId)) {
				userPatient = this.hibernateUserPatientDao.get(UserPatient.class, "inHospitalId", patientId);
			}
		} catch (Exception e) {
			LOGGER.debug("readUserPatientByPatientId: " + e);
		}
		return userPatient;
	}
	public void UpdataPatientInfo(UserPatient userPatient) {
		try {
			if (StringUtils.isNotBlank(userPatient.getUserId())) {
				this.hibernateUserPatientDao.update(userPatient);
			}
		} catch (Exception e) {
			LOGGER.debug("readUserPatientByPatientId: " + e);
		}
	}
	/**
	 * 功能：修改患者基本信息
	 */
	/*public void updateUserByUserId(User user) {*/
	public void updateUserByUserId(User user) {
		try {
			if (StringUtils.isNotBlank(user.getUserId())) {
				//this.hibernateUserDao.update(user);
				//this.jdbcTemplate.update("update  user set username=? where user_id=?",new Object[] {user.getName(),user.getUserId()});
				this.jdbcTemplate.update("update user set name=?,employee_card=?,user_id_in=?,card_time=? where user_id=?",new Object[] {user.getName(),user.getEmployee_card(),user.getUser_id_in(),user.getCard_time(),user.getUserId()});
			}
		} catch (Exception e) {
			LOGGER.debug("updateUserByUserId: " + e);
		}
	}
	
	/**
	 * 功能：修改患者基本信息
	 */
	
	public void updateUserByIdCard(User user) {
		try {
			if (StringUtils.isNotBlank(user.getIdentifyCard())) {
				this.hibernateUserDao.update(user);
			}
		} catch (Exception e) {
			LOGGER.debug("updateUserByIdCard: " + e);
		}
	}

	/**
	 * 功能：修改患者基本信息
	 */
	public void updateUserPatientByCardNumber(UserPatient userPatient) {
		try {
			if (StringUtils.isNotBlank(userPatient.getCardNumber())) {
				this.hibernateUserPatientDao.update(userPatient);
			}
		} catch (Exception e) {
			LOGGER.debug("updateUserPatientByCardNumber: " + e);
		}
	}

	public List<UserPatient> getUserPatientByInHospitalState(String state) {
		List<UserPatient> userPatientList = null;
		try {
			if (StringUtils.isNotBlank(state)) {
				userPatientList = this.hibernateUserPatientDao.getList(UserPatient.class, "inHospitalStatus", state);
			}
		} catch (Exception e) {
			LOGGER.debug("getUserPatientByInHospitalState: " + e);
		}
		return userPatientList;
	}
}
