package com.sybercare.hospital.health.worker.recv;

import java.util.Date;
import java.util.Observable;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sybercare.hospital.adapters.entity.HisStaff;
import com.sybercare.hospital.common.utils.BaseObserver;
import com.sybercare.hospital.common.utils.Constants;
import com.sybercare.hospital.common.utils.WorkAutowired;
import com.sybercare.hospital.health.service.IStaffService;

/**
 * 功能：接收处理医院人员信息
 * 
 * @author 任梁荣
 * */
public class SybRecvStaffOnWorker implements BaseObserver {

	@WorkAutowired
	private IStaffService staffService;

	@Override
	public void update(Observable o, Object arg) {
		Object[] args = (Object[]) arg;
		if (args != null && args.length > 0) {
			JSONArray json = (JSONArray) args[0];
			if (json != null) {
				json.forEach(staff -> {
					//System.out.println(staff.toString());
					HisStaff $staff = JSONObject.parseObject(staff.toString(), HisStaff.class);
//					System.out.println("科室"+$staff.getDepartment()+"工号id"+$staff.getStaffId()+"名字"+$staff.getPersonname()+"工号"+$staff.getUsercode()+
//					"性别"+$staff.getSex()+"病区"+$staff.getWardArea()+"职务"+$staff.getTitle());
					this.staffService.doStaff($staff);
				});
				
				System.out.println(Constants.convert((new Date()), Constants.format2) + " 员工同步完成");
			}
		}
	}
}
