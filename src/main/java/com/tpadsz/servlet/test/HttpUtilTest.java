package com.tpadsz.servlet.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tpadsz.servlet.utils.CalendarUtil;
import com.tpadsz.servlet.utils.HttpClientUtil;
import com.tpadsz.servlet.utils.mao.AESDecryptor;
import com.tpadsz.servlet.utils.mao.AESEncryptor;
import com.tpadsz.servlet.utils.mao.Signature;

import org.junit.Test;
import sun.security.util.Length;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by hongjian.chen on 2017/8/31.
 */
public class HttpUtilTest {

    final String uri = "http://113.107.2.18:9556/fortress";
    final String key = "dd2a5427c052e798faf790b4900f723c";
    final String auth_id = "1000000270";

    @Test
    public void getMewTasks1() throws Exception {
//        String contents="{\"user_phone\":\"18170756879\",\"user_id\":\"919031c89cd64be59462f52022e84bad\"}";
        String contents = "{\"task_province\":\"上海\",\"task_city\":\"上海\",\"task_type\":\"0\",\"task_sort_type\":\"0\",\"task_platform\":\"0\",\"page_num\":\"2\",\"page_size\":\"10\"}";
        String sign = Signature.signature(key + contents + key);
        System.out.println("singn=" + sign);
        String msg = AESEncryptor.encrypt(contents, key);
        JSONObject object = new JSONObject();
        object.put("clientId", "JW47a958c9901b92");
        object.put("name", "getMewTasks");
//        object.put("name", "userAuth");
        object.put("version", "1.0");
        object.put("content", msg);
        object.put("signature", sign);
        String result = HttpClientUtil.requePost(uri, object);

        JSONObject object1 = JSON.parseObject(result);
        String encryptMsg = object1.getString("content");
        String msg1 = AESDecryptor.decrypt(encryptMsg, key);
        String sign1 = Signature.signature(key + msg1 + key);
        System.out.println("验证签名 = " + sign1.equals(object1.getString("signature")));
//        System.out.println("result:\n" + msg1);
        JSONArray jsonArray = JSON.parseArray(msg1);
        JSONObject object2 = (JSONObject) jsonArray.get(1);
        System.out.println("JSONObject=" + object2);
        System.out.println("jsonArray=" + jsonArray.size());
        List<Map> jsonMap = JSON.parseArray(msg1, Map.class);
        Map<String, Object> map = jsonMap.get(0);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
        }
        System.out.println("jsonMap=" + jsonMap.size());
        System.out.println("map=" + map);
    }

    @Test
    public void getMewTaskDetail() throws Exception {
        String contents = "{\"task_id\":\"3784\",\"auth_id\":\"1000000270\"}";
        String sign = Signature.signature(key + contents + key);
        System.out.println("singn=" + sign);
        String msg = AESEncryptor.encrypt(contents, key);
        JSONObject object = new JSONObject();
        object.put("clientId", "JW47a958c9901b92");
        object.put("name", "getMewTaskDetail");
        object.put("version", "1.0");
        object.put("content", msg);
        object.put("signature", sign);
        String result = HttpClientUtil.requePost(uri, object);
        JSONObject object1 = JSON.parseObject(result);
        String encryptMsg = object1.getString("content");
        String msg1 = AESDecryptor.decrypt(encryptMsg, key);
        String sign1 = Signature.signature(key + msg1 + key);
        System.out.println("验证签名 = " + sign1.equals(object1.getString("signature")));
//        System.out.println("result:\n" + msg1);

        Map<String, Object> map = JSON.parseObject(msg1, Map.class);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
        }
    }

    @Test
    public void getMewTasks2() throws Exception {
        long start = CalendarUtil.addDay(-1);
        long end = CalendarUtil.addDay(1);
        JSONObject object = new JSONObject();
        object.put("start_time", start);
        object.put("end_time", end);
        object.put("page_num", 1);
        object.put("page_size", 20);
        String contents = JSON.toJSONString(object);
        String sign = Signature.signature(key + contents + key);
        System.out.println("singn=" + sign);
        String msg = AESEncryptor.encrypt(contents, key);
        JSONObject params = new JSONObject();
        params.put("clientId", "JW47a958c9901b92");
        params.put("name", "getMewTasks");
        params.put("version", "2.0");
        params.put("content", msg);
        params.put("signature", sign);
        String result = HttpClientUtil.requePost(uri, params);
        JSONObject object1 = JSON.parseObject(result);
        String encryptMsg = object1.getString("content");
        String msg1 = AESDecryptor.decrypt(encryptMsg, key);
        String sign1 = Signature.signature(key + msg1 + key);
        System.out.println("验证签名 = " + sign1.equals(object1.getString("signature")));
//        System.out.println("result:\n" + msg1);
        JSONArray jsonArray = JSON.parseArray(msg1);
        JSONObject object2 = (JSONObject) jsonArray.get(1);
        System.out.println("object2="+object2);
        System.out.println("jsonArray=" + jsonArray);
        System.out.println("jsonArray.size=" + jsonArray.size());
        List<Map> jsonMap = JSON.parseArray(msg1, Map.class);
        Map<String, Object> map = jsonMap.get(jsonMap.size() - 1);
        Object array = map.get("task_open_area");
        System.out.println("array=+" + array);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
        }
        System.out.println("jsonMap=" + jsonMap.size());
        System.out.println("map=" + map);
    }

    @Test
    public void getMewTaskSteps() throws Exception {
        String contents = "{\"task_id\":\"3784\"}";
        String sign = Signature.signature(key + contents + key);
        System.out.println("singn=" + sign);
        String msg = AESEncryptor.encrypt(contents, key);
        JSONObject object = new JSONObject();
        object.put("clientId", "JW47a958c9901b92");
        object.put("name", "getMewTaskSteps");
        object.put("version", "1.0");
        object.put("content", msg);
        object.put("signature", sign);
        String result = HttpClientUtil.requePost(uri, object);
        JSONObject object1 = JSON.parseObject(result);
        String encryptMsg = object1.getString("content");
        String msg1 = AESDecryptor.decrypt(encryptMsg, key);

        JSONArray jsonArray = JSON.parseArray(msg1);
//        System.out.println("jsonArray=" + jsonArray);
        System.out.println("jsonArray.size=" + jsonArray.size());
        String sign1 = Signature.signature(key + msg1 + key);
        System.out.println("验证签名 = " + sign1.equals(object1.getString("signature")));
//        System.out.println("result:\n" + msg1);
        System.out.println("-----------------------<" + 0 + ">---------------------------");
        List<Map> jsonMap = JSON.parseArray(msg1, Map.class);
        for (int i = 0; i < jsonMap.size(); i++) {
            Map<String, Object> map = jsonMap.get(i);
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
            }
            System.out.println("-----------------------<" + (i + 1) + ">---------------------------");
        }
        System.out.println("jsonArray=" + jsonMap.size());
    }

}
