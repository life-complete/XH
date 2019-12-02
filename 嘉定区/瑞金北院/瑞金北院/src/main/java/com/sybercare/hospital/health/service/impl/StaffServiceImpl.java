package com.sybercare.hospital.health.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sybercare.hospital.adapters.entity.HisStaff;
import com.sybercare.hospital.common.utils.DateUtils;
import com.sybercare.hospital.common.utils.MD5;
import com.sybercare.hospital.health.dao.CompanyDAO;
import com.sybercare.hospital.health.dao.PrpsStaffDAO;
import com.sybercare.hospital.health.dao.StaffDAO;
import com.sybercare.hospital.health.dao.StaffDutyDAO;
import com.sybercare.hospital.health.entity.PrpMaxNo;
import com.sybercare.hospital.health.entity.PrpMaxUse;
import com.sybercare.hospital.health.entity.PrpScompany;
import com.sybercare.hospital.health.entity.PrpSstaff;
import com.sybercare.hospital.health.entity.SaaUserGrade;
import com.sybercare.hospital.health.entity.StaffDuty;
import com.sybercare.hospital.health.entity.UtiKey;
import com.sybercare.hospital.health.service.IStaffService;

/**
 * 功能：处理医院人员信息
 * 
 * @author 任梁荣
 */
@Service("staffService")
public class StaffServiceImpl implements IStaffService {

	@Autowired
	private StaffDAO staffDAO;
	@Autowired
	private PrpsStaffDAO prpsStaffDAO;
	@Autowired
	private StaffDutyDAO staffDutyDAO;
	@Autowired
	private CompanyDAO companyDAO;

	@Value("${custom.hospital.default.comcode}")
	private String comcode;

	@Value("${custom.hospital.default.department}")
	private String department;

	protected static final Logger LOGGER = LoggerFactory.getLogger(StaffServiceImpl.class);

	@Override
	public List<?> readTuserByMaxIds() {
		return this.prpsStaffDAO.findTuser();
	}

	/**
	 * 功能：处理医院人员信息
	 */
	@Override
	public boolean doStaff(HisStaff staff) {
		if (staff != null && StringUtils.isNotBlank(staff.getUsercode())) {
			PrpSstaff prps = this.staffDAO.readPrpSstaffByUserCode(staff.getUsercode());
			if (prps != null) {// 更新
				doItPrpStaff(staff, prps);
				this.staffDAO.updatePrpSstaff(prps);
				this.staffDutyDAO.deleteStaffDuty(prps.getPersonID());
				StaffDuty duty = new StaffDuty();
				duty.setPersonid(prps.getPersonID());
				if (StringUtils.isNotBlank(prps.getRole()) && String.valueOf(58).equals(prps.getRole())) {
					duty.setJobDutyId(Integer.valueOf(12));
				} else {
					duty.setJobDutyId(Integer.valueOf(15));
				}
				duty.setStatus(Short.valueOf(String.valueOf(1)));
				duty.setCreateTime(new Timestamp(System.currentTimeMillis()));
				this.staffDutyDAO.save(duty);
			} else {// 新增
				prps = new PrpSstaff();
				doItPrpStaff(staff, prps);
				if (prps.getComCode() == null) {
					return false;
				}
				// 没开发完成
				// 设置persionid
				String personCode = "";
				int length = prps.getComCode().length();
				// int length = 8;
				String prefix = "";
				String comcode = "";
				if (length == 2) {
					prefix = "00000000000000";// 根节点下补00000000000000
				} else if (length == 4) {
					prefix = "000000000000";// 总公司下补000000000000
				} else if (length == 8) {
					prefix = "00000000";// 区域级下补00000000
				} else if (length == 12) {
					prefix = "0000";// 连锁级下补0000
				} else if (length == 16) {
					prefix = "";// 门店下直接挂
				} else {
					// throw new
					// BusinessException("归属机构/部门代码不正确，根节点为2位,总公司级为4位,区域级为8位,连锁级为12位,门店级为16位",false);
				}
				if (prps.getComCode().length() >= 16) {
					comcode = prps.getComCode().substring(0, 16);
				} else {
					comcode = prps.getComCode();
				}
				personCode = this.getNo("prpsstaff", comcode, prefix, 0, 4);
				prps.setPersonID(personCode);
				prps.setPassword(MD5.MD5Encode(String.valueOf(Integer.parseInt("1B207",16))));
			//	System.out.println(prps.getPassword()+"__");
				this.staffDAO.savePrpSstaff(prps);
				SaaUserGrade saaUserGrade = new SaaUserGrade();
				saaUserGrade.setUserCode(personCode);
				
				saaUserGrade.setGradeid(Integer.valueOf(prps.getRole()));
				saaUserGrade.setValidStatus("1");
				this.staffDAO.saveSaaUserGrade(saaUserGrade);
				StaffDuty staffDuty = new StaffDuty();
				staffDuty.setPersonid(personCode);
				if (null != prps.getRole() && "58".equals(prps.getRole())) {
					staffDuty.setJobDutyId(12);
				} else {
					staffDuty.setJobDutyId(15);
				}
				staffDuty.setStatus((short) 1);
				staffDuty.setCreateTime(Timestamp.valueOf(DateUtils.fmtDate(new Date(), 16)));
			//	System.out.println(staffDuty.getStaffDutyId());
				staffDAO.saveStaffDuty(staffDuty);
			}
			return true;
		}
		return false;
	}

	private void doItPrpStaff(HisStaff staff, PrpSstaff prps) {
		prps.setUserCode(staff.getUsercode()); // 工号
		prps.setMobile(staff.getUsercode()); // 手机号
		prps.setSex(staff.getSex());
		prps.setPersonName(staff.getPersonname());
		if (StringUtils.isNotBlank(staff.getTitle())) {
			if ("0".equals(staff.getTitle())) {
				prps.setRole("58");
			} else if ("1".equals(staff.getTitle())) {
				prps.setRole("57");
			}
		}
		/** 设置机构码 **/
		if (StringUtils.isNotBlank(staff.getDepartment())) {
			List<PrpScompany> prpScompanys = companyDAO.readPrpScompanyByHisCode(staff.getDepartment());
			if (null != prpScompanys && prpScompanys.size() > 0) {
				for (PrpScompany prpScompany : prpScompanys) {
					String departmentCode = prpScompany.getComCode();
					if (StringUtils.isNotBlank(departmentCode) && departmentCode.length() == 12) {
						String code = departmentCode.substring(0, 8);
						if (comcode.equals(code)) {
							prps.setComCode(departmentCode);
							break;
						}
					}
				}
			}
		}
//		if (null != staff.getDepartment() && !"".equals(staff.getDepartment())) {
//			PrpScompany department = companyDAO.readPrpScompanyByHisCode(staff.getDepartment());
//			if (null != department && StringUtils.isNotBlank(department.getComCode())) {
//				if (department.getComCode().length() >= 12 && comcode.equals(department.getComCode().substring(0, 8))) {
//					prps.setComCode(department.getComCode().substring(0, 12));
//				}
//			}
//		}
		// prps.setPassword(MD5.MD5Encode(String.valueOf(Integer.parseInt("1B207",16))));
		prps.setValidStatus("1");

	}

	public String getNo(String tableName, String iRiskCode, String iComCode, int iYear, int serialNoSize) {
		String groupno = "";
		if (iYear == 0) {
			groupno = iRiskCode;
		} else {
			groupno = iRiskCode + iYear;
		}

		groupno += iComCode;
		String maxNo = null;
		String minNo = null;
		String bizNo = null;
		long count = 0;

		WHILE_LABEL: while (true) {
			// --获取最大最小顺序号,使用Hibernate方式获取会出问题，由于jdbc插入的数据在services层中未纳入Hibernate
			// session管理
			String[] arr = new String[2];
			arr[0] = "";
			arr[1] = "";

			// Map<String ,Object > maxNum =
			// yundiPrpmaxnoMapper.selectMaxNum(groupno,tableName);
			Map<String, String> map = new HashMap<>();
			map.put("groupno", groupno);
			map.put("tableName", tableName);

			Map<String, Object> maxNum = staffDAO.selectMaxFromPrpMaxNo(map);
			if (maxNum != null) {
				arr[0] = (String) maxNum.get("max");
				arr[1] = (String) maxNum.get("min");
				count = Long.valueOf(String.valueOf(maxNum.get("count")));

			}
			if (count == 0) {
				// 组织初始序号
				String initSerialNo = "";
				for (int i = 0; i < serialNoSize - 1; i++) {
					initSerialNo += "0";
				}
				initSerialNo += "1";
				PrpMaxNo prpmaxno = new PrpMaxNo();
				prpmaxno.setGroupno(groupno);
				prpmaxno.setMaxno(initSerialNo);
				prpmaxno.setTablename(tableName);
				prpmaxno.setFlag("0");
				staffDAO.savePrpMaxNo(prpmaxno);
				continue WHILE_LABEL;
			}

			maxNo = ((String) arr[0]).trim();
			minNo = ((String) arr[1]).trim();

			// --最大最小相同，生成 顺序号+1 数据
			if (maxNo.equals(minNo)) {
				int max = Integer.parseInt(minNo, 10) + 1;
				maxNo = this.pull(max, serialNoSize);

				PrpMaxNo prpMaxNo = new PrpMaxNo();
				prpMaxNo.setGroupno(groupno);
				prpMaxNo.setMaxno(maxNo);
				prpMaxNo.setTablename(tableName);
				prpMaxNo.setFlag("0");
				try {
					PrpMaxNo prpmaxno = new PrpMaxNo();
					prpmaxno.setGroupno(prpMaxNo.getGroupno());
					prpmaxno.setMaxno(prpMaxNo.getMaxno());
					prpmaxno.setTablename(prpMaxNo.getTablename());
					prpmaxno.setFlag(prpMaxNo.getFlag());

					staffDAO.savePrpMaxNo(prpmaxno);
				} catch (Exception ex1) {
					ex1.printStackTrace();

					continue WHILE_LABEL;
				}
			}

			// --占号
			// 删除并插入数据到单号占用表PrpMaxUse
			try {
				PrpMaxNo prpmaxno = new PrpMaxNo();
				prpmaxno.setGroupno(groupno);
				prpmaxno.setMaxno(minNo);
				prpmaxno.setTablename(tableName);
				staffDAO.deletePrpMaxNo(prpmaxno);
			} catch (Exception ex2) {
				ex2.printStackTrace();
			}

			PrpMaxUse prpMaxUse = new PrpMaxUse();
			prpMaxUse.setGroupno(groupno);
			prpMaxUse.setMaxno(minNo);
			prpMaxUse.setTablename(tableName);
			prpMaxUse.setFlag("0");
			try {
				PrpMaxUse prpmaxuse = new PrpMaxUse();
				prpmaxuse.setGroupno(prpMaxUse.getGroupno());
				prpmaxuse.setMaxno(prpMaxUse.getMaxno());
				prpmaxuse.setTablename(prpMaxUse.getTablename());
				prpmaxuse.setTtyName(prpMaxUse.getTtyName());
				prpmaxuse.setFlag(prpMaxUse.getFlag());

				staffDAO.savePrpMaxUse(prpmaxuse);
			} catch (Exception ex3) {
				ex3.printStackTrace();
			}

			UtiKey utiKey = this.getUtiKey(tableName);

			if (utiKey == null) {
			} else if (utiKey.getHeadId() != null && utiKey.getHeadId().length() > 0) {
				bizNo = utiKey.getHeadId().charAt(0) + groupno + minNo; // 如果headid为空，表示是纯数字编号，没有首字母
			} else {
				bizNo = groupno + minNo;
			}

			// 使用hql检查新号重复性
			int bizcount = this.getPrpSstaffCount(bizNo);

			if (bizcount == 0) {
				break WHILE_LABEL;
			}

			// 重复五次删除已经占用的重复号
			for (int i = 0; i < 5; i++) {
				try {
					PrpMaxUse prpmaxuse = new PrpMaxUse();
					prpmaxuse.setGroupno(prpMaxUse.getGroupno());
					prpmaxuse.setMaxno(prpMaxUse.getMaxno());
					prpmaxuse.setTablename(prpMaxUse.getTablename());

					staffDAO.deletePrpMaxUse(prpmaxuse);
				} catch (Exception ex4) {
					continue WHILE_LABEL;
				}
			}
		}
		return bizNo;
	}

	private String pull(int value, int len) {
		String serialText = "";
		for (int i = 0; i < len; i++) {
			serialText += "0";
		}
		String s = Integer.toString(value);
		serialText = serialText.substring(0, len - s.length());
		return (serialText + s);
	}

	public UtiKey getUtiKey(String tableName) {
		UtiKey utiKey = new UtiKey();
		try {
			UtiKey yundiUtiKey = staffDAO.readUtiKeyByTableName(tableName);
			if (yundiUtiKey != null) {
				utiKey.setHeadId(yundiUtiKey.getHeadId());
			}
		} catch (Exception ex1) {
			ex1.printStackTrace();
		}
		return utiKey;
	}

	public int getPrpSstaffCount(String personid) {
		int count = 0;
		try {
			Map<String, String> maxId = staffDAO.selectMaxIdByPersonId(personid);
			if (maxId != null) {
				count = Integer.parseInt(maxId.get("max"));
			}
		} catch (Exception ex1) {
			ex1.printStackTrace();
		}
		return count;
	}
}
