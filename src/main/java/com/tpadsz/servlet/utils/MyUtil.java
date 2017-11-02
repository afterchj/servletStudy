package com.tpadsz.servlet.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tpadsz.servlet.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by hongjian.chen on 2017/8/31.
 */
public class MyUtil {
    @Test
    public void test() {
        String str = "{\"result\":\"000\",\"json\":{\"createDate\":1487643767000,\"luckValues\":3}}";
        JSONObject params = JSON.parseObject(str);
        String values = params.getString("json");
        JSONObject object = JSON.parseObject(values);
        Date createDate = object.getDate("createDate");
        System.out.println(createDate.getTime());
        long len = new Date().getTime() - createDate.getTime();
        long between_days = (len) / (1000 * 3600 * 24);
        System.out.println("history=" + between_days);
    }

    @Test
    public void test01() {
//        String str = "{\"loginName\":\"12301\",\"createDate\":\"1487643767000\",\"luckValues\":\"5\"}";
        String str = "{\"result\":\"000\",\"createDate\":1487643767000,\"luckValues\":3}";
        JSONObject params = JSON.parseObject(str);
        Map<String, Object> map = JSONObject.toJavaObject(params, Map.class);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
        JSONObject params1 = JSON.parseObject(str);
        StringUtils.isEmpty(params1.getString("loginName"));
        if (StringUtils.isEmpty(params1.getString("loginName"))) {
            System.out.println("loginName不能为空");
        }
    }

    @Test
    public void test02() {

        String str = "{\"createData\":1487643767000,\"redNum\":null,\"costDetails\"" + ":[{\"name\":\"兑换支出\",\"value\":1000},{\"name\":\"其他支出\",\"value\":0}]," + "\"history\":6900,\"incomeDetails\":[{\"name\":\"任务收入\",\"value\":910}," + "{\"name\":\"分成收入\",\"value\":0},{\"name\":\"注册收入\",\"value\":3000},{\"name\":\"解锁收入\"," + "\"value\":2080},{\"name\":\"奖金收入\",\"value\":720},{\"name\":\"签到收入\",\"value\":190}],\"luckValues\":7}";
        JSONObject params = JSON.parseObject(str);
        JSONArray json = JSON.parseArray(params.get("incomeDetails").toString());
        System.out.println(params.get("incomeDetails"));
        JSONArray json1 = JSON.parseArray(params.get("costDetails").toString());
        System.out.println(json1);
        for (int i = 0; i < json1.size(); i++) {
            JSONObject job = json1.getJSONObject(i);
            System.out.println("name:" + job.get("name") + ",value:" + job.get("value"));
        }
        System.out.println("---------------------------------------------------");
        if (json.size() > 0) {
            for (int i = 0; i < json.size(); i++) {
                JSONObject job = json.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
                System.out.println("name:" + job.get("name") + ",value:" + job.get("value"));  // 得到 每个对象中的属性值
            }
        }
    }

    @Test
    public void test03() {
        String str = "{\"uid\": \"4d4c5c9cd2e140fe8003083ba9bc8f76\",\"token\": \"2328dd702d984553b0132c375f6e3c56\"," + "\"myself\":\"7344614\",\"friends\":\"7566040\",\"firmware\": {\"clientVersion\": \"1.5.1\",\"versionCode\": 57," + "\"imei\": \"869139024261014\",\"imsi\": \"460003544173172\",\"fm\": \"com.tencent.android.qqdownloader\",\"os\": \"android-5.0.2\"," + "\"model\": \"CHE-TL00H\",\"operators\": \"YD\",\"resolution\": \"720*1280\",\"netEnv\": \"WIFI\",\"pkg\": \"com.change.unlock.boss\"," + "\"mac\": \"50:68:0a:39:e0:8b\",\"android_id\": \"4035a2fbcbe5816e\",\"device_id\": \"fcdeb5010c0e375b8a0b96b8fc24067d\"," + "\"ym_device_id\": \"Ag7oRoTavttSyYavO_v8BRsfRwcg89eoB84a_EMgp5D6\",\"brand\": \"Honor\",\"mobileType\": \"HUAWEI\"," + "\"voltage\": 4266,\"temperature\": 320,\"user_lbs_info\": \"Loca\",\"bossDeviceId\": \"4193DD03EED009FC8C39026BF9060AD4\"," + "\"fingerprint\": \"Honor\"}}";
        String str1 = "{\"myself\":\"4949584\",\"friends\":\"7566040\"}";
        JSONObject params = JSON.parseObject(str);
//        System.out.println(params.toString());
        Map map = JSONObject.toJavaObject(params, Map.class);
        System.out.println("myself=" + map.get("myself") + ",friends=" + map.get("friends"));
    }

    @Test
    public void testJson() {
        String str = "[{\"id\":1,\"name\":\"test01\",\"pwd\":\"001\",\"sex\":\"male\"},{\"id\":2,\"info\":\"{\\\"result\\\":\\\"000\\\",\\\"luckValues\\\":3}\",\"name\":\"test02\",\"pwd\":\"002\",\"sex\":\"female\"},{\"id\":3,\"name\":\"test03\",\"pwd\":\"003\",\"sex\":\"male\"}]";

        Object o = "{\"result\":\"000\",\"luckValues\":3}";

        List<User> jsonList = new ArrayList<User>();
        for (int i = 1; i <= 3; i++) {
            User user = new User();
            if (i % 2 == 0) {
                user.setSex("female");
            } else {
                user.setSex("male");
            }
            if (i == 2) {
                user.setInfo(o);
            }
            user.setId(i);
            user.setName("test0" + i);
            user.setPwd("00" + i);
            jsonList.add(user);
        }
        String jsonString = JSON.toJSONString(jsonList);
        System.out.println("jsonString=" + jsonString);
        List<User> userList = JSON.parseArray(str, User.class);
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i).getInfo());
        }
    }

    @Test
    public void testDate() {
        long time = 1477014521000l;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(time);
        System.out.println(format.format(date));
    }

//    @Test
//    public void testJsonMap() {
//        String str = "{\"uid\":\"f9e474c87ef04ef4abdb221e048ea16b\",\"token\":\"2328dd702d984553b0132c375f6e3c56\",\"fileId\":\"13777\",\"fileType\":\"type\",\"price\":\"101\",\"firmware\":{\"clientVersion\":\"1.2.1\",\"versionCode\":57,\"imei\":\"869139024261014\",\"imsi\":\"460003544173172\",\"fm\":\"com.tencent.android.qqdownloader\",\"os\":\"android-5.0.2\",\"model\":\"CHE-TL00H\",\"operators\":\"YD\",\"resolution\":\"720*1280\",\"netEnv\":\"WIFI\",\"pkg\":\"com.change.unlock.boss\",\"mac\":\"50:68:0a:39:e0:8b\",\"android_id\":\"4035a2fbcbe5816e\",\"device_id\":\"fcdeb5010c0e375b8a0b96b8fc24067d\",\"ym_device_id\":\"Ag7oRoTavttSyYavO_v8BRsfRwcg89eoB84a_EMgp5D6\",\"brand\":\"Honor\",\"mobileType\":\"HUAWEI\",\"voltage\":4266,\"temperature\":320,\"user_lbs_info\":\"{\\\"LocationCity\\\":\\\"苏州市\\\",\\\"LocationCountry\\\":\\\"中国\\\",\\\"LocationDes\\\":\\\"江苏省苏州市虎丘区珠江路靠近苏州创业园(珠江路)\\\",\\\"LocationPOI\\\":\\\"苏州创业园(珠江路)\\\",\\\"Locationfrom\\\":\\\"GD\\\",\\\"LocationLat\\\":31.275805,\\\"Locationlng\\\":120.537661,\\\"LocationAccurancy\\\":25.0}\",\"bossDeviceId\":\"4193DD03EED009FC8C39026BF9060AD4\",\"fingerprint\":\"Honor\\/CHE-TL00H\\/hnCHE-H:5.0.2\\/HonorCHE-TL00H\\/C00B250:user\\/release-keys\"}}";
//        JSONObject params = JSON.parseObject(str);
//        String uid = params.getString("uid");
//        String object = params.getString("firmware");
//        Map<String, Object> map = JSON.parseObject(object, Map.class);
//        for (Map.Entry<String, Object> entry : map.entrySet()) {
//            if (entry.getKey().equals("user_lbs_info")) {
//                JSONObject info = JSON.parseObject(entry.getValue().toString());
//                String city = info.getString("LocationCity");
//                System.out.println("location=" + city);
//                continue;
//            }
//            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
//        }
//    }
}
