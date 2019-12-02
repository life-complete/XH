package com.wonders.measure.common.utils;

import okio.ByteString;

import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

import static com.hesicare.hospital.common.jobs.Jobs.decryptBASE64;

public class OkioUtils {
    public static final String KEY_ALGORITHM = "RSA";
    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";

    /**
     *	用私钥对信息生成数字签名
     *
     *	@param data       加密数据
     *	@param privateKey 私钥
     *	@return
     *	@throws Exception
     */
    public static String sign(String content, String privateKey) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException,
            SignatureException, UnsupportedEncodingException {
        byte[] bytes = content.getBytes("UTF-8");
        // 解密由base64编码的私钥
        byte[] keyBytes = decryptBASE64(privateKey);
        // 构造PKCS8EncodedKeySpec对象
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        // KEY_ALGORITHM 指定的加密算法
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        // 取私钥匙对象
        PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec);
        // 用私钥对信息生成数字签名
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initSign(priKey);
        signature.update(bytes);
        return encryptBASE64(signature.sign());
    }
    /**
     *	BASE64解密
     *
     *	@param key
     *	@return
     *	@throws Exception
     */     public static byte[] decryptBASE64(String key) {         return ByteString.decodeBase64(key).toByteArray();
    }
    /**
     *	BASE64加密
     *
     *	@param key
     *	@return
     *	@throws Exception
     */     public static String encryptBASE64(byte[] key) {
             return ByteString.of(key).base64();
    }

}
