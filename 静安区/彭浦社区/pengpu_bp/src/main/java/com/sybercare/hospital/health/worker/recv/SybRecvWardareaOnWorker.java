package com.sybercare.hospital.health.worker.recv;

import java.util.Observable;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sybercare.hospital.adapters.entity.HisWardarea;
import com.sybercare.hospital.common.utils.BaseObserver;
import com.sybercare.hospital.common.utils.WorkAutowired;
import com.sybercare.hospital.health.service.IWardareaService;

/**
 * 功能：接收一级部门信息
 * 
 * @author 任梁荣
 * */
public class SybRecvWardareaOnWorker implements BaseObserver {

	@WorkAutowired
	private IWardareaService wardareaService;

	@Override
	public void update(Observable o, Object arg) {
		Object[] args = (Object[]) arg;
		if (args != null && args.length > 0) {
			JSONArray json = (JSONArray) args[0];
			if (json != null) {
				json.forEach(wardarea -> {
					HisWardarea $wardarea = JSONObject.parseObject(wardarea.toString(), HisWardarea.class);
					this.wardareaService.doWardarea($wardarea);
				});
			}
		}
	}
}
