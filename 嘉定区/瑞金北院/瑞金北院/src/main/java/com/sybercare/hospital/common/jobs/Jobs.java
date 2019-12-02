package com.sybercare.hospital.common.jobs;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;
import com.sybercare.hospital.common.WebServiceClient.Service;
import com.sybercare.hospital.health.entity.*;
import com.thoughtworks.xstream.XStream;
import net.sf.json.JSONArray;
import org.apache.axis.utils.XMLUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sybercare.hospital.common.utils.Constants;
import com.sybercare.hospital.health.dao.BloodGlucoseDAO;
import com.sybercare.hospital.health.dao.BloodPressureDAO;
import com.sybercare.hospital.health.dao.PatientDAO;
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
	private PatientDAO patientDAO;

	@Autowired
	private BloodGlucoseDAO bloodGlucoseDAO;
	@Autowired
	private BloodPressureDAO pressureDAO;

	@SuppressWarnings("unchecked")
	@Scheduled(cron = "0 0/1 * * * ?")
	//@Scheduled(cron = "0/10 * * * * ?")
	public  void doUser(){
		System.out.println("患者定时器"+ Constants.convert(new Date(), Constants.format2));
		List<User> list=patientDAO.readUserByCardNumber();
		for (User user : list) {
			String card_number=user.getCardNumber();
			int type=0;
			if(user.getEmployee_card()==null||user.getEmployee_card().equals("")){
				card_number=user.getEmployee_card();
				type=1;
			}
			String url = "http://172.21.11.59/ESBService/ESBService.asmx/CallESB";
			String str="<ESBEnvelope xmlns=\"http://ESB.TopSchemaV2\">" +
					"<ESBHeader><HeaderControl AppCode=\"APP907\" Password=\"0OuN2Tup\" MessageCategory=\"RJHN903010008\" Version=\"\"" +
					" CreateTime=\""+user.getStampTime()+"\">" +
					"</HeaderControl></ESBHeader><ESBBody><BusinessRequest>" +
					"<![CDATA[<datatable><datarow><p1>"+card_number+"</p1><p2>"+type+"</p2></datarow></datatable>]]></BusinessRequest></ESBBody></ESBEnvelope>";
			try {
				String result=this.sendHttpPostUser(url, String.valueOf(str));
				if(result.contains("<Table>")&&result.contains("</NewDataSet>")){
				Map map=ResultJX(result);
				if(map.values()!=null){
					String dat= String.valueOf(map.get("rysj"));
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
					Date date = df.parse(dat);
					SimpleDateFormat df1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
					Date date1 = df1.parse(date.toString());
					DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date rysj= (Constants.convert((df2.format(date1)), Constants.format2));
					user.setEmployee_card(String.valueOf(map.get("zyh")));
					user.setUser_id_in(String.valueOf(map.get("zylsh")));
					user.setName(String.valueOf(map.get("xm")));
					user.setCard_time(rysj);
					patientDAO.updateUserByUserId(user);
				}}
				else{
					System.out.println("无该病人住院信息："+user.getIdentifyCard());
				}


			} catch (Exception e) {
				e.printStackTrace();
			}

		}


	}
	@Scheduled(cron = "0 0/2 * * * ?")
	public void doXueYaIt() {
		try {
			System.out.println("job 血压定时器：" + Constants.convert(new Date(), Constants.format2));
			List<BloodPressure>  bplist=bloodPressureDAO.pushBloodPressure();
			Map<String, List<BloodPressure>> groupBy = bplist.stream().collect(Collectors.groupingBy(BloodPressure::getIdentifierCode));
			JSONObject jsonObject = JSONObject.fromObject(groupBy);
			Iterator<Map.Entry<String, List<BloodPressure>>> it = jsonObject.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<String, List<BloodPressure>> entry = it.next();
				JSONArray list = (JSONArray) entry.getValue();
				List<BloodPressure> bp= (List<BloodPressure>) JSONArray.toCollection(list, BloodPressure.class);
				sortClass sort = new sortClass();
				Collections.sort(bplist, sort);
				if (String.valueOf(bplist.get(0).getIdCard()).length()<15){
					continue;
				}

				if (StringUtils.isBlank(bplist.get(0).getHand())){
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

				if (String.valueOf(bplist.get(bplist.size()-1).getIsAverage()).equals("0")) {
					continue;
				}
				boolean result = requestBP(bp);
				if (result) {
					for (BloodPressure bloodPressure : bp)
						pressureDAO.updateBloodGlucoseOperateState(bloodPressure.getIdentifierCode(), (short) 1);
				}
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Map ResultJX(String str) throws DocumentException {
		str=str.substring(str.indexOf("<Table>"),str.indexOf("</NewDataSet>"));
		Map<String, String> respMap = new HashMap<String, String>();
		Document doc = DocumentHelper.parseText(str);
		Element root = doc.getRootElement();
		Iterator<Element> eItor =root.elementIterator();
		while (eItor.hasNext()) {
			Element element = eItor.next();
			respMap.put(element.getName(),element.getText());
		}
	 	return respMap;
	}
	public class sortClass implements Comparator {
		public int compare(Object arg0, Object arg1) {
			BloodPressure bp0 = (BloodPressure) arg0;
			BloodPressure bp1 = (BloodPressure) arg1;
			int flag = Integer.valueOf(String.valueOf(bp0.getId())).compareTo(Integer.valueOf(String.valueOf(bp0.getId())));
			return flag;
		}
	}
	private boolean isBG = true;

	public boolean requestBP(List<BloodPressure> bplist) throws Exception {
		boolean requestBP = false;
		StringBuffer stringBuffer=new StringBuffer().append("<?xml version='1.0' encoding='utf-8'?><body>");
			stringBuffer.append("<row>")
					.append("<id>"+bplist.get(bplist.size()-1).getId()+"</id>")
					.append("<pid>"+bplist.get(bplist.size()-1).getUser_id_in()+"</pid>")
					.append("<measure_time>"+ Constants.convert(Constants.convert( bplist.get(bplist.size()-1).getCheckTime(), Constants.format4), Constants.format4)+"</measure_time>")
					.append("<systolic>"+bplist.get(bplist.size()-1).getSystolicPressure()+"</systolic>")
					.append("<diastolic>"+bplist.get(bplist.size()-1).getDiastolicPressure()+"</diastolic>")
					.append("<pluse>"+bplist.get(bplist.size()-1).getPluse()+"</pluse>")
					.append("<operate_type>1</operate_type>")
					.append("</row></body>");
		String RequestResult=  new Service().getServiceSoap().insertXY(String.valueOf(stringBuffer));
		String result=DocumentHelper.parseText(RequestResult).getRootElement().element("result").getText();
		System.out.println("血压请求数据"+stringBuffer);
		if(result.equals("Success")){
           requestBP=true;
		}
		return requestBP;
	}

	public String sendHttpPost(String url, String body) throws Exception {
		CloseableHttpClient httpClient= HttpClientBuilder.create().setRedirectStrategy(new LaxRedirectStrategy()).build();
		HttpPost httpPost = new HttpPost(url);
		httpPost.addHeader("Content-Type", "text/xml");
		//httpPost.setHeader("access-token", header);
		httpPost.setEntity(new StringEntity(body, "UTF-8"));
		CloseableHttpResponse response = httpClient.execute(httpPost);
		//System.out.println(response.getStatusLine().getStatusCode() + "\n");
		HttpEntity entity = response.getEntity();
		String responseContent = EntityUtils.toString(entity, "UTF-8");
		response.close();
		httpClient.close();
		return responseContent;
	}
	public String sendHttpPostUser(String url, String body) throws Exception {
		//CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpClient httpClient= HttpClientBuilder.create().setRedirectStrategy(new LaxRedirectStrategy()).build();
		//String header = InterfaceEnCode.getInterfaceKey();
		HttpPost httpPost = new HttpPost(url);
		httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
		List<BasicNameValuePair> values = new ArrayList();
		BasicNameValuePair base = new BasicNameValuePair("name","value");
		values.add(base);
		values.add(new BasicNameValuePair("xmlMessage",body));
		HttpEntity entity = new UrlEncodedFormEntity(values,"utf-8");
		httpPost.setEntity(entity);
		CloseableHttpResponse response = httpClient.execute(httpPost);
		System.out.println("患者请求数据"+body);
		//System.out.println("患者状态码"+response.getStatusLine().getStatusCode() + "\n");
		HttpEntity entitys = response.getEntity();
		String responseContent = EntityUtils.toString(entitys, "UTF-8");
		response.close();
		httpClient.close();
		responseContent=responseContent.replaceAll("&lt;","<");
		responseContent=responseContent.replaceAll("&gt;",">");
		responseContent=responseContent.replace("<?xml version=\"1.0\" encoding=\"utf-16\"?>"," ");
		return responseContent;
	}

}
