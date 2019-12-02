package com.hesicare.hospital.common.jobs;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.stream.Collectors;

import com.hesicare.hospital.health.dao.BloodGlucoseDAO;
import com.hesicare.hospital.health.dao.PatientBmiViewDao;
import com.hesicare.hospital.health.entity.BloodGlucose;
import com.hesicare.hospital.health.entity.PatientBmiView;
import net.sf.json.JSONArray;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hesicare.hospital.common.utils.Constants;
import com.hesicare.hospital.health.dao.BloodPressureDAO;
import com.hesicare.hospital.health.entity.BloodPressure;
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
	static final Logger logger = Logger.getLogger(Jobs.class);
	Logger payLogger = Logger.getLogger("singleLoginInfo");
	Logger payLogger2 = Logger.getLogger("singleLoginInfo2");
	Logger payLogger3= Logger.getLogger("singleLoginInfo3");
	@Autowired
	private BloodPressureDAO bloodPressureDAO;

	@Autowired
	private PatientBmiViewDao patientBmiViewDao;
	@Autowired
	private BloodGlucoseDAO bloodGlucoseDAO;
	@Scheduled(cron = "0 0/3 * * * ?")
	public void doBmiIt() {
		try{
			System.out.println("job 身高定时器：" + Constants.convert(new Date(), Constants.format2));
			List<PatientBmiView> bmiview =patientBmiViewDao.getBmiByState("0");
			for (PatientBmiView patientBmiView : bmiview) {
				boolean result = requestSG(patientBmiView);
				if (result) {
					//bloodGlucoseDAO.updateBloodGlucoseOperateState(patientBmiView.getId(), (short) 1);
					patientBmiViewDao.updateBmiState(patientBmiView.getId(),(short) 1);
				}
				Thread.sleep(500);
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}

	}
	@Scheduled(cron = "0 0/1 * * * ?")
	//@Scheduled(cron = "0/10 * * * * ?")
	public void doXueTangIt() {
		try {
			System.out.println("job 血糖定时器：" + Constants.convert(new Date(), Constants.format2));
			//List<BloodPressure> bloodGlucoses1 = bloodPressureDAO.getBloodPressureByOperateState();
			List<BloodGlucose> bloodGlucoses1 =bloodGlucoseDAO.getBloodGlucoseByOperateState("0");
			for (BloodGlucose bloodGlucose : bloodGlucoses1) {
				boolean result = requestXT(bloodGlucose);
				if (result) {
					//bloodPressureDAO.updateBloodGlucoseOperateState(bloodPressure.getId(), (short) 3);
					bloodGlucoseDAO.updateBloodGlucoseOperateState(bloodGlucose.getId(), (short) 1);
				}
				Thread.sleep(500);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		@SuppressWarnings("unchecked")
	    @Scheduled(cron = "0 0/1 * * * ?")
		//@Scheduled(cron = "0/10 * * * * ?")
	public void doXueYaIt() {
		try {
			System.out.println("job 血压定时器：" + Constants.convert(new Date(), Constants.format2));

			List<BloodPressure> bloodGlucoses1 = bloodPressureDAO.getBloodPressureByIdCard();

			Map<String, List<BloodPressure>> groupBy = bloodGlucoses1.stream()
					.collect(Collectors.groupingBy(BloodPressure::getIdentifierCode));

			JSONObject jsonObject = JSONObject.fromObject(groupBy);

			Iterator<Map.Entry<String, List<BloodPressure>>> it = jsonObject.entrySet().iterator();

			while (it.hasNext()) {
				Map.Entry<String, List<BloodPressure>> entry = it.next();

				JSONArray list = (JSONArray) entry.getValue();

				List<BloodPressure> bplist = (List<BloodPressure>) JSONArray.toCollection(list, BloodPressure.class);
				
				sortClass sort = new sortClass();
				Collections.sort(bplist, sort);
				
				if (String.valueOf(bplist.get(0).getIdCard()).length()<15){	
					continue;
				}

//				if (StringUtils.isBlank(bplist.get(0).getHand())){	
//					continue;
//				}

				if (StringUtils.isBlank(bplist.get(0).getCheckTime())){	
					continue;
				}
				if(StringUtils.isBlank(bplist.get(0).getCardNumber())){
					continue;
				}
				if (StringUtils.isBlank(bplist.get(0).getSystolicPressure())){	
					continue;
				}
				
				if (StringUtils.isBlank(bplist.get(0).getDiastolicPressure())){	
					continue;
				}
				
				if (bplist.size()<2) {
					continue;
				}
				
				if (String.valueOf(bplist.get(0).getIsAverage()).equals("0")) {
					continue;
				}
				
				if (String.valueOf(bplist.get(bplist.size()-1).getData_status()).equals("1")) {
					continue;
				}	
				
					
				boolean result = requestBP(bplist);

				if (result) {
					for (BloodPressure bpVo : bplist)
						bloodPressureDAO.updateBloodGlucoseOperateState(bpVo.getId(), (short) 1);
				}
				else{
					for (BloodPressure bpVo : bplist){
						bloodPressureDAO.updateBloodGlucoseOperateState(bpVo.getId(), (short) 2);
				}
				}
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public boolean requestBP(List<BloodPressure> bloodPressure) throws Exception {
			String stamptime= String.valueOf(new Date().getTime());
		boolean requestBP = false;
		String url="http://10.232.196.2:8027/api/MeasureDataApi/MeasureData";
		Patdata patdata = new Patdata();
		patdata.setIdcard(bloodPressure.get(0).getIdCard());
		patdata.setMeasureTime((bloodPressure.get(0).getCheckTime().replace(" ","")));
		patdata.setMeasureAppId("0002");
		patdata.setMeasureLocation(String.valueOf(1));
		patdata.setMeasureOrgId("42505784600");
		patdata.setMeasureMode(String.valueOf(2));
		int card_size=bloodPressure.get(0).getCardNumber().length();
		if(card_size==9){
			patdata.setHospitalcadtype("1");
		}
		if(card_size>10){
			patdata.setHospitalcadtype("2");
		}
		patdata.setHospitalcadno(bloodPressure.get(0).getCardNumber());
		patdata.setTimestamp(stamptime);
		patdata.setSign(new Md5Util().sign("|"+bloodPressure.get(0).getIdCard()+"|0002|"+stamptime+"|"));
		BloodGlucoseVo bpVo1 = new BloodGlucoseVo();
		String clsb = null;
		if (bloodPressure.get(bloodPressure.size()-1).getHand().equals("left")) {
			clsb = String.valueOf(1);
		} else if (bloodPressure.get(bloodPressure.size()-1).getHand().equals("right")) {
			clsb = String.valueOf(2);
		} else {
			clsb = String.valueOf(3);
		}
		StringBuffer buffer=new StringBuffer();
		StringBuffer stringBuffer=new StringBuffer();
		stringBuffer.append(bloodPressure.get(0).getSystolicPressure() + "|" + bloodPressure.get(0).getDiastolicPressure() + "|" + clsb);
			for (int i=1;i<bloodPressure.size();i++){
				stringBuffer.append("|"+bloodPressure.get(i).getSystolicPressure() + "|" + bloodPressure.get(i).getDiastolicPressure());

			}
		bpVo1.setMeasureType(String.valueOf(1001)); //血压
		bpVo1.setMeasureData(String.valueOf(stringBuffer));
		BloodGlucoseVo bpVo2 = new BloodGlucoseVo();
		bpVo2.setMeasureType(String.valueOf(1002)); //脉搏
		bpVo2.setMeasureData(bloodPressure.get(0).getPluse());
		List <BloodGlucoseVo> datalist = new ArrayList<BloodGlucoseVo>();
		datalist.add(bpVo1);
		datalist.add(bpVo2);
		patdata.setDataList(datalist);
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
		String result=sendHttpPost(url,json.toString());
		JSONObject resultJson = JSONObject.fromObject(result);
		String code = resultJson.getString("retcode");
		if (code.equals("0")) {
			requestBP = true;
		}
		System.out.println("返回结果：" + result);
		return requestBP;
	}
	private boolean isBG = true;
	public boolean requestSG(PatientBmiView patientBmiView) throws Exception {
		boolean requestXT = false;
		String url="http://10.232.196.2:8027/api/MeasureDataApi/MeasureData";
		String stamptime= String.valueOf(new Date().getTime());
		Patdata patdata = new Patdata();
		IdcardInfoExtractor idcardInfo = new IdcardInfoExtractor(String.valueOf(patientBmiView.getIdcard()));
		patdata.setIdcard(patientBmiView.getIdcard());
		patdata.setMeasureTime((patientBmiView.getMearsuretime().replace(" ","")));
		patdata.setMeasureAppId("0002");
		patdata.setMeasureLocation(String.valueOf(1));
		patdata.setMeasureOrgId("42505784600");
		patdata.setMeasureMode(String.valueOf(2));
		int card_size=patientBmiView.getCardNumber().length();
		if(card_size==9){
			patdata.setHospitalcadtype("1");
		}
		if(card_size==10){
			patdata.setHospitalcadtype("2");
		}
		patdata.setHospitalcadno(patientBmiView.getCardNumber());
		patdata.setTimestamp(stamptime);
		patdata.setSign(new Md5Util().sign("|"+patientBmiView.getIdcard()+"|0002|"+stamptime+"|"));
		BloodGlucoseVo bloodGlucoseVo=new BloodGlucoseVo();
		BloodGlucoseVo bloodGlucoseVo2=new BloodGlucoseVo();
		String resultBg = "";
		bloodGlucoseVo.setMeasureType("1003");
		bloodGlucoseVo.setMeasureData(patientBmiView.getHeight());
		bloodGlucoseVo2.setMeasureType("1004");
		bloodGlucoseVo2.setMeasureData(patientBmiView.getWeight());
		List <BloodGlucoseVo> datalist = new ArrayList<BloodGlucoseVo>();
		datalist.add(bloodGlucoseVo);
		datalist.add(bloodGlucoseVo2);
		patdata.setDataList(datalist);
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
		String result=sendHttpPost(url,json.toString());
		JSONObject resultJson = JSONObject.fromObject(result);
		String code = resultJson.getString("retcode");
		if (code.equals("0")) {
			requestXT = true;
		}
		System.out.println("返回结果：" + result);
		return requestXT;
	}
	public boolean requestXT(BloodGlucose bloodGlucose) throws Exception {
		boolean requestXT = false;
		String url="http://10.232.196.2:8027/api/MeasureDataApi/MeasureData";
		String stamptime= String.valueOf(new Date().getTime());
		Patdata patdata = new Patdata();
		IdcardInfoExtractor idcardInfo = new IdcardInfoExtractor(String.valueOf(bloodGlucose.getIdCard()));
		patdata.setIdcard(bloodGlucose.getIdCard());
		//patdata.setIdcard("340122196309080176");
		patdata.setMeasureTime(Constants.convert(Constants.convert(bloodGlucose.getMeasureTime(), Constants.format2), Constants.format2));
		patdata.setMeasureAppId("0002");
		patdata.setMeasureLocation(String.valueOf(1));
		patdata.setMeasureOrgId("42505784600");
		patdata.setMeasureMode(String.valueOf(2));
		int card_size=bloodGlucose.getCardNumber().length();
		if(card_size==9){
			patdata.setHospitalcadtype("1");
		}
		if(card_size==10){
			patdata.setHospitalcadtype("2");
		}
		patdata.setHospitalcadno(bloodGlucose.getCardNumber());
		patdata.setTimestamp(stamptime);
		//patdata.setSign(new Md5Util().sign("|"+"340122196309080176"+"|0002|"+stamptime+"|"));
		patdata.setSign(new Md5Util().sign("|"+bloodGlucose.getIdCard()+"|0002|"+stamptime+"|"));
		BloodGlucoseVo bloodGlucoseVo=new BloodGlucoseVo();
		String bgStatus = bloodGlucose.getStatus();
		String status = "";
		switch (bgStatus) {
			case "KF":
				status = "1";
			case "ZCH":
				status = "2";
			case "WUCQ":
				status = "1";
			case "WUCH":
				status = "2";
			case "WACQ":
				status = "1";
			case "WACH":
				status = "2";
			case "SQ":
				status = "3";
			case "LC":
				status = "3";
			case "LC3":
				status = "3";
			case "SJ":
				status = "3";
				break;
			default:
				break;
		}
		Double value = bloodGlucose.getValue();
		String resultBg = "";
		if (value < 3.3) {
			resultBg ="4";
		}else if (!value.equals(991) && !value.equals(990) && value > 11.0){
			resultBg ="3";
		}else if (value.equals(991) || value.equals(990)){
			resultBg ="2";
		}else
			resultBg = "1";

		bloodGlucoseVo.setMeasureType("2001");
		bloodGlucoseVo.setMeasureData(bloodGlucose.getValue()+"|"+"mmol/L" +"|"+"0.6-33.3"+"|"+resultBg+"|"+status+"|"+ "1");
		List <BloodGlucoseVo> datalist = new ArrayList<BloodGlucoseVo>();
		datalist.add(bloodGlucoseVo);
		patdata.setDataList(datalist);
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
		String result=sendHttpPost(url,json.toString());
		JSONObject resultJson = JSONObject.fromObject(result);
		String code = resultJson.getString("retcode");
		if (code.equals("0")) {
			requestXT = true;
		}
		System.out.println("返回结果：" + result);
		return requestXT;
	}
	public class sortClass implements Comparator {
		public int compare(Object arg0, Object arg1) {
			BloodPressure bp0 = (BloodPressure) arg0;
			BloodPressure bp1 = (BloodPressure) arg1;
			int flag = bp0.getId().compareTo(bp1.getId());
			return flag;
		}
	}
	public String sendHttpPost(String url, String body) throws Exception {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		httpPost.addHeader("Content-Type", "application/json;charset=UTF-8");
		StringEntity stringEntity = new StringEntity(body,"utf-8");
		httpPost.setEntity(stringEntity);
		CloseableHttpResponse response = httpClient.execute(httpPost);
		HttpEntity entity = response.getEntity();
		String responseContent = EntityUtils.toString(entity, "UTF-8");
		response.close();
		httpClient.close();
		return responseContent;
	}

}