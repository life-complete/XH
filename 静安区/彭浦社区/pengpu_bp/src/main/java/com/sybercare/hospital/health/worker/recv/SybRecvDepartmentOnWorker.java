package com.sybercare.hospital.health.worker.recv;

import java.util.Observable;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sybercare.hospital.adapters.entity.HisDepartment;
import com.sybercare.hospital.common.utils.BaseObserver;
import com.sybercare.hospital.common.utils.WorkAutowired;
import com.sybercare.hospital.health.service.IDepartmentService;

/**
 * 功能：接收二级部门信息
 * 
 * @author 任梁荣
 * */
public class SybRecvDepartmentOnWorker implements BaseObserver {

	@WorkAutowired
	private IDepartmentService departmentService;

	/** 收到数据 */
	@Override
	public void update(Observable o, Object arg) {
		Object[] args = (Object[]) arg;
		if (args != null && args.length > 0) {
			JSONArray json = (JSONArray) args[0];
			if (json != null) {
				json.forEach(department -> {
					HisDepartment $department = JSONObject.parseObject(department.toString(), HisDepartment.class);
					this.departmentService.doDepartment($department);
				});
			}
		}
	}
}
