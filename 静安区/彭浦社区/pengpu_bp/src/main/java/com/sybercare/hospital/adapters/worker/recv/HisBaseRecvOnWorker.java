package com.sybercare.hospital.adapters.worker.recv;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sybercare.hospital.adapters.worker.HisWorkEvents;
import com.sybercare.hospital.adapters.worker.data.HisDataEvents;
import com.sybercare.hospital.adapters.worker.data.HisDataManagers;
import com.sybercare.hospital.common.utils.BaseObserver;
import com.sybercare.hospital.common.utils.Constants;
import com.sybercare.hospital.common.utils.IBeanParse;
import com.sybercare.hospital.common.utils.IDataOnWorker;
import com.sybercare.hospital.common.utils.WorkAutowired;

/**
 * 功能：接收上传血糖数据
 * 
 * @author 任梁荣
 * */
public class HisBaseRecvOnWorker implements BaseObserver, IBeanParse {

	@WorkAutowired
	private HisDataManagers dataManagers;

	@Override
	public String versionName() {
		return String.valueOf("上传默认实现");
	}

	@Override
	public Object dataSources() {
		return HisDataEvents.DONGHUA;
	}

	@Override
	public void update(Observable o, Object arg) {
		Object[] args = (Object[]) arg;
		if (args != null && args.length > 0) {
			JSONArray json = (JSONArray) args[0];
			if (json != null && json.size() > 0) {
				List<JSONObject> resultList = new ArrayList<JSONObject>();
				HisDataEvents events = (HisDataEvents) this.dataSources();
				IDataOnWorker basicOnWorker = this.dataManagers.proxy(events);
				for (Object ojs : json) {
					boolean rs = false;
					try {
						rs = basicOnWorker.recvData(ojs);
					} catch (Exception e) {
					}
					JSONObject dojson = (JSONObject) ojs;
					dojson.put("PushResult", rs);
					resultList.add(dojson);
				}
				if (args.length > 1 && args[1] != null) {
					Object o1 = args[1];
					if (o1 instanceof HisWorkEvents) {
						HisWorkEvents $events = (HisWorkEvents) o1;
						Constants.pushQueue.put($events.toString(), resultList);
					}
				}
			}
		}
	}

	@Override
	public Object analysis(Object obList, Object params, Object woker) {
		return null;
	}

	@Override
	public Object loadData(Object woker, Object params) {
		return null;
	}

}
