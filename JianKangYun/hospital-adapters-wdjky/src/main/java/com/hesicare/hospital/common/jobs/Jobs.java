package com.hesicare.hospital.common.jobs;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.*;
import java.util.stream.Collectors;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

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
import okio.ByteString;
import sun.misc.BASE64Encoder;

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

	@SuppressWarnings("unchecked")
	@Scheduled(cron = "0 0/3 * * * ?")
	public void doBmiIt() {
		try {
			System.out.println("job 身高定时器：" + Constants.convert(new Date(), Constants.format2));
			List<PatientBmiView> bmiview = patientBmiViewDao.getBmiByState("0");
			for (PatientBmiView patientBmiView : bmiview) {
				boolean result = requestSG(patientBmiView);
				if (result) {
					// bloodGlucoseDAO.updateBloodGlucoseOperateState(patientBmiView.getId(),
					// (short) 1);
					patientBmiViewDao.updateBmiState(patientBmiView.getId(), (short) 1);
				}
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Scheduled(cron = "0 0/1 * * * ?")
	// @Scheduled(cron = "0/10 * * * * ?")
	public void doXueTangIt() {
		try {
			System.out.println("job 血糖定时器：" + Constants.convert(new Date(), Constants.format2));
			// List<BloodPressure> bloodGlucoses1 =
			// bloodPressureDAO.getBloodPressureByOperateState();
			List<BloodGlucose> bloodGlucoses1 = bloodGlucoseDAO.getBloodGlucoseByOperateState("0");
			for (BloodGlucose bloodGlucose : bloodGlucoses1) {
				boolean result = requestXT(bloodGlucose);
				if (result) {
					// bloodPressureDAO.updateBloodGlucoseOperateState(bloodPressure.getId(),
					// (short) 3);
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

				if (String.valueOf(bplist.get(0).getIdCard()).length() < 15) {
					continue;
				}
				if (StringUtils.isBlank(bplist.get(0).getCheckTime())) {
					continue;
				}

				if (StringUtils.isBlank(bplist.get(0).getSystolicPressure())) {
					continue;
				}

				if (StringUtils.isBlank(bplist.get(0).getDiastolicPressure())) {
					continue;
				}

				if (bplist.size() <= 2) {
					continue;
				}

				if (String.valueOf(bplist.get(0).getIsAverage()).equals("0")) {
					continue;
				}

				if (String.valueOf(bplist.get(bplist.size() - 1).getData_status()).equals("1")) {
					continue;
				}

				boolean result = requestBP(bplist);

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

	public boolean requestSG(PatientBmiView patientBmiView) throws Exception {
		boolean requestXT = false;
		String url = "http://192.168.9.114:9071/measure/api/patSignSubmit";
		Patdata patdata = new Patdata();
		IdcardInfoExtractor idcardInfo = new IdcardInfoExtractor(String.valueOf(patientBmiView.getIdcard()));
		patdata.setPersoncard(patientBmiView.getIdcard());
		patdata.setMeasureTime(Constants.convert(Constants.convert(patientBmiView.getMearsuretime(), Constants.format2),
				Constants.format2));
		patdata.setMeasureSourceId(String.valueOf("0005"));
		patdata.setMeasureLocation(String.valueOf(3));
		patdata.setMeasureOrgId("42508125600");
		patdata.setMeasureMode(String.valueOf(1));
		patdata.setDeviceId("2019082419072633005003");
		patdata.setDeviceType(String.valueOf("HS-3001"));
		BloodGlucoseVo bloodGlucoseVo = new BloodGlucoseVo();
		BloodGlucoseVo bloodGlucoseVo2 = new BloodGlucoseVo();
		String resultBg = "";
		bloodGlucoseVo.setMeasureType("1003");
		bloodGlucoseVo.setMeasureData(patientBmiView.getHeight());
		bloodGlucoseVo2.setMeasureType("1004");
		bloodGlucoseVo2.setMeasureData(patientBmiView.getWeight());
		List<BloodGlucoseVo> datalist = new ArrayList<BloodGlucoseVo>();
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
		String header = InterfaceEnCode.getInterfaceKey();
		map.put("param", InterfaceEnCode.encrypt(json.toString()));
		HttpClientUtil util = new HttpClientUtil();
		String result = util.doPost(header, url, map);
		JSONObject resultJson = JSONObject.fromObject(result);
		System.out.println(resultJson);
		String code = resultJson.getString("code");
		if (code.equals("1")) {
			requestXT = true;
		}
		requestXT = true;
		System.out.println("返回结果：" + result);
		return requestXT;
	}

	public boolean requestXT(BloodGlucose bloodGlucose) throws Exception {
		boolean requestXT = false;
		String url = "http://192.168.9.114:9071/measure/api/patSignSubmit";
		Patdata patdata = new Patdata();
		IdcardInfoExtractor idcardInfo = new IdcardInfoExtractor(String.valueOf(bloodGlucose.getIdCard()));
		patdata.setPersoncard(bloodGlucose.getIdCard());
		patdata.setMeasureTime(Constants.convert(Constants.convert(bloodGlucose.getMeasureTime(), Constants.format2),
				Constants.format2));
		patdata.setMeasureSourceId(String.valueOf("0005"));
		patdata.setMeasureLocation(String.valueOf(3));
		patdata.setMeasureOrgId("42508125600");
		patdata.setMeasureMode(String.valueOf(1));
		patdata.setDeviceId(bloodGlucose.getDeviceSn());
		patdata.setDeviceType(String.valueOf("Accu-Chek"));

		BloodGlucoseVo bloodGlucoseVo = new BloodGlucoseVo();

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
			resultBg = "4";
		} else if (!value.equals(991) && !value.equals(990) && value > 11.0) {
			resultBg = "3";
		} else if (value.equals(991) || value.equals(990)) {
			resultBg = "2";
		} else
			resultBg = "1";
		bloodGlucoseVo.setMeasureType("2001");
		bloodGlucoseVo.setMeasureData(bloodGlucose.getValue() + "|" + "mmol/L" + "|" + "0.6-33.3" + "|" + resultBg + "|"
				+ status + "|" + "1");
		List<BloodGlucoseVo> datalist = new ArrayList<BloodGlucoseVo>();
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
		String header = InterfaceEnCode.getInterfaceKey();
		map.put("param", InterfaceEnCode.encrypt(json.toString()));
		HttpClientUtil util = new HttpClientUtil();
		String result = util.doPost(header, url, map);
		JSONObject resultJson = JSONObject.fromObject(result);
		String code = resultJson.getString("code");
		if (code.equals("1")) {
			requestXT = true;
		}
		requestXT = true;
		System.out.println("返回结果：" + result);
		return requestXT;
	}

	public boolean requestBP(List<BloodPressure> bloodPressure) throws Exception {
		boolean requestBP = false;
		String url = "http://192.168.9.114:9071/measure/api/patSignSubmit";
		Patdata patdata = new Patdata();
		patdata.setPersoncard(bloodPressure.get(0).getIdCard());
		patdata.setMeasureTime(Constants
				.convert(Constants.convert(bloodPressure.get(0).getCheckTime(), Constants.format2), Constants.format2));
		patdata.setMeasureSourceId("0005");
		patdata.setMeasureLocation(String.valueOf(1));
		patdata.setMeasureOrgId("42508125600");
		patdata.setMeasureMode(String.valueOf(2));
		patdata.setDeviceId(bloodPressure.get(0).getDeviceId());
		patdata.setDeviceType(String.valueOf("AND:TM-2656VP"));
		BloodGlucoseVo bpVo1 = new BloodGlucoseVo();
		String clsb = null;
		if (bloodPressure.get(bloodPressure.size() - 1).getHand().equals("left")) {
			clsb = String.valueOf(1);
		} else if (bloodPressure.get(bloodPressure.size() - 1).getHand().equals("right")) {
			clsb = String.valueOf(2);
		} else {
			clsb = String.valueOf(3);
		}
		StringBuffer buffer = new StringBuffer();
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(bloodPressure.get(0).getSystolicPressure() + "|"
				+ bloodPressure.get(0).getDiastolicPressure() + "|" + clsb);
		for (int i = 1; i < bloodPressure.size(); i++) {
			stringBuffer.append("|" + bloodPressure.get(i).getSystolicPressure() + "|"
					+ bloodPressure.get(i).getDiastolicPressure());

		}
		bpVo1.setMeasureType(String.valueOf(1001)); // 血压
		bpVo1.setMeasureData(String.valueOf(stringBuffer));
		BloodGlucoseVo bpVo2 = new BloodGlucoseVo();
		bpVo2.setMeasureType(String.valueOf(1002)); // 脉搏
		bpVo2.setMeasureData(bloodPressure.get(0).getPluse());
		List<BloodGlucoseVo> datalist = new ArrayList<BloodGlucoseVo>();
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
		String header = InterfaceEnCode.getInterfaceKey();
		map.put("param", InterfaceEnCode.encrypt(json.toString()));
		HttpClientUtil util = new HttpClientUtil();
		String result = util.doPost(header, url, map);
		// String result = "{\"code\":\"1\",\"msg\":\"数据传输成功\"}";
		JSONObject resultJson = JSONObject.fromObject(result);
		String code = resultJson.getString("code");
		if (code.equals("1")) {
			requestBP = true;
		}
		System.out.println("返回结果：" + result);

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

	/****************** 签名示例代码 *************************************************/

	public static final String KEY_ALGORITHM = "RSA";
	public static final String SIGNATURE_ALGORITHM = "MD5withRSA";

	/**
	 * 用私钥对信息生成数字签名
	 * 
	 * @param data
	 *            加密数据
	 * @param privateKey
	 *            私钥
	 * @return
	 * 
	 * @throws Exception
	 */
	public static String sign(String content, String privateKey)
			throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException, Exception {
		byte[] bytes = content.getBytes("UTF-8"); // 解密由 base64 编码的私钥
		byte[] keyBytes = decryptBASE64(privateKey); // 构造 PKCS8EncodedKeySpec
														// 对象
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes); // KEY_ALGORITHM
																				// 指定的加密算法
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM); // 取私钥匙对象
		PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec); // 用私钥对信息生成数字签名
		Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
		signature.initSign(priKey);
		signature.update(bytes);
		return encryptBASE64(signature.sign());
	}

	/**
	 * BASE64 解密
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptBASE64(String key) {
		return ByteString.decodeBase64(key).toByteArray();
	}

	/**
	 * BASE64 加密
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */

	public static String encryptBASE64(byte[] key) {
		return ByteString.of(key).base64();

	}

	/***************** 加密（AES）示例代码 ***********************/

	// 编码
	private static final String ENCODING = "UTF-8";
	// 算法
	private static final String ALGORITHM = "AES";
	// 默认的加密算法
	private static final String CIPHER_ALGORITHM = "AES/CBC/PKCS7Padding";

	public static String bytesToHexString(byte[] src) {
		StringBuilder stringBuilder = new StringBuilder("");
		if (src == null || src.length <= 0) {
			return null;
		}
		for (int i = 0; i < src.length; i++) {
			int v = src[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}

	public static byte[] hexStringToBytes(String hexString) {
		if (hexString == null || hexString.equals("")) {
			return null;
		}
		hexString = hexString.toUpperCase();
		int length = hexString.length() / 2;
		char[] hexChars = hexString.toCharArray();
		byte[] d = new byte[length];
		for (int i = 0; i < length; i++) {
			int pos = i * 2;
			d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
		}
		return d;
	}

	private static byte charToByte(char c) {
		return (byte) "0123456789ABCDEF".indexOf(c);
	}

	/*
	 * 加密
	 */
	public static String encode(String secret, String iv, String content) throws Exception {
		byte[] secretBytes = secret.getBytes();
		SecretKey secretKey = new SecretKeySpec(secretBytes, ALGORITHM);
		IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
		Security.addProvider(new 
				org.bouncycastle.jce.provider.BouncyCastleProvider());
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
		byte[] contentBytes = content.getBytes(ENCODING);
		byte[] bytes = cipher.doFinal(contentBytes); 
		//String encode = new String(new BASE64Encoder().encode(bytes));
		String encode = bytesToHexString(bytes);
		return encode; 
		}

	/*
	 * 解密
	 */
	public static String decode(String secret, String iv, String content) throws Exception {
		byte[] secretKeyBytes = secret.getBytes();
		SecretKey secretKey = new SecretKeySpec(secretKeyBytes, ALGORITHM);
		IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
		Security.addProvider(new 
				org.bouncycastle.jce.provider.BouncyCastleProvider());
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec); 
		// byte[] contentBytes = new BASE64Decoder().decodeBuffer(content);
		byte[] contentBytes = hexStringToBytes(content);
		byte[] decodeBytes = cipher.doFinal(contentBytes);
		String decode = new String(decodeBytes, ENCODING);
		return decode;
	}

}