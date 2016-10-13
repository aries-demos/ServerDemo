package com.damonzh.demo.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
  
public class MyHttpServer {  
  
    public static void main(String[] args) {  
        try {  
            HttpServer hs = HttpServer.create(new InetSocketAddress(7777), 0);  
            hs.createContext("/myrequest", new MyHandlerPostAndGet());  
            hs.setExecutor(null);  
            hs.start();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
}  
  
class MyHandler implements HttpHandler {  
    public void handle(HttpExchange t) throws IOException {  
        System.out.println(t.getRequestURI().toString());  
        InputStream is = t.getRequestBody();  
        byte[] temp = new byte[is.available()];  
        is.read(temp);  
        System.out.println(new String(temp));  
        String response = "<h3>Hello World!</h3>";  
        t.sendResponseHeaders(200, response.length());  
        OutputStream os = t.getResponseBody();  
        os.write(response.getBytes());  
        os.close();  
    }  
}
class MyHandlerGet implements HttpHandler {  
    public void handle(HttpExchange exchange) throws IOException {  
        String requestMethod = exchange.getRequestMethod();  
        if (requestMethod.equalsIgnoreCase("GET")) {  
            
        	Headers responseHeaders = exchange.getResponseHeaders();  
            responseHeaders.set("Content-Type", "text/plain");  
            exchange.sendResponseHeaders(200, 0);  
  
            OutputStream responseBody = exchange.getResponseBody();  
            Headers requestHeaders = exchange.getRequestHeaders();  
            Set<String> keySet = requestHeaders.keySet();  
            Iterator<String> iter = keySet.iterator();  
            while (iter.hasNext()) {  
                String key = iter.next();  
                List<?> values = requestHeaders.get(key);  
                String s = key + " = " + values.toString() + "\n";  
                responseBody.write(s.getBytes());  
            }  
            responseBody.close();  
        }  
    }  
}  
class MyHandlerPostAndGet implements HttpHandler {  
    public void handle(HttpExchange exchange) throws IOException {  
        String requestMethod = exchange.getRequestMethod();  
        if (requestMethod.equalsIgnoreCase("POST")) {  
            Headers responseHeaders = exchange.getResponseHeaders();  
            responseHeaders.set("Content-Type", "text/plain");  
            exchange.sendResponseHeaders(423, 0);  
  
            OutputStream responseBody = exchange.getResponseBody();  
            Headers requestHeaders = exchange.getRequestHeaders();  
            Set<String> keySet = requestHeaders.keySet();  
            Iterator<String> iter = keySet.iterator();  
            while (iter.hasNext()) {  
                String key = iter.next();  
                List<?> values = requestHeaders.get(key);  
                String s = key + values.toString() + "\n";  
                responseBody.write(s.getBytes());  
            }  
            responseBody.close();  
        }else if (requestMethod.equalsIgnoreCase("GET")) {  
            
        	Headers responseHeaders = exchange.getResponseHeaders();  
            responseHeaders.set("Content-Type", "text/plain");  
            exchange.sendResponseHeaders(200, 0);  
  
            OutputStream responseBody = exchange.getResponseBody();  
            Headers requestHeaders = exchange.getRequestHeaders();  
            Set<String> keySet = requestHeaders.keySet();  
            Iterator<String> iter = keySet.iterator();  
            while (iter.hasNext()) {  
                String key = iter.next();  
                List<?> values = requestHeaders.get(key);  
                String s = key + " = " + values.toString() + "\n";  
                responseBody.write(s.getBytes());  
            }  
            responseBody.close();  
        }  
    }  
}
