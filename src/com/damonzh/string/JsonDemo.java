package com.damonzh.string;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;


public class JsonDemo {
	public static void main(String[] args) {
		Student stu = new Student();
		stu.name = "zhang" ;
		
//		Map<String,Object> resMap = new HashMap<String,Object>();
		
		Object obj = null ;
//		String param = "{\"name\":\"zhangquanquan\"}" ;
		String param = "123" ;
		try {
			 obj = JSONObject.parse(param); 
			 Map<?, ?> map = (Map<?, ?>)obj;
			 System.out.println(map.get("name"));
		} catch (Exception e) {
			System.err.println("error");
		}
		
//		JSONArray array=jsonObj.getJSONArray("programmers"); 
//		System.out.println("array:"+array.get(0)); 
//		JSONObject obj=jsonObj.getJSONObject("singer"); 
//		System.out.println("obj:"+obj.get("firstName"));
//		String name = (String) jsonObj.get("name");
//		System.out.println(name);
		System.out.println(obj);
	}
	
	public Map<?, ?> parse(String param){
		return (Map<?, ?>)JSONObject.parse(param);
	}
//	public 
}

//类型转换时  注意错误处理
class Student{
	String name ;
	String age ;
}
