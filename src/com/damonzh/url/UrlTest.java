package com.damonzh.url;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlTest {
	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("https://www.google.com.hk/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8#q=uri");
		System.out.println(url.getPath());
		System.out.println(url.getRef());
	}
}
