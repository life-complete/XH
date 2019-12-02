package com.wonders.measure.common.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Security;

public class AesUtils {
    // 编码
    private static final String ENCODING = "UTF-8";
    //算法
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
        byte[] d = new byte[length];  	for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] =(byte) 	(charToByte(hexChars[pos]) 	<< 	4 	| charToByte(hexChars[pos + 1]));
        }
	 	return d;
}  private static byte charToByte(char c) {  	return (byte) "0123456789ABCDEF".indexOf(c);
}

    /*
     * 加密
     */
    public static String encode(String secret, String iv, String content) throws Exception {
        byte[] secretBytes = secret.getBytes();
        SecretKey secretKey = new SecretKeySpec(secretBytes, ALGORITHM);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
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
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);  	cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);  	//byte[] contentBytes = new BASE64Decoder().decodeBuffer(content);
        byte[] contentBytes = hexStringToBytes(content);
        byte[] decodeBytes = cipher.doFinal(contentBytes);
        String decode = new String(decodeBytes, ENCODING);
        return decode;
    }
}
