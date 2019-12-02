package com.sybercare.hospital.health.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

public interface IBloodGlucoseService {
	
	List<Object> getBloodGlucoseByOperateState(Integer operateState);
	
	void modifyOperateState(List<JSONObject> result);

}
