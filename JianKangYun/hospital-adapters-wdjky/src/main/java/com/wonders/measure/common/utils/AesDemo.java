package com.wonders.measure.common.utils;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;

public class AesDemo {
    public static void main(String[] args) throws Exception {
        String appid="5e6a2581cded47ebb6b312abea2d5b38";
        String  iv="23827e0e23dc4da3";
        String aesKey="eb0ba8e2f968434d8a0ba85445fd8c88";
        String publicKey="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCBSGuUX3vuuo" +
                "zM+P5g+s9D+mh9qIC+2hyShgvcUACgodn6r+YZetk+9ox1uaUIBXN" +
                "RGXlJWODFz4TfGdUwaWkDjNrnJR3lzmQXw6GQ89bApu1Sm7MBKF"+
                "plZKP4Qus3K0LjTZD/wZVdrvuucbj0+MKRJZE8fgStxXE6KRY6ef4yEQI" +
                "DAQAB ";
        String privateKey="MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIFIa" +
                "5Rfe+66jMz4/mD6z0P6aH2ogL7aHJKGC9xQAKCh2fqv5hl62T72jHW5" +
                "pQgFc1EZeUlY4MXPhN8Z1TBpaQOM2uclHeXOZBfDoZDz1sCm7VKb" +
                "swEoWmVko/hC6zcrQuNNkP/BlV2u+65xuPT4wpElkTx+BK3FcTopFjp" +
                "5/jIRAgMBAAECgYAkFokhM74ul5hyJxcrDxgIS8AbQ4wculm7dPuelh5" +
                "2uHdWiP9cIXS/JKd0vUuZ/5t/CfNXTB4CWbknZdii2OndEvphy4IxHITE" +
                "ERngk6FEc+dkimy678iMuyn21tzW3hVa0eYdLscStfgq60286iRNlkVqgt" +
                "2E+M2MlfscP5TqoQJBANVfbDaqNYHDuJSpvTfwKcf/2VDSUfeA1NdI" +
                "CnwApRGJorECGeYuOTY4IEQjJ8VnAsi2uILT73XKffk8E+0hM80CQQCb" +
                "HF5Ud0MqtSFVVueOT8O31N3hp9KzFQClOPj9BTC/Z8vxX+uGp1o/r3" +
                "nd3jrM9oaS/rhemdaLLEyUf7E+5vtVAkEAui/o+o5t4EzMLRUsYrpziuyr" +
                "UcYk9ib6EtzvISNi5rnGOFUQCnY9QB2bsjlHBA8OM9yVhruu0Ycfg7Mz" +
                "5BC75QJADqSn9xtnOOHuqqrQo2u+U12CMOpyBrwF2pM9Vk2mI3u" +
                "+EiR3DLhB2d9MBvkS3gSsAbaQW0X0riDZfe9sIT8XHQJAdIGlgYEzuY+" +
                "g7OWafd1i5NKjM6lw0WOAjlo/dPRQX55JoD28t5BhHXf48fW3YX8Dt/" +
                "E6oi0ZcoR8UIHjkMxSIA== ";
        String context="{  \"hostDeviceCode\": \"SKT81****018\",\n" +
                "\"data\": {\n" +
                "\"deviceCode\":\"000001\",\n" +
                "\"recordNo\": \"2125555**********9543206\",\n" +
                "\"detectMode\": 2,\n" +
                "\"cardType\": 9,  \n" +
                "\"detectWay\": 2,   \n" +
                "\"cardNo\": \"130223********5516\", \n" +
                "\"hospitalName\": \"华山医院\",  \n" +
                "\"hospitalCode\": \"4450585525\",\n" +
                "\"doctorName\": \"张三\", \n" +
                "\"doctorId\": \"000001\", \n" +
                "\"detectTime\": \"2018-09-20 13:32:06\",\n" +
                "\"examResult\": \"血压偏高\", \n" +
                "\"examItem\": [{\n" +
                "\t\"name\": \"收缩压\",\n" +
                "\"eName\": \"sys\",\n" +
                "\"value\": \"140\", \n" +
                "\"min\": \"90\",   \n" +
                "\"max\": \"130\", \n" +
                "\"unit\": \"mmHg\",\n" +
                "\"res\": \"偏高\",   \n" +
                "\"resDesc\": \"收缩压偏高\"   }, \n" +
                "{  \"name\": \"舒张压\",   \n" +
                "\"eName\": \"dia\",    \n" +
                "\"value\": \"60\", \n" +
                "\"min\": \"60\",    \"max\": \"89\",    \"unit\": \"mmHg\",    \"res\": \"\",    \"resDesc\": \"\"   }, {    \"name\": \"脉率\",    \"eName\": \"pulse\",    \"value\": \"165\",    \"min\": \"\",    \"max\": \"\",    \"unit\": \"\",    \"res\": \"\",    \"resDesc\": \"\"   }]  } } ";
      String ase= AesUtils.encode(aesKey,iv,context);
      String ases=AesUtils.bytesToHexString(AesUtils.hexStringToBytes(ase));
        System.out.println(ases  );
        String timestamp= String.valueOf(new Date().getTime());
        System.out.println(timestamp);
        String sign=appid+"_"+timestamp+"_"+context;
    String s=OkioUtils.sign(sign,privateKey);
    System.out.println(s);
    }
}
