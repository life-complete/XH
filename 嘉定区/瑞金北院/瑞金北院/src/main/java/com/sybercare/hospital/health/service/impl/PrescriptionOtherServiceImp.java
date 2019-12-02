package com.sybercare.hospital.health.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.sybercare.hospital.adapters.entity.HisPrescriptionOther;
import com.sybercare.hospital.common.utils.Constants;
import com.sybercare.hospital.common.utils.DateUtils;
import com.sybercare.hospital.common.utils.SendPostUtils;
import com.sybercare.hospital.health.dao.PatientDAO;
import com.sybercare.hospital.health.dao.PrescriptionOtherDAO;
import com.sybercare.hospital.health.entity.MonitorScheme;
import com.sybercare.hospital.health.entity.PrescriptionOther;
import com.sybercare.hospital.health.entity.UserPatient;
import com.sybercare.hospital.health.service.IPrescriptionOtherService;

/**
 * 功能：监测医嘱数据处理
 *
 * @author 任梁荣
 * @version 创建时间：Sep 22, 2017 6:23:01 PM
 */
@Service
public class PrescriptionOtherServiceImp implements IPrescriptionOtherService {

	protected static final Logger LOGGER = LoggerFactory.getLogger(PrescriptionOtherServiceImp.class);

	@Value("${custom.hospital.default.comcode}")
	private String comcode;
	@Value("${custom.hospital.host}")
	private String host;
	@Autowired
	private PrescriptionOtherDAO prescriptionOtherDAO;
	@Autowired
	private PatientDAO patientDAO;

	@Override
	public boolean doPOther(HisPrescriptionOther $other) {
		try {
			UserPatient userPatient = patientDAO.readUserPatientByCardNumber($other.getCardNumber());
			if (null == userPatient || "1".equals(userPatient.getInHospitalStatus())) {
				return true;
			} else {
				PrescriptionOther prescriptionOther = prescriptionOtherDAO.readPrescriptionOther($other.getPrescriptionId());
				if (null == prescriptionOther) {
					if ("0".equals($other.getPrescriptionStatus())) {
						// 新增
						this.generateNewPrescriptionToYundi(userPatient.getUserId(), $other);
						this.addMonitorSchemeAndUserTask(userPatient.getUserId(), $other);
					}
				} else {
					// 修改
					this.upDateMonitorSchemeAndUserTask($other);
					this.updatePrescriptionToYundi(userPatient.getUserId(), $other, prescriptionOther.getId());
				}
			}
			return true;
		} catch (Exception e) {
			LOGGER.debug("doPOther: " + e);
		}
		return false;
	}

	/**
	 * @Title: generateNewPrescriptionToYundi @author wangzhi
	 * @Description: 在yundi侧生成新记录
	 * @param userId
	 * @param hospitalizationNumber
	 * @param tmp
	 * @param re
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	private void generateNewPrescriptionToYundi(String userId, HisPrescriptionOther hisPrescriptionOther) {
		if (null != hisPrescriptionOther.getPrescriptionId()) {
			PrescriptionOther prescriptionOther = new PrescriptionOther();
			prescriptionOther.setPrescriptionId(hisPrescriptionOther.getPrescriptionId());
			// 创建时间、开始时间、结束时间
			prescriptionOther.setCreateDate(hisPrescriptionOther.getCreateDate());
			prescriptionOther.setStartTime(hisPrescriptionOther.getStartTime());
			prescriptionOther.setEndTime(hisPrescriptionOther.getEndTime());
			prescriptionOther.setDrugName(hisPrescriptionOther.getPrescriptionName());
			prescriptionOther.setMedicationFrequency(hisPrescriptionOther.getFrequency());
			prescriptionOther.setDoctorId(hisPrescriptionOther.getDoctorId());
			prescriptionOther.setDoctorName(hisPrescriptionOther.getDoctorName());
			prescriptionOther.setOrderCode(hisPrescriptionOther.getPrescriptionNo());
			if (null != hisPrescriptionOther.getPrescriptionType() && !"".equals(hisPrescriptionOther.getPrescriptionType())) {
				prescriptionOther.setOrderFlag(Integer.parseInt(hisPrescriptionOther.getPrescriptionType()));
			}
			prescriptionOther.setCardNumber(hisPrescriptionOther.getCardNumber());
			prescriptionOther.setUserId(userId);
			/** remark长度保护 **/
			if (hisPrescriptionOther.getRemark() != null && hisPrescriptionOther.getRemark().length() > 200) {
				prescriptionOther.setRemark(hisPrescriptionOther.getRemark().substring(0, 199));
			}
			prescriptionOther.setParentName(hisPrescriptionOther.getPrescriptionStatus());

			// prescriptionNotes 字段未做处理
			prescriptionOtherDAO.savePrescriptionOther(prescriptionOther);
		}
	}

	/**
	 * @Title: generateNewPrescriptionToYundi @author wangzhi @Description: 在yundi侧生成新记录 @param @param userId @param @param
	 *         hospitalizationNumber @param @param tmp @param @param re @param @throws IllegalAccessException @param @throws
	 *         InvocationTargetException 设定文件 @return void 返回类型 @throws
	 */
	private void updatePrescriptionToYundi(String userId, HisPrescriptionOther hisPrescriptionOther, Long id) {
		PrescriptionOther prescriptionOther = new PrescriptionOther();
		prescriptionOther.setPrescriptionId(hisPrescriptionOther.getPrescriptionId().toString());
		// 创建时间、开始时间、结束时间
		prescriptionOther.setCreateDate(hisPrescriptionOther.getCreateDate());
		prescriptionOther.setStartTime(hisPrescriptionOther.getStartTime());
		prescriptionOther.setEndTime(hisPrescriptionOther.getEndTime());
		prescriptionOther.setDrugName(hisPrescriptionOther.getPrescriptionName());
		prescriptionOther.setMedicationFrequency(hisPrescriptionOther.getFrequency());
		prescriptionOther.setDoctorId(hisPrescriptionOther.getDoctorId());
		prescriptionOther.setDoctorName(hisPrescriptionOther.getDoctorName());
		if (null != hisPrescriptionOther.getPrescriptionNo()) {
			prescriptionOther.setOrderCode(hisPrescriptionOther.getPrescriptionNo().toString());
		}
		if (null != hisPrescriptionOther.getPrescriptionType() && !"".equals(hisPrescriptionOther.getPrescriptionType())) {
			prescriptionOther.setOrderFlag(Integer.parseInt(hisPrescriptionOther.getPrescriptionType()));
		}
		prescriptionOther.setCardNumber(hisPrescriptionOther.getCardNumber());
		prescriptionOther.setUserId(userId);
		prescriptionOther.setId(id);
		/** remark长度保护 **/
		if (hisPrescriptionOther.getRemark() != null && hisPrescriptionOther.getRemark().length() > 200) {
			prescriptionOther.setRemark(hisPrescriptionOther.getRemark().substring(0, 199));
		}
		prescriptionOther.setParentName(hisPrescriptionOther.getPrescriptionStatus());
		// prescriptionNotes 字段未做处理
		prescriptionOtherDAO.updatePrescriptionOther(prescriptionOther);
	}

	private void addMonitorSchemeAndUserTask(String userId, HisPrescriptionOther tmp) {
		MonitorScheme monitorScheme = new MonitorScheme();
		monitorScheme.setStartDate(tmp.getStartTime());
		monitorScheme.setEndDate(tmp.getEndTime());
		monitorScheme.setRecordDate(tmp.getCreateDate());
		if (null != tmp.getFrequency() && ("ONCE".equals(tmp.getFrequency()) || "ST".equals(tmp.getFrequency()))) {// 临时医嘱
			monitorScheme.setMonitorSchemeType((short) 2);
			if (null != tmp.getStartTime()) {
				String nowDate = Constants.convert(new Date(), Constants.format1);
				String startDate = DateUtils.fmtDate(tmp.getStartTime(), 16);
				int res = startDate.compareTo(nowDate);
				if (res > 0) {
					monitorScheme.setStatus((short) 1);
				} else if (res == 0) {
					monitorScheme.setStatus((short) 2);
				} else {
					monitorScheme.setStatus((short) 3);
				}
			}
		} else {
			monitorScheme.setMonitorSchemeType((short) 1);
			Integer status = this.getSchemeStatusByDate(tmp);
			/** 因为yundi不会把状态 还没开始 更新到正在使用，所以将 还没开始 的状态也设置为 正在使用 **/
			monitorScheme.setStatus(status.shortValue());
		}
		monitorScheme.setMonitorSchemeName(tmp.getPrescriptionName());
		monitorScheme.setMonitorSchemeContent(tmp.getPrescriptionNotes());
		monitorScheme.setUserId(userId);
		monitorScheme.setDoctorId(tmp.getDoctorId());
		monitorScheme.setExt1("-1");
		monitorScheme.setExt2(String.valueOf(tmp.getPrescriptionId()));
		if (null != tmp.getPrescriptionType() && !"".equals(tmp.getPrescriptionType())) {
			monitorScheme.setMeasureType(Integer.valueOf(tmp.getPrescriptionType()));
		} else {
			monitorScheme.setMeasureType(0);
		}
		monitorScheme.setComcode(comcode);

		String jsonString = JSONObject.toJSONString(monitorScheme, SerializerFeature.WriteDateUseDateFormat);
		

		try {
			String path = host + "/services/RestServices/yundihealth/monitorScheme/addSchemeFromAdapt";
			SendPostUtils.sendPost(jsonString, path);
			//System.out.println(jsonString.toString());
		} catch (IOException e) {
			LOGGER.debug("addMonitorSchemeAndUserTask: " + e);
		}
	}

	/**
	 * 更新医嘱信息的时候更新监测方案和userTask
	 * 
	 * @param tmp
	 * @param re
	 */
	private void upDateMonitorSchemeAndUserTask(HisPrescriptionOther tmp) {
		Map<String, Object> map = new HashMap<String, Object>();
		/** 医嘱以前是使用中，现在变成停止或撤销 **/
		if (tmp.getPrescriptionStatus() != null && (tmp.getPrescriptionStatus().equals("1"))) {
			//yundiMonitorSchemeService.endMonitorSchame(re.get(0).getPrescriptionId(),tmp.getEndTime());
			map.put("prescriptionId", tmp.getPrescriptionId());
			if (tmp.getEndTime() != null) {
				map.put("endTime", DateUtils.fmtDate(tmp.getEndTime(), 16));
			} else {
				map.put("endTime", null);
			}
			map.put("status", (short) 3);
			try {
				String jsonString = JSON.toJSONString(map);
				String path = host + "/services/RestServices/yundihealth/monitorScheme/modifySchemeFromAdapt";
				SendPostUtils.sendPost(jsonString, path);
			} catch (IOException e) {
				LOGGER.debug("upDateMonitorSchemeAndUserTask: " + e);
			}
		} else {
			if (tmp.getEndTime() != null) {
				// 特殊医嘱状态问题解决
				 //yundiMonitorSchemeService.updateMonitorSchemeEndTime(re.get(0).getPrescriptionId(),tmp.getEndTime());
				map.put("prescriptionId", tmp.getPrescriptionId());
				map.put("endTime", DateUtils.fmtDate(tmp.getEndTime(), 16));
				try {
					Long res = 0L;
					Date endtDate = tmp.getEndTime();
					Date nowDate = DateUtils.parse(DateUtils.getCurrent(16), 16);
					res = DateUtils.betweenDays(endtDate, nowDate);
					if (res < 0L) {
						map.put("status", (short) 2);
					} else {
						map.put("status", (short) 3);
					}
					String jsonString = JSON.toJSONString(map);
					String path = host + "/services/RestServices/yundihealth/monitorScheme/modifySchemeFromAdapt";
					SendPostUtils.sendPost(jsonString, path);
					//System.out.println(jsonString.toString());
					
				} catch (Exception e) {
					LOGGER.debug("upDateMonitorSchemeAndUserTask: " + e);
				}
			}
		}
	}

	/**
	 * @Title: getSchemeStatusByDate @author wangpeifeng @Description: 根据日期 获取监测方案的状态：还没使用,正在使用,已使用 @param @param tmp @param @return
	 *         设定文件 @return Integer 返回类型 @throws
	 */
	public Integer getSchemeStatusByDate(HisPrescriptionOther tmp) {
		// 1:还没开始,2:正在使用,3：已使用
		String nowDate = DateUtils.getCurrent(13);
		String startDate = null;
		String endDate = null;
		if (null != tmp.getStartTime()) {
			startDate = DateUtils.fmtDate(tmp.getStartTime(), 13);
		}
		if (null != tmp.getEndTime()) {
			endDate = DateUtils.fmtDate(tmp.getEndTime(), 13);
		}
		try {
			if (null == startDate) {
				// 如果开始时间为null，结束时间也为null，直接返回
				if (null == endDate) {
					return 3;
				}
				// 如果开始时间为null，结束时间不为null
				// 如果当前时间大于结束时间，状态设置为3，如果当前时间小于结束时间，状态设置为2}
				int endRes = DateUtils.compareDate(nowDate, endDate);
				if (endRes <= 0) {
					return 2;
				} else {
					return 3;
				}
			} else {
				int startRes = DateUtils.compareDate(nowDate, startDate);
				// 如果当前时间小于开始时间状态设置为1
				if (startRes < 0) {
					return 1;
				}
				// 如果结束时间为null，状态设置为2
				if (tmp.getEndTime() == null) {
					return 2;
				}
				int endRes = DateUtils.compareDate(nowDate, endDate);
				// 如果当前时间大于开始时间小于结束时间，状态设置为2
				if (endRes <= 0) {
					return 2;
				}
				// 如果当前时间大于结束时间3
				if (endRes > 0) {
					return 3;
				}
			}
		} catch (Exception e) {
			LOGGER.debug("getSchemeStatusByDate: " + e);
		}
		return null;
	}

}
