package com.tpadsz.servlet.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by hongjian.chen on 2017/9/29.
 */
public class HttpClientUtil {

    public static String requePost(String uri, JSONObject params) {
        String result = "";
        HttpClient httpClient = new HttpClient();
        PostMethod postMethod = new PostMethod(uri);
        InputStream in = null;
        BufferedReader br = null;
        try {
            RequestEntity requestEntity = new StringRequestEntity(JSON.toJSONString(params), "application/json", "utf-8");
            postMethod.setRequestEntity(requestEntity);
            httpClient.executeMethod(postMethod);
            in = postMethod.getResponseBodyAsStream();
            br = new BufferedReader(new InputStreamReader(in));
            String str = br.readLine();
            result = new String(str.getBytes("utf-8"), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Test
    public void testJson() {

    }

    @Test
    public void testForm() throws Exception {
        HttpClient httpClient = new HttpClient();
        String url = "http://localhost:8080/boss-locker/maiyou/list";
        String url1 = "http://www.uichange.com/bosslocker-test/maiyou/list.json";
        String uri = "http://localhost:8080/ums3-client2/spfile/getChildrenTypes/pid4";
        String uri1="http://www.uichange.com/bosslocker-test/cpl/getPrizeInfo.json";
        PostMethod postMethod = new PostMethod(uri);
//   填入各个表单域的值
        NameValuePair[] data = {//
                new NameValuePair("uid", "5044a0eb21ff44e6a3f986727b69e782"), //
                new NameValuePair("dataId", "20001"), //
                new NameValuePair("type", "1"), //
                new NameValuePair("page", "1"), //
                new NameValuePair("imei", "868017029140345"),//
                new NameValuePair("cplname", "wangpai")};//
//   将表单的值放入postMethod中
//        postMethod.setRequestBody(data);
        httpClient.executeMethod(postMethod);
        InputStream in = postMethod.getResponseBodyAsStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String str = br.readLine();
        String result = new String(str.getBytes("utf-8"), "utf-8");
        System.out.println(result);
        br.close();
        in.close();
    }
}
