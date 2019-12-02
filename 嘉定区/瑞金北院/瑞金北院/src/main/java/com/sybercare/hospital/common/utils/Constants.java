package com.sybercare.hospital.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.alibaba.fastjson.JSONObject;
import com.sybercare.hospital.health.worker.SybWorkEvents;

public class Constants {

	public static String DEFAULT_REDISHEAD;
	public static String DEFAULT_REDISQUEUE = "release:hospital:monitor";
	public static String DEFAULT_WEBSOCKETTOPIC = "/topic/msg";

	public static final String format1 = "yyyy-MM-dd";
	public static final String format2 = "yyyy-MM-dd HH:mm:ss";
	public static final String format3 = "yyyy/MM/dd HH:mm:ss";
	public static final String format4 = "yyyy-MM-dd HH:mm";
	
	/** 推送结果 */
	public static ConcurrentHashMap<String, List<JSONObject>> pushQueue = new ConcurrentHashMap<String, List<JSONObject>>();
	/** 缓存参数 */
	public static ConcurrentHashMap<SybWorkEvents, List<String>> params = new ConcurrentHashMap<SybWorkEvents, List<String>>();

	/**
	 * 功能：日期转字符
	 * */
	public static String convert(Date date, String format) {
		String retValue = null;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		retValue = sdf.format(date);
		return retValue;
	}

	/**
	 * 功能：日期转字符
	 * */
	public static Date convert(String date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date $date = null;
		try {
			$date = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return $date;
	}

}
