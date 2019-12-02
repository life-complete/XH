package com.sybercare.hospital.common.jobs;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sybercare.hospital.common.utils.Constants;
import com.sybercare.hospital.health.dao.BloodPressureDAO;
import com.sybercare.hospital.health.entity.BloodPressure;
import com.wonders.measure.common.utils.InterfaceEnCode;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

/**
 * 功能：运行定时业务
 * 
 * @author 任梁荣
 */
@Component
public class Jobs {
	public final static long ONE_Minute = 60 * 1000;

	private static final String Private = null;

	@Autowired
	private BloodPressureDAO bloodPressureDAO;

	@Scheduled(cron = "0 0/1 * * * ?")
	public void doXueYaIt() {
		try {
			System.out.println("job 血压定时器：" + Constants.convert(new Date(), Constants.format2));
			List<BloodPressure> bloodGlucoses1 = bloodPressureDAO.getBloodPressureByOperateState();
			for (BloodPressure bloodPressure : bloodGlucoses1) {
				boolean result = requestBP(bloodPressure);
				if (result) {
					bloodPressureDAO.updateBloodGlucoseOperateState(bloodPressure.getId(), (short) 3);
				}
				Thread.sleep(500);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
    private boolean isBG = true;
	public boolean requestBP(BloodPressure bloodPressure) throws Exception {
		boolean requestBP = false;
		//String url = "http://101.89.187.48:8080/Contract/api/archive/api/getJkxwData";
		String url = "http://192.168.0.25:9071/measure/api/patSignSubmit";	
		//Jkxwdata P = new Jkxwdata();
		Patdata patdata = new Patdata();
		
		//Long id = 500000000L + bloodPressure.getId();// id规定从500000000L开始
		//jkxwdata.setId(id + "");
//		jkxwdata.setName(bloodPressure.getNAME());
//		jkxwdata.setUserUid(bloodPressure.getUserUid());
//		jkxwdata.setMobile(bloodPressure.getMobile());
//		String idCard = bloodPressure.getIdCard();
//		if (idCard == null || idCard.length() <= 0) {
//			return false;
//		}
//		IdcardInfoExtractor idcardInfo = new IdcardInfoExtractor(bloodPressure.getIdCard());
//		jkxwdata.setSex(idcardInfo.getGender());
//		jkxwdata.setAge(idcardInfo.getAge() + "");
//		jkxwdata.setIdCard(bloodPressure.getIdCard());
//		jkxwdata.setCheckTime(Constants.convert(Constants.convert(bloodPressure.getCheckTime(), Constants.format2),
//				Constants.format3));
		
		patdata.setPersoncard(bloodPressure.getIdCard());
		patdata.setMeasureTime(Constants.convert(Constants.convert(bloodPressure.getCheckTime(), Constants.format2), Constants.format2));
		patdata.setMeasureSourceId("0005");
		patdata.setMeasureLocation(String.valueOf(1));
		patdata.setMeasureOrgId("42508153900");
		patdata.setMeasureMode(String.valueOf(2));
		patdata.setDeviceId(bloodPressure.getDeviceId());
		patdata.setDeviceType(String.valueOf("AND:TM-2656VP"));
				
 
	    BloodPressureVo bpVo1 = new BloodPressureVo();
	    
	    String clsb = null;
	    
		if (bloodPressure.getHand().equals("left")) {
			clsb = String.valueOf(1);
		} else if (bloodPressure.getHand().equals("right")) {
			clsb = String.valueOf(2);
		} else {
			clsb = String.valueOf(3);
		}
	    
	    bpVo1.setMeasureType(String.valueOf(1001)); //血压
	    bpVo1.setMeasureData(bloodPressure.getSystolicPressure() + "|" + bloodPressure.getDiastolicPressure() + "|" + clsb);
	    
	    
	    BloodPressureVo bpVo2 = new BloodPressureVo();
	    bpVo2.setMeasureType(String.valueOf(1002)); //脉搏
	    bpVo2.setMeasureData(bloodPressure.getPluse());
	    
	    List <BloodPressureVo> datalist = new ArrayList<BloodPressureVo>();
	    datalist.add(bpVo1); 
	    datalist.add(bpVo2); 
	    
	    patdata.setDataList(datalist);
		
			
//		jkxwdata.setSystolicPressure(bloodPressure.getSystolicPressure());
//		jkxwdata.setDiastolicPressure(bloodPressure.getDiastolicPressure());
//		jkxwdata.setSbbh(bloodPressure.getCompanycode());
//		jkxwdata.setSbname("血压计");
//		jkxwdata.setSbcsname("康之元");
//		
//		String companyCode = bloodPressure.getCompanycode();
//		if (companyCode.equals("0001004300050001")) {
//			companyCode = "42506016400";
//		} else if (companyCode.equals("0001004300050013")) {
//			companyCode = "76879417800";
//		} else {
//			companyCode = "";
//		}
//		
//		jkxwdata.setYljgdm(companyCode);

		Map<String, String> map = new HashMap<String, String>();

		JsonConfig jsonConfig = new JsonConfig();
		PropertyFilter filter = new PropertyFilter() {
			public boolean apply(Object object, String fieldName, Object fieldValue) {
				return null == fieldValue;
			}
		};
		jsonConfig.setJsonPropertyFilter(filter);
		JSONObject json = JSONObject.fromObject(patdata, jsonConfig);
		System.out.println("请求数据：" + json.toString());
		String header = InterfaceEnCode.getInterfaceKey();								
		map.put("param", InterfaceEnCode.encrypt(json.toString()));
		HttpClientUtil util = new HttpClientUtil();
		String result = util.doPost(header, url, map);
	    //String result = "{\"code\":\"1\",\"msg\":\"数据传输成功\"}";
		JSONObject resultJson = JSONObject.fromObject(result);
		String code = resultJson.getString("code");
		if (code.equals("1")) {
			requestBP = true;
		}
		System.out.println("返回结果：" + result);

		return requestBP;
	}
}