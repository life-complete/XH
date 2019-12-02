package com.hesicare.hospital.common.jobs;

import java.security.MessageDigest;
import java.util.Date;

public class Md5Util {
    public String AngelinaMD5(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            md.update(str.getBytes());

            byte b[] = md.digest();

            int i=0;

            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            str = buf.toString();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return str;
    }

    //MD5算法生成32位大写
    public String CapitalMD5(String str)
    {
        String result=null;

        result=AngelinaMD5(str).toUpperCase();

        return result;
    }

    public String sign(String str){
            //加密的字符串
            String smallResult = null;
            String bigResult = null;
            Md5Util md5 = new Md5Util();
            bigResult = md5.CapitalMD5(str);
        return bigResult;
    }

    public static void main(String[] args) {
        Md5Util md5Util=new Md5Util();
        System.out.println(md5Util.sign("|310226196002173728|0002|1426817510111|"));
        //1426817510111
    }
    }