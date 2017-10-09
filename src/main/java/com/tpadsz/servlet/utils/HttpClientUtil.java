package com.tpadsz.servlet.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tpadsz.servlet.utils.mao.AESDecryptor;
import com.tpadsz.servlet.utils.mao.Signature;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

/**
 * Created by hongjian.chen on 2017/9/29.
 */
public class HttpClientUtil {
    public static String requePost(String uri,JSONObject params) throws IOException {
        HttpClient httpClient = new HttpClient();
        PostMethod postMethod = new PostMethod(uri);
        RequestEntity requestEntity = new StringRequestEntity(JSON.toJSONString(params), "application/json", "utf-8");
        postMethod.setRequestEntity(requestEntity);

        int statusCode = httpClient.executeMethod(postMethod);
        System.out.println(statusCode);
        InputStream in = postMethod.getResponseBodyAsStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String str = br.readLine();
        String result = new String(str.getBytes("utf-8"), "utf-8");
        br.close();
        in.close();
        return result;
    }
}
