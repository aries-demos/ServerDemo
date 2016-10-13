package com.damonzh.demo.client;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpClient {

	public static String postMethod(String url,String jsonString) {

		
		CloseableHttpClient client = HttpClients.createDefault();  
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(4000).setConnectTimeout(4000).build();//设置请求和传输超时时间
		HttpPost post = new HttpPost(url);
		post.setConfig(requestConfig);
		
		
		String resp = "";
		try {
			StringEntity s = new StringEntity(jsonString, "UTF-8");   // 中文乱码在此解决
			s.setContentType("application/json");
			post.setEntity(s);
			HttpResponse res = client.execute(post);
			System.out.println("requestStatus:\n" + res.toString());
			if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				HttpEntity entity = res.getEntity();
//				String charset = EntityUtils.getContentCharSet(entity);
//				charset = charset==null ? "UTF-8" : charset ; 
				
				return getMsg(entity.getContent());
//				byte[] bytes = getMsg(new BufferedInputStream(entity.getContent()));
//				resp = new String(bytes);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return resp;
	}
	
	public static String getMsg(InputStream in){
		StringBuffer bufferResp = new StringBuffer();
		BufferedReader read = null;
		read = new BufferedReader(new InputStreamReader(in));
		String info = null;
		try {
			while((info=read.readLine())!=null){
				bufferResp.append(info);
			}
		} catch (IOException e) {
			System.out.println("读取响应报文异常。。。");
			e.printStackTrace();
		}
		return bufferResp.toString();
	}
	
	
	public static byte[] getMsg(BufferedInputStream bis) throws IOException{
		byte[]	res	= new byte[8192];
		try {
			int i	= bis.read(res);
			if(i>0){
				byte[]	temp	= new byte[i];
				System.arraycopy(res, 0, temp, 0, i);
				return temp;
			}else {
				return res;
			}
		} catch (IOException e) {
			System.out.println("读取响应报文异常");
			throw e;
		}
	}

}