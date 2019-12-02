package com.sybercare.hospital.health.worker.push;

import java.util.List;
import java.util.Observable;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sybercare.hospital.adapters.worker.HisWorkEvents;
import com.sybercare.hospital.adapters.worker.HisWorkManagers;
import com.sybercare.hospital.common.utils.BaseObserver;
import com.sybercare.hospital.common.utils.Constants;
import com.sybercare.hospital.common.utils.WorkAutowired;

/**
 * 功能：推送数据处理
 * 
 * @author 任梁荣
 * */
public abstract class SybBasePushOnWorker implements BaseObserver {

	@WorkAutowired
	private HisWorkManagers hisWorkManagers;

	@Override
	public void update(Observable o, Object arg) {
		Object[] args = (Object[]) arg;
		if (args != null && args.length > 0) {
			HisWorkEvents events = HisWorkEvents.nvalueOf(args[0].toString());
			Object obj = this.pushData(events);
			if(null != obj){
				this.hisWorkManagers.onEvents(events, this.analysis(obj, events), events);
				List<JSONObject> result = Constants.pushQueue.get(events.toString());
				this.resultCallback(events, result);
				Constants.pushQueue.remove(events.toString());
			}
		}
	}

	/** 推送结果 */
	/**
	 * List<JSONObject> result
	 * 
	 * 血糖id：id
	 * 操作状态operateState：true or false
	 * 
	 * */
	public abstract void resultCallback(HisWorkEvents events, List<JSONObject> result);

	/** 推送数据获取 */
	public abstract Object pushData(Object events);

	/** 推送数据格式 */
	public Object analysis(Object obList, Object woker) {
		return (JSONArray) JSONArray.toJSON(obList);
	}
}
