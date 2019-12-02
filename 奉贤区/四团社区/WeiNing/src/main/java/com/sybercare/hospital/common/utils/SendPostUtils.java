package com.sybercare.hospital.common.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class SendPostUtils {
	//参数jsonStr是内容，path接口url地址  
    public static String sendPost(String jsonStr, String path) throws IOException { 
        byte[] data = jsonStr.getBytes("UTF-8");  
        java.net.URL url = new java.net.URL(path);  
        java.net.HttpURLConnection conn = (java.net.HttpURLConnection) url.openConnection();  
        conn.setRequestMethod("POST");  
        conn.setConnectTimeout(5 * 1000);// 设置连接超时时间为5秒  
        conn.setReadTimeout(20 * 1000);// 设置读取超时时间为20秒  
        // 使用 URL 连接进行输出，则将 DoOutput标志设置为 true  
        conn.setDoOutput(true);  
  
        conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");  
        // conn.setRequestProperty("Content-Encoding","gzip");  
        conn.setRequestProperty("Content-Length", String.valueOf(data.length));  
//        conn.setRequestProperty("jsonBody", data.length);  
//        conn.setRequestProperty("syb_appId", "");
//        conn.setRequestProperty("syb_appKey", "");
//        conn.setRequestProperty("syb_sessionToken", "");
//        conn.setRequestProperty("syb_consumerSeqNo", "");
//        conn.setRequestProperty("syb_operatorCode", "");
        OutputStream outStream = conn.getOutputStream();// 返回写入到此连接的输出流  
        outStream.write(data);  
        outStream.close();// 关闭流  
        String msg = "";// 保存调用http服务后的响应信息  
        // 如果请求响应码是200，则表示成功  
        if (conn.getResponseCode() == 200) {  
            // HTTP服务端返回的编码是UTF-8,故必须设置为UTF-8,保持编码统一,否则会出现中文乱码  
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));  
            msg = in.readLine();  
            in.close();  
        }
        conn.disconnect();// 断开连接  
        return msg;  
    }  

}
