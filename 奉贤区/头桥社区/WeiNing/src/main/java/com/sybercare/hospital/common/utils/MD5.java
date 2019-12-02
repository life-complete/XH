package com.sybercare.hospital.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {

	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	private static String byteArrayToHexString(byte[] b) {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			buf.append(byteToHexString(b[i]));
		}
		return buf.toString();
	}

	private static String byteToHexString(byte b) {
		return hexDigits[(b & 0xf0) >> 4] + hexDigits[b & 0x0f];
	}

	public static String MD5Encode(String origin) {
		String resultString = null;
		resultString = new String(origin);
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return resultString == null ? null : resultString.toUpperCase();
	}
}
