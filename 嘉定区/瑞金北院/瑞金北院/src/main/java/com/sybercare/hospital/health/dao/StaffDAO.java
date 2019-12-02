package com.sybercare.hospital.health.dao;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sybercare.hospital.common.utils.IHibernateBaseDao;
import com.sybercare.hospital.health.entity.PrpMaxNo;
import com.sybercare.hospital.health.entity.PrpMaxUse;
import com.sybercare.hospital.health.entity.PrpSstaff;
import com.sybercare.hospital.health.entity.SaaUserGrade;
import com.sybercare.hospital.health.entity.StaffDuty;
import com.sybercare.hospital.health.entity.UtiKey;

@Repository
@Transactional
public class StaffDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private IHibernateBaseDao<PrpSstaff> hibernatePrpSstaffDao;
	@Autowired
	private IHibernateBaseDao<SaaUserGrade> hibernateSaaUserGradeDao;
	@Autowired
	private IHibernateBaseDao<StaffDuty> hibernateStaffDutyDao;
	@Autowired
	private IHibernateBaseDao<PrpMaxNo> hibernatePrpMaxNoDao;
	@Autowired
	private IHibernateBaseDao<PrpMaxUse> hibernatePrpMaxUseDao;

	@Autowired
	private IHibernateBaseDao<UtiKey> hibernateUtiKeyDao;

	public PrpSstaff readPrpSstaffByUserCode(String userCode) {
		PrpSstaff prpSstaff = null;
		try {
			if (StringUtils.isNotBlank(userCode)) {
				prpSstaff = this.hibernatePrpSstaffDao.get(PrpSstaff.class, "userCode", userCode);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prpSstaff;
	}
	public PrpSstaff readPrpSstaffByPersonID(String personID) {
		PrpSstaff prpSstaff = null;
		try {
			if (StringUtils.isNotBlank(personID)) {
				prpSstaff = this.hibernatePrpSstaffDao.get(PrpSstaff.class, "personID", personID);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prpSstaff;
	}

	public void savePrpSstaff(PrpSstaff prpSstaff) {
		try {
			if (prpSstaff != null) {
				this.hibernatePrpSstaffDao.save(prpSstaff);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updatePrpSstaff(PrpSstaff prpSstaff) {
		try {
			if (prpSstaff != null) {
				this.hibernatePrpSstaffDao.update(prpSstaff);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveSaaUserGrade(SaaUserGrade saaUserGrade) {
		try {
			if (saaUserGrade != null) {
				this.hibernateSaaUserGradeDao.save(saaUserGrade);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveStaffDuty(StaffDuty staffDuty) {
		try {
			if (staffDuty != null) {
				this.hibernateStaffDutyDao.save(staffDuty);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// public void savePrpMaxNo(PrpMaxNo prpMaxNo) {
	// try {
	// if (prpMaxNo != null) {
	// this.hibernatePrpMaxNoDao.save(prpMaxNo);
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// public void savePrpMaxUse(PrpMaxUse prpMaxUse) {
	// try {
	// if (prpMaxUse != null) {
	// this.hibernatePrpMaxUseDao.save(prpMaxUse);
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	public void deletePrpMaxUse(PrpMaxUse prpMaxUse) {
		try {
			if (prpMaxUse != null) {
				this.hibernatePrpMaxUseDao.delete(prpMaxUse);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	 * public void deletePrpMaxNo(PrpMaxNo prpMaxNo) { try { if (prpMaxNo !=
	 * null) { this.hibernatePrpMaxNoDao.delete(prpMaxNo); } } catch (Exception
	 * e) { e.printStackTrace(); } }
	 */

	public UtiKey readUtiKeyByTableName(String tableName) {
		UtiKey utiKey = null;
		try {
			if (StringUtils.isNotBlank(tableName)) {
				utiKey = this.hibernateUtiKeyDao.get(UtiKey.class, "tableName", tableName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return utiKey;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> selectMaxFromPrpMaxNo(Map<String, String> map) {
		Map<String, Object> maxNum = null;
		try {
			String sql = "select max(a.maxno) as max ,min(a.maxno) as min ,count(a.maxno) as count "
					+ "from prpmaxno a where a.groupno=:groupno and a.tablename=:tableName";
			Query query = this.hibernatePrpMaxNoDao.createSQLQuery(sql, map);
			// List<Map> list = query.list();
			List<Object> listResults = (List<Object>) query.list();
			if (null != listResults && listResults.size() > 0) {
				Object[] objects = (Object[]) listResults.get(0);
				if (objects.length >= 3) {
					maxNum = new HashMap<String, Object>();
					maxNum.put("max", objects[0]);
					maxNum.put("min", objects[1]);
					maxNum.put("count", objects[2]);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maxNum;
	}

	@SuppressWarnings("unchecked")
	public Map<String, String> selectMaxIdByPersonId(String personId) {
		Map<String, String> maxId = null;
		try {
			String sql = "select count(personID) as max from prpsstaff where personid = ?";
			Query query = this.hibernatePrpSstaffDao.createSQLQuery(sql, personId);
			List<BigInteger> listResults = (List<BigInteger>) query.list();
			if (null != listResults && listResults.size() > 0) {
				BigInteger objects = listResults.get(0);
				maxId = new HashMap<String, String>();
				maxId.put("max", String.valueOf(objects.toString()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maxId;
	}

	// @DynamicDataSourceAutowired(name = "his")
	public void savePrpMaxNo(PrpMaxNo prpmaxno) {
		this.jdbcTemplate.update("insert into prpmaxno(groupno, maxno, tablename, flag) values(?, ?, ?, ?)",
				prpmaxno.getGroupno(), prpmaxno.getMaxno(), prpmaxno.getTablename(), prpmaxno.getFlag());
	}

	public void savePrpMaxUse(PrpMaxUse prpmaxuse) {
		this.jdbcTemplate.update(
				"insert into prpmaxuse(groupno, maxno, tablename, ttyname, flag) values(?, ?, ?, ?, ?)",
				prpmaxuse.getGroupno(), prpmaxuse.getMaxno(), prpmaxuse.getTablename(), prpmaxuse.getTtyName(),
				prpmaxuse.getFlag());
	}

	public void deletePrpMaxNo(PrpMaxNo prpmaxno) {
		this.jdbcTemplate.update("delete from prpmaxno where groupno = ? and maxno = ? and tablename = ?",
				prpmaxno.getGroupno(), prpmaxno.getMaxno(), prpmaxno.getTablename());
	}
}
