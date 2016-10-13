package com.damonzh.json.org;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;

public class JsonTest {

	public static void main(String[] args) throws Exception {
		jsonObjectTest();
		jsonArrayTest();
		jsonObjectAndArrayTest();
		jsonStringerTest();
		jsonStringerTest2();
		JSONTokenerTest();
	}

	public static void jsonObjectTest() {
		JSONObject jsonobj = new JSONObject("{'name':'xiazdong','age':20}");
		String name = jsonobj.getString("name");
		int age = jsonobj.getInt("age");
		System.out.println("name = " + name + ",age = " + age);
	}

	public static void jsonArrayTest() {
		JSONArray jsonarray = new JSONArray(
				"[{'name':'xiazdong','age':20},{'name':'xzdong','age':15}]");
		for (int i = 0; i < jsonarray.length(); i++) {
			JSONObject jsonobj = jsonarray.getJSONObject(i);
			String name = jsonobj.getString("name");
			int age = jsonobj.getInt("age");
			System.out.println("name = " + name + ",age = " + age);
		}
	}

	public static void jsonObjectAndArrayTest() {
		String jsonstring = "{'name':'xiazdong','age':20,'book':['book1','book2']}";
		JSONObject jsonobj = new JSONObject(jsonstring);

		String name = jsonobj.getString("name");
		System.out.println("name" + ":" + name);

		int age = jsonobj.getInt("age");
		System.out.println("age" + ":" + age);

		JSONArray jsonarray = jsonobj.getJSONArray("book");
		for (int i = 0; i < jsonarray.length(); i++) {
			String book = jsonarray.getString(i);
			System.out.println("book" + i + ":" + book);
		}
	}

	public static void jsonStringerTest() {
		JSONStringer stringer = new JSONStringer();
		stringer.object().key("name").value("xiazdong").key("age").value(20)
				.endObject();
		System.out.println(stringer);
	}
	/**
	 * 负载的JSON格式写演示（PrintWriter+JSONStringer可以写入JSON文件）： 
	 * @throws FileNotFoundException
	 */
	public static void jsonStringerTest2() throws FileNotFoundException {
		JSONStringer jsonStringer = new JSONStringer();
		JSONObject obj6 = new JSONObject();
		obj6.put("title", "book1").put("price", "$11");
		JSONObject obj3 = new JSONObject();
		obj3.put("book", obj6);
		obj3.put("author", new JSONObject().put("name", "author-1"));

		JSONObject obj5 = new JSONObject();
		obj5.put("title", "book2").put("price", "$22");
		JSONObject obj4 = new JSONObject();
		obj4.put("book", obj5);
		obj4.put("author", new JSONObject().put("name", "author-2"));

		JSONArray obj2 = new JSONArray();
		obj2.put(obj3).put(obj4);

		JSONObject obj1 = new JSONObject();
		obj1.put("title", "BOOK");
		obj1.put("signing", obj2);

		jsonStringer.object().key("session").value(obj1).endObject();
		System.out.println(jsonStringer.toString());

		PrintWriter out = new PrintWriter(new FileOutputStream("resource/1.txt"));
		out.println(jsonStringer.toString());
		out.close();
	}
	/**
	 * JSONObject+JSONTokener能够获取JSON格式文本对象
	 * @throws FileNotFoundException
	 */
	public static void JSONTokenerTest() throws FileNotFoundException {   
	    JSONObject jsonobj = new JSONObject(new JSONTokener(new FileReader(new File("resource/1.txt"))));   
	    System.out.println(jsonobj.getJSONObject("session").getJSONArray("signing").getJSONObject(1).getJSONObject("book").getString("title"));   
	}

}
