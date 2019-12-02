package com.hesicare.hospital.common.jobs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import com.hesicare.hospital.common.utils.HospitalEnum;
import com.hesicare.hospital.common.utils.MapUtils;
import com.hesicare.hospital.health.dao.BloodGlucoseDAO;
import com.hesicare.hospital.health.dao.PatientBmiViewDao;
import com.hesicare.hospital.health.dao.PressureHeartDao;
import com.hesicare.hospital.health.entity.*;
import net.sf.json.JSONArray;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hesicare.hospital.common.utils.Constants;
import com.hesicare.hospital.health.dao.BloodPressureDAO;
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

	@Autowired
	private PatientBmiViewDao patientBmiViewDao;
	@Autowired
	private BloodGlucoseDAO bloodGlucoseDAO;
	@Autowired
	private PressureHeartDao pressureHeartDao;
    static String hearturl="http://172.30.2.115:9071/measure/api/xttz/xtjcSubmit";
	@Scheduled(cron = "0 0 00 ? * MON")
	public void removeLog() {
		try {
			delLog("D:/Hesicare/java项目/logs/");
		}catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/*
	 *
	 * 血压设备检测
	 * */
	@Scheduled(cron = "0 0/1 * * * ?")
	public void doHeartBeat()throws Exception {
		int nowTime= Integer.parseInt(new SimpleDateFormat("k").format(new Date()));
		if(nowTime>6&&nowTime<18){
			List<Pressure_Heartbeat> list=pressureHeartDao.getheartbeat();
			for (Pressure_Heartbeat pressure_heartbeat : list) {
				if(pressure_heartbeat.getStatus().equals("0")){
					HeartBeat body=new HeartBeat();
					HospitalEnum hospitalEnum=info(pressure_heartbeat.getDept_id());
					body.setHostdevicecode("5B"+pressure_heartbeat.getEquipment_sn());
					body.setDeviceCode("5B"+pressure_heartbeat.getEquipment_sn());
					body.setDeviceType("1");
					body.setHospatilid(hospitalEnum.getComcode());
					body.setHosttime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
					printwrites("D:/Hesicare/java项目/logs/HeartBeat/xy/"+new SimpleDateFormat("yyyy-MM-dd").format(new Date()) +".txt",""+pressure_heartbeat.getDept_name()+"-"+pressure_heartbeat.getEquipment_sn() +"-"+ Constants.convert(new Date(), Constants.format2)+JSONObject.fromObject(body));
					String code=HeartHttp(body);
					if (code.equals("0")) {
						pressureHeartDao.updateheartbeat(pressure_heartbeat.getId());
						printwrites("D:/Hesicare/java项目/logs/HeartBeat/xy/"+new SimpleDateFormat("yyyy-MM-dd").format(new Date()) +".txt",""+pressure_heartbeat.getDept_name()+"-"+pressure_heartbeat.getEquipment_sn()+"设备检测第一次：" + Constants.convert(new Date(), Constants.format2));
					}
				}
				else{
					String now=new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
					Long measure=new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(pressure_heartbeat.getMearsure_time()).getTime();
					Long nowtime=new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(now).getTime();
					Long l=nowtime-measure;
					Long hour=(l/(60*60*1000));
					Long  min=(l/(60*1000));
					if(min%30==0){
						HeartBeat body=new HeartBeat();
						HospitalEnum hospitalEnum=info(pressure_heartbeat.getDept_id());
						body.setHostdevicecode("5B"+pressure_heartbeat.getEquipment_sn());
						body.setDeviceCode("5B"+pressure_heartbeat.getEquipment_sn());
						body.setDeviceType("2");
						body.setHospatilid(hospitalEnum.getComcode());
						body.setHosttime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
						printwrites("D:/Hesicare/java项目/logs/HeartBeat/xy/"+new SimpleDateFormat("yyyy-MM-dd").format(new Date()) +".txt", String.format("" + pressure_heartbeat.getDept_name() + "-" + pressure_heartbeat.getEquipment_sn() + "-" + Constants.convert(new Date(), Constants.format2) + JSONObject.fromObject(body)));
						String code=HeartHttp(body);
						if (!code.isEmpty()) {
							printwrites("D:/Hesicare/java项目/logs/HeartBeat/xy/"+new SimpleDateFormat("yyyy-MM-dd").format(new Date()) +".txt",""+pressure_heartbeat.getDept_name()+"-"+pressure_heartbeat.getEquipment_sn()+"设备检测：" + Constants.convert(new Date(), Constants.format2));
						}
					}
				}

			}
		}

	}
/*
*
* 血糖设备检测
* */
@Scheduled(cron = "0 0/1 * * * ?")
	public void doGlucoseHeartBeat()throws Exception {
		int nowTime= Integer.parseInt(new SimpleDateFormat("k").format(new Date()));
		if(nowTime>6&&nowTime<18){
			List<Glucose_Heartbeat> list=pressureHeartDao.getglucoseheartbeat();
			for (Glucose_Heartbeat glucose_heartbeat : list) {
				if(glucose_heartbeat.getStatus().equals("0")){
					HeartBeat body=new HeartBeat();
					HospitalEnum hospitalEnum=info(glucose_heartbeat.getDept_id());
					if(glucose_heartbeat.getEquipment_sn().length()>11){
						body.setHostdevicecode(glucose_heartbeat.getEquipment_sn().replace("Contour",""));
						body.setDeviceCode(glucose_heartbeat.getEquipment_sn().replace("Contour",""));}
					else
					{
						body.setHostdevicecode(glucose_heartbeat.getEquipment_sn());
						body.setDeviceCode(glucose_heartbeat.getEquipment_sn());
					}
					body.setDeviceType("1");
					body.setHospatilid(hospitalEnum.getComcode());
					body.setHosttime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
					printwrites("D:/Hesicare/java项目/logs/HeartBeat/xt/"+new SimpleDateFormat("yyyy-MM-dd").format(new Date()) +".txt",""+glucose_heartbeat.getDept_name()+"-"+glucose_heartbeat.getEquipment_sn() +"-"+ Constants.convert(new Date(), Constants.format2)+JSONObject.fromObject(body));
					String code=HeartHttp(body);
					if (code.equals("0")) {
						pressureHeartDao.updateglucoseheartbeat(glucose_heartbeat.getId());
						printwrites("D:/Hesicare/java项目/logs/HeartBeat/xt/"+new SimpleDateFormat("yyyy-MM-dd").format(new Date()) +".txt",""+glucose_heartbeat.getDept_name()+"-"+glucose_heartbeat.getEquipment_sn()+"设备检测第一次：" + Constants.convert(new Date(), Constants.format2));
					}
				}
				else{
					String now=new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
					Long measure=new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(glucose_heartbeat.getMearsure_time()).getTime();
					Long nowtime=new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(now).getTime();
					Long l=nowtime-measure;
					Long hour=(l/(60*60*1000));
					Long  min=(l/(60*1000));
					if(min%30==0){
						HeartBeat body=new HeartBeat();
						HospitalEnum hospitalEnum=info(glucose_heartbeat.getDept_id());
						if(glucose_heartbeat.getEquipment_sn().length()>11){
						body.setHostdevicecode(glucose_heartbeat.getEquipment_sn().replace("Contour",""));
						body.setDeviceCode(glucose_heartbeat.getEquipment_sn().replace("Contour",""));
						}

						else{
							body.setHostdevicecode(glucose_heartbeat.getEquipment_sn());
							body.setDeviceCode(glucose_heartbeat.getEquipment_sn());
						}
						body.setDeviceType("2");
						body.setHospatilid(hospitalEnum.getComcode());
						body.setHosttime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
						printwrites("D:/Hesicare/java项目/logs/HeartBeat/xt/"+new SimpleDateFormat("yyyy-MM-dd").format(new Date()) +".txt",""+glucose_heartbeat.getDept_name()+"-"+glucose_heartbeat.getEquipment_sn()+"-"+ Constants.convert(new Date(), Constants.format2)+JSONObject.fromObject(body));
						String code=HeartHttp(body);
						if(!code.isEmpty()){
							printwrites("D:/Hesicare/java项目/logs/HeartBeat/xt/"+new SimpleDateFormat("yyyy-MM-dd").format(new Date()) +".txt",""+glucose_heartbeat.getDept_name()+"-"+glucose_heartbeat.getEquipment_sn()+"设备检测：" + Constants.convert(new Date(), Constants.format2));
						}
					}
				}

			}
		}

	}
	public String HeartHttp(HeartBeat heartBeat) throws Exception {
		String body=heartBeat.tostrinng();
		String header = InterfaceEnCode.getInterfaceKey();
		CloseableHttpClient httpClient= HttpClientBuilder.create().setRedirectStrategy(new LaxRedirectStrategy()).build();
		HttpPost httpPost = new HttpPost(hearturl);
		httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
		httpPost.addHeader("access-token", header);
		List<BasicNameValuePair> values = new ArrayList();
		values.add(new BasicNameValuePair("param",body));
		HttpEntity entity = new UrlEncodedFormEntity(values,"utf-8");
		httpPost.setEntity(entity);
		CloseableHttpResponse response = httpClient.execute(httpPost);
		HttpEntity entitys = response.getEntity();
		String responseContent = EntityUtils.toString(entitys, "UTF-8");
		response.close();
		httpClient.close();
		JSONObject resultJson = JSONObject.fromObject(responseContent);
		String code= String.valueOf(resultJson.get("code"));
		return code;
	}
	@SuppressWarnings("unchecked")
	@Scheduled(cron = "0 0/3 * * * ?")
	public void doBmiIt() {
			try{
				List<PatientBmiView> bmiview =patientBmiViewDao.getBmiByState("0");
				for (PatientBmiView patientBmiView : bmiview) {
					printwrites("D:/Hesicare/java项目/logs/sg/"+patientBmiView.getDeptid()+"/"+new SimpleDateFormat("yyyy-MM-dd").format(new Date()) +".txt","job 身高定时器：" + Constants.convert(new Date(), Constants.format2));
					HospitalEnum hospitalEnum=info(patientBmiView.getDeptid());
					String comcode=hospitalEnum.getComcode();
					String name=hospitalEnum.getName();
					boolean result = requestSG(patientBmiView,comcode,name);
					if (result) {
						patientBmiViewDao.updateBmiState(patientBmiView.getId(),(short) 1);
					}
					else{
						patientBmiViewDao.updateBmiState(patientBmiView.getId(),(short) 3);
					}
					Thread.sleep(1000);
				}
			}
			catch (Exception e){
				e.printStackTrace();
			}

		}
	@Scheduled(cron = "0 0/1 * * * ?")
	public void doXueTangIt() {
		try {
			List<BloodGlucose> bloodGlucoses1 =bloodGlucoseDAO.getBloodGlucoseByOperateState("0");
			for (BloodGlucose bloodGlucose : bloodGlucoses1) {
				printwrites("D:/Hesicare/java项目/logs/xt/"+bloodGlucose.getDeptid()+"/"+new SimpleDateFormat("yyyy-MM-dd").format(new Date()) +".txt","job 血糖定时器：" + Constants.convert(new Date(), Constants.format2));
				HospitalEnum hospitalEnum=info(bloodGlucose.getDeptid());
				String comcode=hospitalEnum.getComcode();
				String name=hospitalEnum.getName();
				boolean result = requestXT(bloodGlucose,comcode,name);
				if (result) {
					bloodGlucoseDAO.updateBloodGlucoseOperateState(bloodGlucose.getId(), (short) 1);
				}
				else{
					bloodGlucoseDAO.updateBloodGlucoseOperateState(bloodGlucose.getId(), (short) 3);
				}
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	@Scheduled(cron = "0 0/1 * * * ?")
	public void doXueYaIt() {
		try {
			List<BloodPressure> bloodGlucoses1 = bloodPressureDAO.getBloodPressureByIdCard();
			Map<String, List<BloodPressure>> groupBy = bloodGlucoses1.stream().collect(Collectors.groupingBy(BloodPressure::getIdentifierCode));
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
				if (StringUtils.isBlank(bplist.get(0).getCheckTime())){	
					continue;
				}
				
				if (StringUtils.isBlank(bplist.get(0).getSystolicPressure())){	
					continue;
				}
				
				if (StringUtils.isBlank(bplist.get(0).getDiastolicPressure())){	
					continue;
				}
				
				if (bplist.size()<=2){
					continue;
				}
				
				if (String.valueOf(bplist.get(0).getIsAverage()).equals("0")) {
					continue;
				}
				
				if (String.valueOf(bplist.get(bplist.size()-1).getData_status()).equals("1")) {
					continue;
				}
				printwrites("D:/Hesicare/java项目/logs/xy/"+bplist.get(0).getDeptid()+"/"+new SimpleDateFormat("yyyy-MM-dd").format(new Date()) +".txt","job 血压定时器：" + Constants.convert(new Date(), Constants.format2));
				HospitalEnum hospitalEnum=info(bplist.get(0).getDeptid());
				boolean result=false;
				String comcode=hospitalEnum.getComcode();
				String name=hospitalEnum.getName();
		        result=requestBP(bplist,comcode,name);
				if (result) {
					for (BloodPressure bpVo : bplist)
						bloodPressureDAO.updateBloodGlucoseOperateState(bpVo.getId(), (short) 1);
				}
				else{
					for (BloodPressure bpVo : bplist)
						bloodPressureDAO.updateBloodGlucoseOperateState(bpVo.getId(), (short) 3);
				}
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private boolean isBG = true;
	public boolean requestSG(PatientBmiView patientBmiView,String comcode,String name) throws Exception {
		String url = "http://172.30.2.115:9071/measure/api/patSignSubmit";
		boolean requestXT = false;
		Patdata patdata = new Patdata();
		IdcardInfoExtractor idcardInfo = new IdcardInfoExtractor(String.valueOf(patientBmiView.getIdcard()));
		patdata.setPersoncard(patientBmiView.getIdcard());
		patdata.setMeasureTime(Constants.convert(Constants.convert(patientBmiView.getMearsuretime(), Constants.format2), Constants.format2));
		patdata.setMeasureSourceId(String.valueOf("0002"));
		patdata.setMeasureLocation(String.valueOf(3));
		patdata.setMeasureOrgId(comcode);
		patdata.setMeasureMode(String.valueOf(1));
		patdata.setDeviceId("2019082419072633005003");
		patdata.setDeviceType(String.valueOf("HS-3001"));
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
		printwrites("D:/Hesicare/java项目/logs/sg/"+patientBmiView.getDeptid()+"/"+new SimpleDateFormat("yyyy-MM-dd").format(new Date()) +".txt",name+"-请求数据：" + json.toString());
		String header = InterfaceEnCode.getInterfaceKey();
		map.put("param", InterfaceEnCode.encrypt(json.toString()));
		HttpClientUtil util = new HttpClientUtil();
		String result = util.doPost(header, url, map);
		JSONObject resultJson = JSONObject.fromObject(result);
		String code = resultJson.getString("code");
		if (code.equals("1")) {
			requestXT = true;
		}
		requestXT=true;
		printwrites("D:/Hesicare/java项目/logs/sg/"+patientBmiView.getDeptid()+"/"+new SimpleDateFormat("yyyy-MM-dd").format(new Date()) +".txt",name+"-"+result);
		return requestXT;
	}
	public boolean requestXT(BloodGlucose bloodGlucose,String comcode,String name) throws Exception {
		boolean requestXT = false;
		String url = "http://172.30.2.115:9071/measure/api/patSignSubmit";
		Patdata patdata = new Patdata();
		IdcardInfoExtractor idcardInfo = new IdcardInfoExtractor(String.valueOf(bloodGlucose.getIdCard()));
		patdata.setPersoncard(bloodGlucose.getIdCard());
		patdata.setMeasureTime(Constants.convert(Constants.convert(bloodGlucose.getMeasureTime(), Constants.format2), Constants.format2));
		patdata.setMeasureSourceId(String.valueOf("0002"));
		patdata.setMeasureLocation(String.valueOf(3));
		patdata.setMeasureOrgId(comcode);
		patdata.setMeasureMode(String.valueOf(1));
		if(bloodGlucose.getDeviceSn().length()>11){
			patdata.setDeviceId(bloodGlucose.getDeviceSn().replace("Contour",""));
		}
		else{
			patdata.setDeviceId(bloodGlucose.getDeviceSn());
		}
		patdata.setDeviceType(String.valueOf("Accu-Chek"));
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
		//System.out.println("请求数据：" + json.toString());
		printwrites("D:/Hesicare/java项目/logs/xt/"+bloodGlucose.getDeptid()+"/"+new SimpleDateFormat("yyyy-MM-dd").format(new Date()) +".txt",name+"-请求数据：" + json.toString());
		String header = InterfaceEnCode.getInterfaceKey();
		map.put("param", InterfaceEnCode.encrypt(json.toString()));
		HttpClientUtil util = new HttpClientUtil();
		String result = util.doPost(header, url, map);
		JSONObject resultJson = JSONObject.fromObject(result);
		String code = resultJson.getString("code");
		if (code.equals("1")) {
			requestXT = true;
		}
		requestXT=true;
		printwrites("D:/Hesicare/java项目/logs/xt/"+bloodGlucose.getDeptid()+"/"+new SimpleDateFormat("yyyy-MM-dd").format(new Date()) +".txt",name+"-"+"返回结果：" + result);
		return requestXT;
	}

	public boolean requestBP(List<BloodPressure> bplist,String comcode,String name) throws Exception {
		String url = "http://172.30.2.115:9071/measure/api/chronic/submit";
		boolean requestBP = false;
		Pwdbpdata bpdata = new Pwdbpdata();
		BloodPressure bp = bplist.get(bplist.size()-1);
    	IdcardInfoExtractor idcardInfo = new IdcardInfoExtractor(String.valueOf(bp.getIdCard().trim()));
    	bpdata.setSfzhm(String.valueOf(bp.getIdCard()).toUpperCase());
		bpdata.setClDate(Constants.convert(Constants.convert(bp.getCheckTime(), Constants.format1),Constants.format1));
		bpdata.setClff(String.valueOf(1));
		bpdata.setClysNm(String.valueOf("XXX"));
		bpdata.setClysNo(String.valueOf(000));

		if (StringUtils.isNotBlank(String.valueOf(bp.getBirth()))){
			bpdata.setCsDate(bp.getBirth());
		}else if (StringUtils.isNotBlank(String.valueOf(idcardInfo)) && idcardInfo.getBirthday() != null)
		{   bpdata.setCsDate(Constants.convert(idcardInfo.getBirthday(), Constants.format1));}
		else
		{
			bpdata.setCsDate("");
		}
		bpdata.setJykh(bp.getCardNumber());
		if (bp.getCardNumber().length()==9){
			bpdata.setJyklx(String.valueOf("1"));}
		if (bp.getCardNumber().length()==10){
			bpdata.setJyklx(String.valueOf("0"));}
		bpdata.setMeterNo("5B"+bp.getDeviceId());
		bpdata.setMeterType(String.valueOf("AND:TM-2656VP"));

		bpdata.setOrg(comcode);
		bpdata.setSourceId(String.valueOf("02"));

		bpdata.setStationId(String.valueOf("000"));


		if (StringUtils.isBlank(String.valueOf(idcardInfo.getGender()))) {
			bpdata.setXb("");
		} else if ((StringUtils.isNotBlank(String.valueOf(idcardInfo.getGender()))&& String.valueOf(idcardInfo.getGender()).equals("0"))) {
			bpdata.setXb(String.valueOf("2"));
		} else {
			bpdata.setXb(idcardInfo.getGender());
		}

		bpdata.setXm(bp.getNAME());

		BloodPressureVo bpVo = new BloodPressureVo();

		if (bp.getHand().equals("left")) {
			bpVo.setClsb(Integer.valueOf(1));
		} else if (bp.getHand().equals("right")) {
			bpVo.setClsb(Integer.valueOf(2));
		} else {
			bpVo.setClsb(Integer.valueOf(3));
		}
		if (bplist.size() == 2) {
			bpVo.setBgzmbjcTimes1(Integer.valueOf(0));
			bpVo.setDbp1(Integer.valueOf(bp.getDiastolicPressure()));
			bpVo.setSbp1(Integer.valueOf(bp.getSystolicPressure()));
			bpVo.setMb1(Integer.valueOf(bp.getPluse()));
			bpVo.setStydjcTimes1(Integer.valueOf(0));
			bpVo.setFinishTime1(Constants.convert(Constants.convert(bp.getCheckTime(), Constants.format2), Constants.format2));
			bpVo.setBgzmbjcTimes2(Integer.valueOf(0));
			bpVo.setDbp2(Integer.valueOf(bp.getDiastolicPressure()));
			bpVo.setSbp2(Integer.valueOf(bp.getSystolicPressure()));
			bpVo.setMb2(Integer.valueOf(bp.getPluse()));
			bpVo.setStydjcTimes2(Integer.valueOf(0));
			bpVo.setFinishTime2(Constants.convert(Constants.convert(bp.getCheckTime(), Constants.format2), Constants.format2));
			BloodPressure bp2 = bplist.get(0);
			bpVo.setSbpAve(bp2.getSystolicPressure());
			bpVo.setDbpAve(bp2.getDiastolicPressure());
			bpVo.setMbAve(bp2.getPluse());

		} else if (bplist.size() == 3) {
			BloodPressure bp1 = bplist.get(0);
			bpVo.setBgzmbjcTimes1(Integer.valueOf(2));
			bpVo.setDbp1(Integer.valueOf(bp1.getDiastolicPressure()));
			bpVo.setSbp1(Integer.valueOf(bp1.getSystolicPressure()));
			bpVo.setMb1(Integer.valueOf(bp1.getPluse()));
			bpVo.setStydjcTimes1(Integer.valueOf(0));
			bpVo.setFinishTime1(Constants.convert(Constants.convert(bp1.getCheckTime(), Constants.format2), Constants.format2));
			BloodPressure bp2 = bplist.get(1);
			bpVo.setBgzmbjcTimes2(Integer.valueOf(0));
			bpVo.setDbp2(Integer.valueOf(bp2.getDiastolicPressure()));
			bpVo.setSbp2(Integer.valueOf(bp2.getSystolicPressure()));
			bpVo.setMb2(Integer.valueOf(bp2.getPluse()));
			bpVo.setStydjcTimes2(Integer.valueOf(0));
			bpVo.setFinishTime2(Constants.convert(Constants.convert(bp2.getCheckTime(), Constants.format2), Constants.format2));
			BloodPressure bp3 = bplist.get(0);
			bpVo.setSbpAve(bp3.getSystolicPressure());
			bpVo.setDbpAve(bp3.getDiastolicPressure());
			bpVo.setMbAve(bp3.getPluse());
		}
		else if (bplist.size() == 4) {

			BloodPressure bp1 = bplist.get(3);

			bpVo.setBgzmbjcTimes1(Integer.valueOf(0));
			bpVo.setDbp1(Integer.valueOf(bp1.getDiastolicPressure()));
			bpVo.setSbp1(Integer.valueOf(bp1.getSystolicPressure()));
			bpVo.setMb1(Integer.valueOf(bp1.getPluse()));
			bpVo.setStydjcTimes1(Integer.valueOf(0));
			bpVo.setFinishTime1(Constants.convert(Constants.convert(bp1.getCheckTime(), Constants.format2), Constants.format2));
			BloodPressure bp2 = bplist.get(2);
			bpVo.setBgzmbjcTimes2(Integer.valueOf(0));
			bpVo.setDbp2(Integer.valueOf(bp2.getDiastolicPressure()));
			bpVo.setSbp2(Integer.valueOf(bp2.getSystolicPressure()));
			bpVo.setMb2(Integer.valueOf(bp2.getPluse()));
			bpVo.setStydjcTimes2(Integer.valueOf(0));
			bpVo.setFinishTime2(Constants.convert(Constants.convert(bp2.getCheckTime(), Constants.format2), Constants.format2));
			BloodPressure bp3 = bplist.get(1);
			bpVo.setBgzmbjcTimes3(Integer.valueOf(0));
			bpVo.setDbp3(Integer.valueOf(bp3.getDiastolicPressure()));
			bpVo.setSbp3(Integer.valueOf(bp3.getSystolicPressure()));
			bpVo.setMb3(Integer.valueOf(bp3.getPluse()));
			bpVo.setStydjcTimes3(Integer.valueOf(0));
			bpVo.setFinishTime3(Constants.convert(Constants.convert(bp3.getCheckTime(), Constants.format2), Constants.format2));
			BloodPressure bp4 = bplist.get(0);
			bpVo.setSbpAve(bp4.getSystolicPressure());
			bpVo.setDbpAve(bp4.getDiastolicPressure());
			bpVo.setMbAve(bp4.getPluse());
		}else if (bplist.size() > 4) {
			BloodPressure bp1 = bplist.get(bplist.size()-1);
			bpVo.setBgzmbjcTimes1(Integer.valueOf(0));
			bpVo.setDbp1(Integer.valueOf(bp1.getDiastolicPressure()));
			bpVo.setSbp1(Integer.valueOf(bp1.getSystolicPressure()));
			bpVo.setMb1(Integer.valueOf(bp1.getPluse()));
			bpVo.setStydjcTimes1(Integer.valueOf(0));
			bpVo.setFinishTime1(Constants.convert(Constants.convert(bp1.getCheckTime(), Constants.format2), Constants.format2));
			BloodPressure bp2 = bplist.get(2);
			bpVo.setBgzmbjcTimes2(Integer.valueOf(0));
			bpVo.setDbp2(Integer.valueOf(bp2.getDiastolicPressure()));
			bpVo.setSbp2(Integer.valueOf(bp2.getSystolicPressure()));
			bpVo.setMb2(Integer.valueOf(bp2.getPluse()));
			bpVo.setStydjcTimes2(Integer.valueOf(0));
			bpVo.setFinishTime2(Constants.convert(Constants.convert(bp2.getCheckTime(), Constants.format2), Constants.format2));
			BloodPressure bp3 = bplist.get(1);
			bpVo.setBgzmbjcTimes3(Integer.valueOf(0));
			bpVo.setDbp3(Integer.valueOf(bp3.getDiastolicPressure()));
			bpVo.setSbp3(Integer.valueOf(bp3.getSystolicPressure()));
			bpVo.setMb3(Integer.valueOf(bp3.getPluse()));
			bpVo.setStydjcTimes3(Integer.valueOf(0));
			bpVo.setFinishTime3(Constants.convert(Constants.convert(bp3.getCheckTime(), Constants.format2), Constants.format2));
			BloodPressure bp4 = bplist.get(0);
			bpVo.setSbpAve(bp4.getSystolicPressure());
			bpVo.setDbpAve(bp4.getDiastolicPressure());
			bpVo.setMbAve(bp4.getPluse());
		}
		List<BloodPressureVo> datalist = new ArrayList<BloodPressureVo>();
		datalist.add(bpVo);
		bpdata.setCljgList(datalist);
		JsonConfig jsonConfig = new JsonConfig();
		PropertyFilter filter = new PropertyFilter() {
			public boolean apply(Object object, String fieldName, Object fieldValue) {
				return null == fieldValue;
			}
		};
		jsonConfig.setJsonPropertyFilter(filter);
		JSONObject json = JSONObject.fromObject(bpdata, jsonConfig);
		printwrites("D:/Hesicare/java项目/logs/xy/"+bplist.get(0).getDeptid()+"/"+new SimpleDateFormat("yyyy-MM-dd").format(new Date()) +".txt",name+"-请求数据：" + json.toString());
		String result = this.sendHttpPost(url, json.toString());
		JSONObject resultJson = JSONObject.fromObject(result);
		printwrites("D:/Hesicare/java项目/logs/xy/"+bplist.get(0).getDeptid()+"/"+new SimpleDateFormat("yyyy-MM-dd").format(new Date()) +".txt",name+"-"+"返回结果：" + result);
		String code=resultJson.getString("errno");
		if(code.equals("0")){
			requestBP = true;
		}
		return requestBP;
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
		String header = InterfaceEnCode.getInterfaceKey();
		HttpPost httpPost = new HttpPost(url);
		httpPost.addHeader("Content-Type", "application/json;charset=UTF-8");
		httpPost.setHeader("access-token", header);
		httpPost.setEntity(new StringEntity(body, "UTF-8"));
		CloseableHttpResponse response = httpClient.execute(httpPost);
		HttpEntity entity = response.getEntity();
		String responseContent = EntityUtils.toString(entity, "UTF-8");
		response.close();
		httpClient.close();
		return responseContent;
	}
	public  static  void  delLog(String filename) throws ParseException {
		File file=new File(filename);
		if(file.isDirectory()){
			for (File listFile : file.listFiles()) {
				if (listFile.isDirectory()){
					delLog(listFile.getPath());
				}
				else{
					String logname=listFile.getName().substring(0,9);
					if(DateCompare( new SimpleDateFormat( "yyyy-MM-dd").parse(logname))){
						listFile.delete();
					}
				}
			}
		}
	}
	public static  boolean DateCompare(Date name){
		Date now =new Date();
		Calendar calendar = Calendar.getInstance();  //得到日历
		calendar.setTime(now);//把当前时间赋给日历
		calendar.add(Calendar.DAY_OF_MONTH, -7);  //设置为7天前
		Date before7days = calendar.getTime();   //得到7天前的时间
		if(before7days.getTime() < name.getTime()){
			return true;
		}else{
			return false;
		}
	}
	public  void printwrites(String filename,String content){
		//System.out.println(filename);
		FileWriter fileWriter=null;
		try {
			File f=new File(filename);
			File parent=f.getParentFile();
			if (!parent.exists()){
				parent.mkdirs();}
			if (!f.exists()){
				f.createNewFile();}
			fileWriter=new FileWriter(f,true);
			PrintWriter printWriter=new PrintWriter(fileWriter);
			printWriter.println(content);
			printWriter.flush();
			fileWriter.flush();
			printWriter.close();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public  HospitalEnum info(String comcode){
		HospitalEnum hospitalEnum=null;
		switch (comcode) {
			case "349":
				hospitalEnum=HospitalEnum.cn_hq;
				return  hospitalEnum;
			case "350":
				hospitalEnum=HospitalEnum.cn_cj;
				return  hospitalEnum;
			case "351":
				hospitalEnum=HospitalEnum.cn_zjq;
				return  hospitalEnum;
			case "352":
				hospitalEnum=HospitalEnum.cn_js;
				return  hospitalEnum;
			case "353":
				hospitalEnum=HospitalEnum.cn_ts;
				return  hospitalEnum;
			default:
				break;
		}
		return  hospitalEnum;
	}
}