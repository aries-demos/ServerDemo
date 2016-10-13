package com.damonzh.demo.handler;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

/**
 * @Description 
 * 请求处理
 * @author ZQQ
 * @date 2016-10-13下午5:58:23
 */
public class HandlerTest implements HttpHandler{

	public void handle(HttpExchange httpExchange) throws IOException {
		//针对请求的处理部分   
		//返回请求响应时，遵循HTTP协议
		String responseString = "你好，这是一个服务器!";
		//设置响应头
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		httpExchange.sendResponseHeaders(200, responseString.length());   
		OutputStream os = httpExchange.getResponseBody();   
		os.write(responseString.getBytes());   
		os.close(); 
	}
	
}