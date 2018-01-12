package com.tpadsz.servlet.test;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by hongjian.chen on 2017/8/31.
 */
public class HttpClientDemo {

    @Test
    public void testGet() {
        String path = "http://localhost:8080/ums3-client2/spfile/getChildrenTypes/pid4";
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet(path);
        HttpResponse response;
        try {
            response = httpclient.execute(httpget);
            StatusLine statusLine = response.getStatusLine();
            int responseCode = statusLine.getStatusCode();
            if (responseCode == 200) {
                HttpEntity entity = response.getEntity();
                String str = EntityUtils.toString(entity, "utf-8");
                System.out.println("服务器的响应是:" + str);
            }
        } catch (IOException e) {
            System.out.println("响应失败!");
            e.printStackTrace();
        }
    }

    @Test
    public void testPost() {
        String path = "http://localhost:8080/ums3-client2/spfile/getChildrenTypes/pid4";
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(path);
        HttpResponse response;
        try {
            response = httpclient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            String str = EntityUtils.toString(entity, "utf-8");
            System.out.println("服务器的响应是:" + str);
        } catch (IOException e) {
            System.out.println("响应失败!");
            e.printStackTrace();
        }
    }
}
