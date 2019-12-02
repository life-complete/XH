package com.sybercare.hospital.common.jobs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import com.sybercare.hospital.common.utils.HospitalEnum;
import com.sybercare.hospital.health.dao.BloodGlucoseDAO;
import com.sybercare.hospital.health.dao.PatientBmiViewDao;
import com.sybercare.hospital.health.entity.BloodGlucose;
import com.sybercare.hospital.health.entity.PatientBmiView;
import com.sybercare.hospital.health.mappering.TripartiteDeviceMapper;
import net.sf.json.JSONArray;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
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

	@Autowired
	private PatientBmiViewDao patientBmiViewDao;
	@Autowired
	private BloodGlucoseDAO bloodGlucoseDAO;
	@Scheduled(cron = "0 0 00 ? * MON")
	public void removeLog() {
		try {
			delLog("C:/Hesicare/java项目/logs/");
		}catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Scheduled(cron = "0 0/3 * * * ?")
	public void doBmiIt() {
			try{
				List<PatientBmiView> bmiview =patientBmiViewDao.getBmiByState("0");
				for (PatientBmiView patientBmiView : bmiview) {
					printwrites("C:/Hesicare/java项目/logs/sg/"+patientBmiView.getDeptid()+"/"+new SimpleDateFormat("yyyy-MM-dd").format(new Date()) +".txt","job 身高定时器：" + Constants.convert(new Date(), Constants.format2));
					HospitalEnum hospitalEnum=info(patientBmiView.getDeptid());
					String url=hospitalEnum.getUrl()+hospitalEnum.getOthertype();
					String comcode=hospitalEnum.getComcode();
					String name=hospitalEnum.getName();
					boolean result = requestSG(patientBmiView,url,comcode,name);
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
			List<BloodGlucose> bloodGlucoses1 =bloodGlucoseDAO.getBloodGlucoseByOperateState("0");
			for (BloodGlucose bloodGlucose : bloodGlucoses1) {
				printwrites("C:/Hesicare/java项目/logs/xt/"+bloodGlucose.getDeptid()+"/"+new SimpleDateFormat("yyyy-MM-dd").format(new Date()) +".txt","job 血糖定时器：" + Constants.convert(new Date(), Constants.format2));
				HospitalEnum hospitalEnum=info(bloodGlucose.getDeptid());
				String url=hospitalEnum.getUrl()+hospitalEnum.getOthertype();
				String comcode=hospitalEnum.getComcode();
				String name=hospitalEnum.getName();
				boolean result = requestXT(bloodGlucose,url,comcode,name);
				if (result) {
					bloodGlucoseDAO.updateBloodGlucoseOperateState(bloodGlucose.getId(), (short) 1);
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
				
				if (bplist.size()<=2) {
					continue;
				}
				
				if (String.valueOf(bplist.get(0).getIsAverage()).equals("0")) {
					continue;
				}
				
				if (String.valueOf(bplist.get(bplist.size()-1).getData_status()).equals("1")) {
					continue;
				}

				printwrites("C:/Hesicare/java项目/logs/xy/"+bplist.get(0).getDeptid()+"/"+new SimpleDateFormat("yyyy-MM-dd").format(new Date()) +".txt","job 血压定时器：" + Constants.convert(new Date(), Constants.format2));
				HospitalEnum hospitalEnum=info(bplist.get(0).getDeptid());
				String url=hospitalEnum.getUrl()+hospitalEnum.getBptype();
				String comcode=hospitalEnum.getComcode();
				String name=hospitalEnum.getName();
				String resultname=hospitalEnum.getResultname();
				String resultnum=hospitalEnum.getResultnum();
				boolean result=false;
				if(name=="临汾"){
					             result = requestBPJY(bplist,url,comcode,name,resultname,resultnum);
				                }
				if(name=="天目"){
				                 result=requestBP(bplist,url,comcode,name,resultname,resultnum);
				                }
				if (result) {
					for (BloodPressure bpVo : bplist)
						bloodPressureDAO.updateBloodGlucoseOperateState(bpVo.getId(), (short) 1);
				}
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private boolean isBG = true;
	public boolean requestSG(PatientBmiView patientBmiView,String url,String comcode,String name) throws Exception {
		boolean requestXT = false;
		Patdata patdata = new Patdata();
		IdcardInfoExtractor idcardInfo = new IdcardInfoExtractor(String.valueOf(patientBmiView.getIdcard()));
		patdata.setPersoncard(patientBmiView.getIdcard());
		patdata.setMeasureTime(Constants.convert(Constants.convert(patientBmiView.getMearsuretime(), Constants.format2), Constants.format2));
		patdata.setMeasureSourceId(String.valueOf("0005"));
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
		printwrites("C:/Hesicare/java项目/logs/sg/"+patientBmiView.getDeptid()+"/"+new SimpleDateFormat("yyyy-MM-dd").format(new Date()) +".txt",name+"-请求数据：" + json.toString());
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
		printwrites("C:/Hesicare/java项目/logs/sg/"+patientBmiView.getDeptid()+"/"+new SimpleDateFormat("yyyy-MM-dd").format(new Date()) +".txt",name+"-"+result);
		return requestXT;
	}
	public boolean requestXT(BloodGlucose bloodGlucose,String url,String comcode,String name) throws Exception {
		boolean requestXT = false;
		//String url="http://192.168.9.114:9071/measure/api/patSignSubmit";
		Patdata patdata = new Patdata();
		IdcardInfoExtractor idcardInfo = new IdcardInfoExtractor(String.valueOf(bloodGlucose.getIdCard()));
		patdata.setPersoncard(bloodGlucose.getIdCard());
		patdata.setMeasureTime(Constants.convert(Constants.convert(bloodGlucose.getMeasureTime(), Constants.format2), Constants.format2));
		patdata.setMeasureSourceId(String.valueOf("0005"));
		patdata.setMeasureLocation(String.valueOf(3));
		patdata.setMeasureOrgId("comcode");
		patdata.setMeasureMode(String.valueOf(1));
		patdata.setDeviceId(bloodGlucose.getDeviceSn());
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
		printwrites("C:/Hesicare/java项目/logs/xt/"+bloodGlucose.getDeptid()+"/"+new SimpleDateFormat("yyyy-MM-dd").format(new Date()) +".txt",name+"-请求数据：" + json.toString());
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
		printwrites("C:/Hesicare/java项目/logs/xt/"+bloodGlucose.getDeptid()+"/"+new SimpleDateFormat("yyyy-MM-dd").format(new Date()) +".txt",name+"-"+"返回结果：" + result);
		//System.out.println("返回结果：" + result);
		return requestXT;
	}
	public boolean requestBPJY(List<BloodPressure> bloodPressure ,String url,String comcode,String name,String resultname,String resultnum) throws Exception {
		boolean requestBP = false;
		//String url="http://192.168.9.114:9071/measure/api/patSignSubmit";
		Patdata patdata = new Patdata();
		patdata.setPersoncard(bloodPressure.get(0).getIdCard());
		patdata.setMeasureTime(Constants.convert(Constants.convert(bloodPressure.get(0).getCheckTime(), Constants.format2), Constants.format2));
		patdata.setMeasureSourceId("0005");
		patdata.setMeasureLocation(String.valueOf(1));
		patdata.setMeasureOrgId("42508125600");
		patdata.setMeasureMode(String.valueOf(2));
		patdata.setDeviceId(bloodPressure.get(0).getDeviceId());
		patdata.setDeviceType(String.valueOf("AND:TM-2656VP"));
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
			}};
		jsonConfig.setJsonPropertyFilter(filter);
		JSONObject json = JSONObject.fromObject(patdata, jsonConfig);
		printwrites("C:/Hesicare/java项目/logs/xy/"+bloodPressure.get(0).getDeptid()+"/"+new SimpleDateFormat("yyyy-MM-dd").format(new Date()) +".txt",name+"-请求数据：" + json.toString());
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
		printwrites("C:/Hesicare/java项目/logs/xy/"+bloodPressure.get(0).getDeptid()+"/"+new SimpleDateFormat("yyyy-MM-dd").format(new Date()) +".txt",name+"-"+"返回结果：" + result);
		return requestBP;

	}

	public boolean requestBP(List<BloodPressure> bplist,String url,String comcode,String name,String resultname,String resultnum) throws Exception {
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
		bpdata.setMeterNo(bp.getDeviceId());
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
		printwrites("C:/Hesicare/java项目/logs/xy/"+bplist.get(0).getDeptid()+"/"+new SimpleDateFormat("yyyy-MM-dd").format(new Date()) +".txt",name+"-请求数据：" + json.toString());
		String result = this.sendHttpPost(url, json.toString());

		JSONObject resultJson = JSONObject.fromObject(result);
		printwrites("C:/Hesicare/java项目/logs/xy/"+bplist.get(0).getDeptid()+"/"+new SimpleDateFormat("yyyy-MM-dd").format(new Date()) +".txt",name+"-"+"返回结果：" + result);
		String code=resultJson.getString(resultname);
		if(code.equals(resultnum)){
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
		// System.out.println(response.getStatusLine().getStatusCode() + "\n");
		HttpEntity entity = response.getEntity();
		String responseContent = EntityUtils.toString(entity, "UTF-8");
		// System.out.println(responseContent);
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
	public HospitalEnum info(String comcode){
		HospitalEnum hospitalEnum=null;
		if(comcode.equals("350")){hospitalEnum=HospitalEnum.ja_lf;}
		if (comcode.equals("352")){hospitalEnum=HospitalEnum.ja_tm;}
		return  hospitalEnum;
	}
}