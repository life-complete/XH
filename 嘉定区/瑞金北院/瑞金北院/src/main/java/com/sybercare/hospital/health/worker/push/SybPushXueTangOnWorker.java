package com.sybercare.hospital.health.worker.push;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sybercare.hospital.adapters.worker.HisWorkEvents;
import com.sybercare.hospital.common.utils.DateUtils;
import com.sybercare.hospital.common.utils.WorkAutowired;
import com.sybercare.hospital.health.service.IBloodGlucoseService;
import com.sybercare.hospital.health.service.IStaffService;

/**
 * 功能：推送血糖数据
 */
public class SybPushXueTangOnWorker extends SybBasePushOnWorker {

	protected static final Logger LOGGER = LoggerFactory.getLogger(SybPushXueTangOnWorker.class);

	@WorkAutowired
	private IStaffService staffService;
	@WorkAutowired
	private IBloodGlucoseService bloodGlucoseService;

	/**
	 * 功能：获取推送数据
	 */
	@Override
	public Object pushData(Object events) {
		Integer operateState = 0;
		List<Object> objList = this.bloodGlucoseService.getBloodGlucoseByOperateState(operateState);
		if (null == objList) {
			return null;
		}
		return JSONObject.toJSON(objList);
	}

	/**
	 * 功能：处理推送结果(推送之后在对像中添加pushResult字段，成功：true，失败：false)
	 */
	@Override
	public void resultCallback(HisWorkEvents events, List<JSONObject> result) {
		try {
			this.bloodGlucoseService.modifyOperateState(result);
		} catch (Exception e) {
			LOGGER.debug("resultCallback" + e);
		}
	}

	
	/**
	 * 功能：解析推送格式
	 */
	@Override
	public Object analysis(Object obList, Object woker) {
		List<JSONObject> bloodList = new ArrayList<JSONObject>();
		try {
			if (obList != null && obList instanceof JSONArray) {
				JSONArray json = (JSONArray) obList;
				if (json != null && json.size() > 0) {
					for (Object o : json) {
						JSONObject temp = (JSONObject) o;
						String id = temp.getString("id");// 序号id
						String value = temp.getString("value");// 测量值
						String status = temp.getString("status");// 测量时段
						String measureTime = DateUtils.formatDate1(temp.getString("measureTime"));// 测量时间
						String patientId = temp.getString("patientId");// 病人ID
						String cardNumber = temp.getString("cardNumber");
						String opratorId = temp.getString("opratorId");// 测量人ID
						String opratorState = temp.getString("opratorState");// 操作状态0：未操作,1：已操作
						String opratorType = temp.getString("opratorType");// 操作类型1：增加,2：修改,3：删除
						String remark = temp.getString("remark");// 备注
						String last_update_time = DateUtils.formatDate1(temp.getString("lastUpdateTime"));//最后更新时间

						JSONObject blood = new JSONObject();
						blood.put("Id", id);// 血糖记录ID
						blood.put("Value", value);// 血糖值
						blood.put("Status", status);// 测量时间段
						blood.put("MeasureTime", measureTime);// 测量时间。格式：1840-01-01
															// 12:00:00
						blood.put("PatientID", patientId);// 只给病人ID不够，东华系统需要AdmDR
						blood.put("CardNumber", cardNumber);// 住院号
						blood.put("OpratorID", opratorId);// 测量人ID，对应UserID,用户表ID
						blood.put("OpratorState", opratorState);// 操作状态。0：未操作
																		// 1：已操作
						blood.put("OpratorType", opratorType);// 操作类型。1：增加 2：修改
																// 3：删除
						blood.put("Remark", remark);// 备注
						blood.put("LastUpdateTime", last_update_time);	//更新时间
						bloodList.add(blood);
//				System.out.println("blood:"+blood.toJSONString());
					}
				}
			}
		} catch (Exception e) {
			LOGGER.debug("analysis" + e);
		}
		return (JSONArray) JSONArray.toJSON(bloodList);
	}
}
