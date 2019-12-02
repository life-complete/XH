package com.hesicare.hospital.common.jobs;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import com.hesicare.hospital.common.utils.HospitalEnum;
import com.hesicare.hospital.health.dao.BloodGlucoseDAO;
import com.hesicare.hospital.health.dao.PatientBmiViewDao;
import com.hesicare.hospital.health.entity.BloodGlucose;
import com.hesicare.hospital.health.entity.PatientBmiView;
import com.hesicare.hospital.health.mappering.TripartiteDeviceMapper;
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
	@Autowired
	private BloodPressureDAO bloodPressureDAO;
	@Autowired
	private PatientBmiViewDao patientBmiViewDao;
	@Autowired
	private BloodGlucoseDAO bloodGlucoseDAO;
	@Scheduled(cron = "0 0/3 * * * ?")
	public void doBmiIt() {
			try{
				List<PatientBmiView> bmiview =patientBmiViewDao.getBmiByState("0");
				for (PatientBmiView patientBmiView : bmiview) {
					printwrites("C:/Hesicare/java接口/logs/sg/"+patientBmiView.getDeptid()+"/"+new SimpleDateFormat("yyyy-MM-dd").format(new Date()) +".txt","job 身高定时器：" + Constants.convert(new Date(), Constants.format2));
					HospitalEnum hospitalEnum=info(patientBmiView.getDeptid());
					String comcode=hospitalEnum.getComcode();
					String name=hospitalEnum.getName();
					boolean result = requestSG(patientBmiView,comcode,name);
					if (result) {
						//bloodGlucoseDAO.updateBloodGlucoseOperateState(patientBmiView.getId(), (short) 1);
						patientBmiViewDao.updateBmiState(patientBmiView.getId(),(short) 1);
					}
					Thread.sleep(1000);
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
			//List<BloodPressure> bloodGlucoses1 = bloodPressureDAO.getBloodPressureByOperateState();
			List<BloodGlucose> bloodGlucoses1 =bloodGlucoseDAO.getBloodGlucoseByOperateState("0");
		//	System.out.println(bloodGlucoses1);
			for (BloodGlucose bloodGlucose : bloodGlucoses1) {
				printwrites("C:/Hesicare/java接口/logs/xt/"+bloodGlucose.getDeptid()+"/"+new SimpleDateFormat("yyyy-MM-dd").format(new Date()) +".txt","job 血糖定时器：" + Constants.convert(new Date(), Constants.format2));
				HospitalEnum hospitalEnum=info(bloodGlucose.getDeptid());
				String comcode=hospitalEnum.getComcode();
				String name=hospitalEnum.getName();
				boolean result = requestXT(bloodGlucose,comcode,name);
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
	public void doXueYaIt() {
		try {
			//printwrites("E:/Hesicare/接口文件/xy/"+new SimpleDateFormat("yyyy-MM-dd").format(new Date()) +".txt","job 血压定时器：" + Constants.convert(new Date(), Constants.format2));

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

				if (StringUtils.isBlank(bplist.get(0).getCheckTime())){	
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
				printwrites("C:/Hesicare/java接口/logs/xy/"+bplist.get(0).getDeptid()+"/"+new SimpleDateFormat("yyyy-MM-dd").format(new Date()) +".txt","job 血压定时器：" + Constants.convert(new Date(), Constants.format2));
				HospitalEnum hospitalEnum=info(bplist.get(0).getDeptid());
				String comcode=hospitalEnum.getComcode();
				String name=hospitalEnum.getName();
				boolean result = requestBP(bplist,comcode,name);
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
	public boolean requestSG(PatientBmiView patientBmiView,String comcode,String name) throws Exception {
		boolean requestXT = false;
		String url="http://173.18.1.104:9071/measure/api/patSignSubmit";
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
		printwrites("C:/Hesicare/java接口/logs/sg/"+patientBmiView.getDeptid()+"/"+new SimpleDateFormat("yyyy-MM-dd").format(new Date()) +".txt",name+"-请求数据：" + json.toString());
	//	System.out.println("请求数据：" + json.toString());
		String header = InterfaceEnCode.getInterfaceKey();
		map.put("param", InterfaceEnCode.encrypt(json.toString()));
		HttpClientUtil util = new HttpClientUtil();
		String result = util.doPost(header, url, map);
		JSONObject resultJson = JSONObject.fromObject(result);
		//System.out.println(resultJson);
		String code = resultJson.getString("code");
		if (code.equals("1")) {
			requestXT = true;
		}
		requestXT=true;
		printwrites("C:/Hesicare/java接口/logs/sg/"+patientBmiView.getDeptid()+"/"+new SimpleDateFormat("yyyy-MM-dd").format(new Date()) +".txt",name+"-"+result);
		//	System.out.println("返回结果：" + result);
		return requestXT;
	}
	public boolean requestXT(BloodGlucose bloodGlucose,String comcode,String name) throws Exception {
		boolean requestXT = false;
        String url="http://173.18.1.104:9071/measure/api/patSignSubmit";
		Patdata patdata = new Patdata();
		IdcardInfoExtractor idcardInfo = new IdcardInfoExtractor(String.valueOf(bloodGlucose.getIdCard()));
		patdata.setPersoncard(bloodGlucose.getIdCard());
		patdata.setMeasureTime(Constants.convert(Constants.convert(bloodGlucose.getMeasureTime(), Constants.format2), Constants.format2));
		patdata.setMeasureSourceId(String.valueOf("0002"));
		patdata.setMeasureLocation(String.valueOf(3));
		patdata.setMeasureOrgId(comcode);
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
		printwrites("C:/Hesicare/java接口/logs/xt/"+bloodGlucose.getDeptid()+"/"+new SimpleDateFormat("yyyy-MM-dd").format(new Date()) +".txt",name+"-请求数据：" + json.toString());
		//System.out.println("请求数据：" + json.toString());
		String header = InterfaceEnCode.getInterfaceKey();
		map.put("param", InterfaceEnCode.encrypt(json.toString()));
		HttpClientUtil util = new HttpClientUtil();
		String result = util.doPost(header, url, map);
		//String result = "{\"code\":\"1\",\"msg\":\"数据传输成功\"}";
		JSONObject resultJson = JSONObject.fromObject(result);
		String code = resultJson.getString("code");
		if (code.equals("1")) {
			requestXT = true;
		}
		requestXT=true;
		printwrites("C:/Hesicare/java接口/logs/xt/"+bloodGlucose.getDeptid()+"/"+new SimpleDateFormat("yyyy-MM-dd").format(new Date()) +".txt",name+"-"+"返回结果：" + result);

		//System.out.println("返回结果：" + result);
		return requestXT;
	}
	public boolean requestBP(List<BloodPressure> bplist,String comcode,String name) throws Exception {
		boolean requestBP = false;
		String url="http://173.18.1.104:9071/measure/api/chronic/submit";
		Pwdbpdata bpdata = new Pwdbpdata();
		BloodPressure bp = bplist.get(0);
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
		bpdata.setSourceId(String.valueOf("0002"));

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
			bpVo.setFinishTime1(
					Constants.convert(Constants.convert(bp.getCheckTime(), Constants.format2), Constants.format2));

			bpVo.setBgzmbjcTimes2(Integer.valueOf(0));
			bpVo.setDbp2(Integer.valueOf(bp.getDiastolicPressure()));
			bpVo.setSbp2(Integer.valueOf(bp.getSystolicPressure()));
			bpVo.setMb2(Integer.valueOf(bp.getPluse()));
			bpVo.setStydjcTimes2(Integer.valueOf(0));
			bpVo.setFinishTime2(
					Constants.convert(Constants.convert(bp.getCheckTime(), Constants.format2), Constants.format2));

			BloodPressure bp2 = bplist.get(bplist.size()-1);
			bpVo.setSbpAve(bp2.getSystolicPressure());
			bpVo.setDbpAve(bp2.getDiastolicPressure());
			bpVo.setMbAve(bp2.getPluse());

		} else if (bplist.size() == 3) {

			BloodPressure bp1 = bplist.get(0);

			bpVo.setBgzmbjcTimes1(Integer.valueOf(0));
			bpVo.setDbp1(Integer.valueOf(bp1.getDiastolicPressure()));
			bpVo.setSbp1(Integer.valueOf(bp1.getSystolicPressure()));
			bpVo.setMb1(Integer.valueOf(bp1.getPluse()));
			bpVo.setStydjcTimes1(Integer.valueOf(0));
			bpVo.setFinishTime1(
					Constants.convert(Constants.convert(bp1.getCheckTime(), Constants.format2), Constants.format2));

			BloodPressure bp2 = bplist.get(1);
			bpVo.setBgzmbjcTimes2(Integer.valueOf(0));
			bpVo.setDbp2(Integer.valueOf(bp2.getDiastolicPressure()));
			bpVo.setSbp2(Integer.valueOf(bp2.getSystolicPressure()));
			bpVo.setMb2(Integer.valueOf(bp2.getPluse()));
			bpVo.setStydjcTimes2(Integer.valueOf(0));
			bpVo.setFinishTime2(
					Constants.convert(Constants.convert(bp2.getCheckTime(), Constants.format2), Constants.format2));
             
			BloodPressure bp3 = bplist.get(2);
			bpVo.setSbpAve(bp3.getSystolicPressure());
			bpVo.setDbpAve(bp3.getDiastolicPressure());
			bpVo.setMbAve(bp3.getPluse());

		} else if (bplist.size() == 4) {

			BloodPressure bp1 = bplist.get(0);

			bpVo.setBgzmbjcTimes1(Integer.valueOf(0));
			bpVo.setDbp1(Integer.valueOf(bp1.getDiastolicPressure()));
			bpVo.setSbp1(Integer.valueOf(bp1.getSystolicPressure()));
			bpVo.setMb1(Integer.valueOf(bp1.getPluse()));
			bpVo.setStydjcTimes1(Integer.valueOf(0));
			bpVo.setFinishTime1(
					Constants.convert(Constants.convert(bp1.getCheckTime(), Constants.format2), Constants.format2));

			BloodPressure bp2 = bplist.get(1);
			bpVo.setBgzmbjcTimes2(Integer.valueOf(0));
			bpVo.setDbp2(Integer.valueOf(bp2.getDiastolicPressure()));
			bpVo.setSbp2(Integer.valueOf(bp2.getSystolicPressure()));
			bpVo.setMb2(Integer.valueOf(bp2.getPluse()));
			bpVo.setStydjcTimes2(Integer.valueOf(0));
			bpVo.setFinishTime2(
					Constants.convert(Constants.convert(bp2.getCheckTime(), Constants.format2), Constants.format2));

			BloodPressure bp3 = bplist.get(2);
			bpVo.setBgzmbjcTimes3(Integer.valueOf(0));
			bpVo.setDbp3(Integer.valueOf(bp3.getDiastolicPressure()));
			bpVo.setSbp3(Integer.valueOf(bp3.getSystolicPressure()));
			bpVo.setMb3(Integer.valueOf(bp3.getPluse()));
			bpVo.setStydjcTimes3(Integer.valueOf(0));
			bpVo.setFinishTime3(
					Constants.convert(Constants.convert(bp3.getCheckTime(), Constants.format2), Constants.format2));
            
			BloodPressure bp4 = bplist.get(3);
			bpVo.setSbpAve(bp4.getSystolicPressure());
			bpVo.setDbpAve(bp4.getDiastolicPressure());
			bpVo.setMbAve(bp4.getPluse());
		}else if (bplist.size() > 4) {

			BloodPressure bp1 = bplist.get(0);

			bpVo.setBgzmbjcTimes1(Integer.valueOf(0));
			bpVo.setDbp1(Integer.valueOf(bp1.getDiastolicPressure()));
			bpVo.setSbp1(Integer.valueOf(bp1.getSystolicPressure()));
			bpVo.setMb1(Integer.valueOf(bp1.getPluse()));
			bpVo.setStydjcTimes1(Integer.valueOf(0));
			bpVo.setFinishTime1(
					Constants.convert(Constants.convert(bp1.getCheckTime(), Constants.format2), Constants.format2));

			BloodPressure bp2 = bplist.get(1);
			bpVo.setBgzmbjcTimes2(Integer.valueOf(0));
			bpVo.setDbp2(Integer.valueOf(bp2.getDiastolicPressure()));
			bpVo.setSbp2(Integer.valueOf(bp2.getSystolicPressure()));
			bpVo.setMb2(Integer.valueOf(bp2.getPluse()));
			bpVo.setStydjcTimes2(Integer.valueOf(0));
			bpVo.setFinishTime2(
					Constants.convert(Constants.convert(bp2.getCheckTime(), Constants.format2), Constants.format2));

			BloodPressure bp3 = bplist.get(2);
			bpVo.setBgzmbjcTimes3(Integer.valueOf(0));
			bpVo.setDbp3(Integer.valueOf(bp3.getDiastolicPressure()));
			bpVo.setSbp3(Integer.valueOf(bp3.getSystolicPressure()));
			bpVo.setMb3(Integer.valueOf(bp3.getPluse()));
			bpVo.setStydjcTimes3(Integer.valueOf(0));
			bpVo.setFinishTime3(
					Constants.convert(Constants.convert(bp3.getCheckTime(), Constants.format2), Constants.format2));
            
			BloodPressure bp4 = bplist.get(bplist.size()-1);
			bpVo.setSbpAve(bp4.getSystolicPressure());
			bpVo.setDbpAve(bp4.getDiastolicPressure());
			bpVo.setMbAve(bp4.getPluse());
		}

		List<BloodPressureVo> datalist = new ArrayList<BloodPressureVo>();
		datalist.add(bpVo);

		bpdata.setCljgList(datalist);

		// Map<String, String> map = new HashMap<String, String>();

		JsonConfig jsonConfig = new JsonConfig();
		PropertyFilter filter = new PropertyFilter() {
			public boolean apply(Object object, String fieldName, Object fieldValue) {
				return null == fieldValue;
			}
		};
		jsonConfig.setJsonPropertyFilter(filter);
		JSONObject json = JSONObject.fromObject(bpdata, jsonConfig);
		printwrites("C:/Hesicare/java接口/logs/xy/"+bplist.get(0).getDeptid()+"/"+new SimpleDateFormat("yyyy-MM-dd").format(new Date()) +".txt",name+"-请求数据：" + json.toString());

		//System.out.println("请求数据：" + json.toString());

		String result = this.sendHttpPost(url, json.toString());

		JSONObject resultJson = JSONObject.fromObject(result);
		String code = resultJson.getString("errno");
		if (code.equals("0")) {
			requestBP = true;
		}
		printwrites("C:/Hesicare/java接口/logs/xy/"+bplist.get(0).getDeptid()+"/"+new SimpleDateFormat("yyyy-MM-dd").format(new Date()) +".txt",name+"-"+"返回结果：" + result);

		//System.out.println("返回结果：" + result);

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
		if(comcode.equals("346")){hospitalEnum=HospitalEnum.hp_yy;}
		if (comcode.equals("350")){hospitalEnum=HospitalEnum.hp_wt;}
		if (comcode.equals("354")){hospitalEnum=HospitalEnum.hp_wl;}
		return  hospitalEnum;
	}
}