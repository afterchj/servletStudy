package com.tpadsz.servlet.test;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hongjian.chen on 2017/8/31.
 */
public class HttpClientDemo {

    @Test
    public void testGet() {
        String path = "http://www.baidu.com";
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(path);
        HttpResponse response;
        try {
            response = httpclient.execute(httpget);
            StatusLine statusLine = response.getStatusLine();
            int responseCode = statusLine.getStatusCode();
            if (responseCode == 200) {
                HttpEntity entity = response.getEntity();
                String str = EntityUtils.toString(entity, "utf-8");
                System.out.println("服务器的响应是:" + str.trim());
            }
        } catch (IOException e) {
            System.out.println("响应失败!");
            e.printStackTrace();
        }
    }

    @Test
    public void testPost() {
        String path = "http://localhost:8080/servletStudy/login";
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(path);
        HttpResponse response;
        try {
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("name", "admin"));
            params.add(new BasicNameValuePair("pwd", "admin"));
            UrlEncodedFormEntity entity1 = new UrlEncodedFormEntity(params, "utf-8");
            httpPost.setEntity(entity1);
            response = httpclient.execute(httpPost);
            String str = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println("服务器的响应是:" + str.trim());
        } catch (IOException e) {
            System.out.println("响应失败!");
            e.printStackTrace();
        }
    }
}
