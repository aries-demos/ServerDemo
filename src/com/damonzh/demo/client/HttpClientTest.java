package com.damonzh.demo.client;

import org.json.JSONStringer;


public class HttpClientTest {

	
	public static void main(String[] args) {
		testPostMethod();
	}
	
	public static void testPostMethod() {
//		String url = "http://localhost:8086/myrequest?a=1" ;
		String url = "http://localhost:8086/" ;
		
		JSONStringer stringer = new JSONStringer();
		stringer.object().key("name").value("xiazdong").key("age").value(20)
				.endObject();
		String jsonString = stringer.toString() ;
		
		
		String resp = HttpClient.postMethod(url, jsonString);
		System.out.println(resp);
		
	}

}
