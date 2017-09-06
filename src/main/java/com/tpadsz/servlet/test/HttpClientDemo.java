package com.tpadsz.servlet.test;

import org.apache.commons.httpclient.HttpClient;
import org.apache.http.client.ClientProtocolException;

import java.io.IOException;

/**
 * Created by hongjian.chen on 2017/8/31.
 */
public class HttpClientDemo {
//    public static void main(String[] args) throws ClientProtocolException, IOException {
//        String path="http://10.0.184.105:58080/ServletDemo4/LoginServlet?username=admin&password=admin";
//        //1.创建客户端访问服务器的httpclient对象   打开浏览器
//        HttpClient httpclient=new DefaultHttpClient();
//        //2.以请求的连接地址创建get请求对象     浏览器中输入网址
//        HttpGet httpget=new HttpGet(path);
//        //3.向服务器端发送请求 并且获取响应对象  浏览器中输入网址点击回车
//        HttpResponse response=httpclient.execute(httpget);
//        //4.获取响应对象中的响应码
//        StatusLine statusLine=response.getStatusLine();//获取请求对象中的响应行对象
//        int responseCode=statusLine.getStatusCode();//从状态行中获取状态码
//        if(responseCode==200){
//            //5.获取HttpEntity消息载体对象  可以接收和发送消息
//            HttpEntity entity=response.getEntity();
//            //EntityUtils中的toString()方法转换服务器的响应数据
//            String str=EntityUtils.toString(entity, "utf-8");
//            System.out.println("服务器的响应是:"+str);
//
////          //6.从消息载体对象中获取操作的读取流对象
////          InputStream input=entity.getContent();
////          BufferedReader br=new BufferedReader(new InputStreamReader(input));
////          String str=br.readLine();
////          String result=new String(str.getBytes("gbk"), "utf-8");
////          System.out.println("服务器的响应是:"+result);
////          br.close();
////          input.close();
//        }else{
//            System.out.println("响应失败!");
//        }
//    }
}
