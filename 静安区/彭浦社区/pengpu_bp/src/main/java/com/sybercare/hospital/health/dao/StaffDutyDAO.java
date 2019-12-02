package com.sybercare.hospital.health.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sybercare.hospital.common.utils.IHibernateBaseDao;
import com.sybercare.hospital.health.entity.StaffDuty;

/**
 * 功能：员工职责数据处理
 *
 * @author 任梁荣
 * @version 创建时间：Sep 21, 2017 3:48:26 PM
 */
@Repository
@Transactional
public class StaffDutyDAO {

	@Autowired
	private IHibernateBaseDao<StaffDuty> hibernateBaseDao;

	public void deleteStaffDuty(String personID) {
		if (StringUtils.isNotBlank(personID)) {
			List<StaffDuty> staffDutyList = hibernateBaseDao.getList(StaffDuty.class, "personid", personID);
			if (null != staffDutyList && staffDutyList.size() > 0) {
				for (StaffDuty staffDuty : staffDutyList) {
					this.hibernateBaseDao.delete(staffDuty);
				}
			}
		}
	}

	public void save(StaffDuty duty) {
		if (null != duty) {
			this.hibernateBaseDao.save(duty);
		}
	}

}
