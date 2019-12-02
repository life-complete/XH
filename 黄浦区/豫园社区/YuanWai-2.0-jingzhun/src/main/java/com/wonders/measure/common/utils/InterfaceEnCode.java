package com.wonders.measure.common.utils;

import org.apache.commons.codec.binary.Base64;
import org.joda.time.DateTime;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Date;

public class InterfaceEnCode {
    private final static String DES = "DES";
    private final static String KEY = "healthjingan2016";
    private final static String CDC_KEY = "WONDERSGROUP2015";

    public static String getInterfaceKey() {
        String data = String.valueOf(new DateTime(new Date()).toString());
        try {
            return encrypt(data);
        } catch (Exception e) {
            return null;
        }
    }

    public static String getCdcInterfaceKey() {
        String data = String.valueOf(System.currentTimeMillis());
        try {
            byte[] bt = encrypt(data.getBytes("UTF-8"), CDC_KEY.getBytes());
            String strs = Base64.encodeBase64URLSafeString(bt);
            return strs;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Description 根据键值进行加密
     *
     * @param data 加密键byte数组
     * @return
     * @throws Exception
     */
    public static String encrypt(String data) throws Exception {
        byte[] bt = encrypt(data.getBytes("UTF-8"), KEY.getBytes());
        String strs = Base64.encodeBase64URLSafeString(bt);
        return strs;
    }

    /**
     * Description 根据键值进行加密
     *
     * @param data
     * @param key  加密键byte数组
     * @return
     * @throws Exception
     */
    private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");

        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);

        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey securekey = keyFactory.generateSecret(dks);

        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance(DES);

        // 用密钥初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);

        return cipher.doFinal(data);
    }

    /**
     * Description 根据键值进行解密
     *
     * @param data 加密键byte数组
     * @return
     * @throws IOException
     * @throws Exception
     */
    public static String decrypt(String data) throws Exception {
        if (data == null)
            return null;
        byte[] buf = Base64.decodeBase64(data);
        byte[] bt = decrypt(buf, KEY.getBytes());
        return new String(bt, "UTF-8");
    }

    /**
     * Description 根据键值进行解密
     *
     * @param data
     * @param key  加密键byte数组
     * @return
     * @throws Exception
     */
    private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");

        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);

        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey securekey = keyFactory.generateSecret(dks);

        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance(DES);

        // 用密钥初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);

        return cipher.doFinal(data);
    }

    /**
     * 认证
     *
     * @param ciphertext
     * @return
     */
    public static Boolean auth(String ciphertext) {
        String time = null;
        try {
            time = decrypt(ciphertext);
        } catch (Exception e) {
            return false;
        }
        DateTime d1 = new DateTime(new Date()).plusDays(-1);
        DateTime d2 = new DateTime(new Date()).plusDays(1);
        try {
            DateTime now = new DateTime(time.trim());
            return d1.isBefore(now) && d2.isAfter(now);
        } catch (IllegalArgumentException e) {
//            log.error("time format error:"+time);
        }
        return false;
    }

    public static void main(String[] args) throws Exception {

        System.out.println(getInterfaceKey());

        System.out.println(decrypt("AOeQOv5b6L6ghRJdmJ064VkdKYwoYgzOiSxPVYrD0L_0SCcDk_SpTV7L-i7NwAsB9M6TIjIEXF34ApE7zCkbDDkWfS3cT8iohf7u6MfJUHyqBcOB4nBIzi2VLWnob_tYvSJYMN3R6sjQ_u9wyqaHz3zDsBmp_bXi3dr0h9zlPUWrS-P7vfRywksyXh6831tYovR8TKXkdsp1LiIBBcxhh3NzcVg5CqtMNzJ6cXSHitR0nrsr0Evl5rfwmzq1TaE2_LSYBMsO1XLbKqtPPnGdVhJobQRChkeOka0AzkcfsbQ5Ax52zFW7JaE8MOpsELoF2vBEjYXhQ6urge_G-GZ6h_HMpQnv-11jkuz0fCGl3HCdl1uKu1JfgKLtJx4uJRji3ZG8j5QzJ-xNXYm88yjJ3hwhRW7zQsSv-fFV9nhpZNs"));

    }
}
