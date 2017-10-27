package com.tpadsz.servlet.utils.mao;

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

/**
 * Created by hongjian.chen on 2017/10/10.
 */
public class GetMaoTask {

    final static String key = "51fec0b6c9a40d1bf7b4bb649b473161";

    public static String requePost(String uri, JSONObject params) {
        params.put("clientId", "JW47a96eadcd2dee");
        params.put("version", "2.0");
//        JSONArray array = null;
        HttpClient httpClient = new HttpClient();
        PostMethod postMethod = new PostMethod(uri);
        InputStream in = null;
        BufferedReader br = null;
        RequestEntity requestEntity = null;
        try {
            requestEntity = new StringRequestEntity(JSON.toJSONString(params), "application/json", "utf-8");
            postMethod.setRequestEntity(requestEntity);
            httpClient.executeMethod(postMethod);
            in = postMethod.getResponseBodyAsStream();
            br = new BufferedReader(new InputStreamReader(in));
            String str = br.readLine();
            String result = new String(str.getBytes("utf-8"), "utf-8");
            JSONObject object1 = JSON.parseObject(result);
            String encryptMsg = object1.getString("content");
            return AESDecryptor.decrypt(encryptMsg, key);
//            String sign1 = Signature.signature(key + msg1 + key);
//            System.out.println("验证签名 = " + sign1.equals(object1.getString("signature")));
//            array = JSON.parseArray(msg1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }
}
