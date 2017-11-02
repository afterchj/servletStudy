package com.tpadsz.servlet.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.bcel.internal.generic.NEWARRAY;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hongjian.chen on 2017/10/10.
 */
public class MutilyTest {
    @Test
    public void test() {
        int num = 1;
        for (; ; ) {
            System.out.println("外循环---->" + num);
            if (num == 3) {
                return;
            } else {
                num++;
            }
            for (int i = 0; i < 5; i++) {
                System.out.println("内循环" + i);
            }
        }
    }

    @Test
    public void test1() {
        String a = "huawei";
        String b = "";
        String c = null;
        String ob = a;
        String str = "AboutYou";
        String test = "{\"mobileType\":[\"huawei\",\"meizu\"]}";
        String str1="[{\"age\":22,\"sex\":\"男\",\"userName\":\"xiaoliang\"},{\"age\":22,\"sex\":\"男\",\"userName\":\"xiaoliang\"}]";
        System.out.println("space=" + a.contains(b));
        System.out.println("test=" + test.contains(a));
        boolean flag1 = str.equalsIgnoreCase("aboutyou");
        System.out.println("IgnoreCase=" + flag1);
        String flag = String.format("%b", 2 == 3);
        System.out.print(String.format("3>7 is %b%n", 3 > 7));
        System.out.println("flag=" + flag);
        System.out.println(JSON.parseArray(str1).get(0));

        System.out.println("a=" + StringUtils.isNotBlank(a) + ",b=" + StringUtils.isNotBlank(b));
        System.out.println("c=" + StringUtils.isNotBlank(c) + ",ob=" + StringUtils.isNotBlank(ob));
        System.out.println("b=" + StringUtils.isNotEmpty(b));
        System.out.println("c=" + StringUtils.isNotEmpty(c));
    }
    @Test
    public void test2() {
        String str = "{\"uid\":\"c6cf5b91df264f6fab5b605260c32769\",\"token\":\"73a8375887434f2daf3ba7029739e999\",\"firmware\":{\"clientVersion\":\"1.5.0\",\"versionCode\":56,\"imei\":\"869139024261014\",\"imsi\":\"460003544173172\",\"fm\":\"com.tencent.android.qqdownloader\",\"os\":\"android-5.0.2\",\"model\":\"CHE-TL00H\",\"operators\":\"YD\",\"resolution\":\"720*1280\",\"netEnv\":\"WIFI\",\"pkg\":\"com.change.unlock.boss\",\"mac\":\"50:68:0a:39:e0:8b\",\"android_id\":\"4035a2fbcbe5816e\",\"device_id\":\"fcdeb5010c0e375b8a0b96b8fc24067d\",\"ym_device_id\":\"Ag7oRoTavttSyYavO_v8BRuis5Pdo0yHWBZV0NO4yBee\",\"brand\":\"Honor\",\"mobileType\":\"HUAWEI\",\"voltage\":4308,\"temperature\":350,\"user_lbs_info\":\"{\\\"LocationCity\\\":\\\"苏州市\\\",\\\"LocationCountry\\\":\\\"中国\\\",\\\"LocationDes\\\":\\\"江苏省苏州市虎丘区珠江路靠近苏州创业园(珠江路)\\\",\\\"LocationPOI\\\":\\\"苏州创业园(珠江路)\\\",\\\"Locationfrom\\\":\\\"GD\\\",\\\"LocationLat\\\":31.275797,\\\"Locationlng\\\":120.537642,\\\"LocationAccurancy\\\":25.0}\",\"bossDeviceId\":\"4193DD03EED009FC8C39026BF9060AD4\",\"fingerprint\":\"Honor\\/CHE-TL00H\\/hnCHE-H:5.0.2\\/HonorCHE-TL00H\\/C00B250:user\\/release-keys\"}}";
        JSONObject params = JSONObject.parseObject(str);
        JSONObject firmware = (JSONObject) params.get("firmware");//JSONObject.parseObject(params.getString("firmware"));

        JSONObject city = JSON.parseObject(firmware.getString("user_lbs_info"));
        System.out.println("city=" + city.getString("LocationCity"));
    }
}
