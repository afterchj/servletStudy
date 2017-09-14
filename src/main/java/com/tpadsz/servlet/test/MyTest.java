package com.tpadsz.servlet.test;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by hongjian.chen on 2017/8/31.
 */
public class MyTest {
    @Test
    public void postForm() throws Exception {

        String json = "{\"app_id\":\"hfax10001test\",\"biz_content\":\"30F9C7EBEF0C204F0040FAB2D6323CD0344DCDD2E5FE448FFA465154D4AF870234" +
                "23A4A07DA4CC32C5783FB117190A99009639361461C4BF7ABC0F4410F0EFFE624712959AC8265E6A135CC47FDD6B55A7420CDB25D24AAD4C80FF71925E06B65A1FBE96" +
                "FB4856693AC3A1E918D86D6B507F2B49FDEC28C41A8E931A7FFE3DE66536E0C3D7EEC647162D065E92F6B12F0AC6E894A65154A93BC3ACC4E98BB65C4DF0B2461464D243CA1632F4" +
                "F6A6A954EDC6F02C68A67897D0D21456F2F7D28F9FEC3A49A9829054216C540CCEF658B515274E8E95E284E0638E7C89B1F3D8FD5CA3003DB9E795CBE83ECF3C3DE0023294FF940D6295E3192D0EF4" +
                "07520A1CF47C52C699A35475436956966CBDBED07276C61F095BF4794D69E9BC2C7D241E1B23E6DEAAC8A71F6DD376412575BCF45FFAD373A0E4FC1F3B06D3DCFF02709819BCDFE09A80EF7DEFF65C6A46544A46D5" +
                "15FF4DD4FEE6C24426530FDC58CA6B0DB69C5853A176C1D62DEBAA5ABCA4B08ACA266430B06BCA0E54ECC5A0A0C995F7\",\"sign\":\"767d191e88183d1923c0710a0423a9e4\",\"timestamp\":\"2017-07-12 " +
                "17:37:29\",\"version\":\"1.0.0\"}";
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost("http://localhost:8080/boss-locker/auth/user/saveKey.json");
//        HttpPost httppost = new HttpPost("http://www.uichange.com/ceshi/auth/user/saveKey.json");
//        json方式
        StringEntity entity1 = new StringEntity(json, "utf-8");//解决中文乱码问题
        entity1.setContentEncoding("UTF-8");
        entity1.setContentType("application/json");
        httppost.setEntity(entity1);
//        表单方式
//        ArrayList formparams = new ArrayList();
//        formparams.add(new BasicNameValuePair("params", json));
//        UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
//        httppost.setEntity(uefEntity);
        System.out.println("--------------------------------------");
        System.out.println("executing request " + httppost.getURI());

        CloseableHttpResponse response = httpclient.execute(httppost);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            System.out.println(response.getStatusLine());
            System.out.println("--------------------------------------");
            System.out.println("Response content: " + EntityUtils.toString(entity, "UTF-8"));
            System.out.println("--------------------------------------");
        }
        response.close();
        httpclient.close();
    }

    @Test
    public void testJsonOrForm() {
        HttpPost httpPost = new HttpPost("http://localhost:8080/boss-locker/auth/user/saveKey.json");
//        HttpPost httpPost = new HttpPost("http://www.uichange.com/ceshi/auth/user/saveKey.json");
        CloseableHttpClient client = HttpClients.createDefault();
//        json方式
        String json = "{\"app_id\":\"hfax10001test\",\"biz_content\":\"30F9C7EBEF0C204F0040FAB2D6323CD0344DCDD2E5FE448FFA465154D4AF870234" +
                "23A4A07DA4CC32C5783FB117190A99009639361461C4BF7ABC0F4410F0EFFE624712959AC8265E6A135CC47FDD6B55A7420CDB25D24AAD4C80FF71925E06B65A1FBE96" +
                "FB4856693AC3A1E918D86D6B507F2B49FDEC28C41A8E931A7FFE3DE66536E0C3D7EEC647162D065E92F6B12F0AC6E894A65154A93BC3ACC4E98BB65C4DF0B2461464D243CA1632F4" +
                "F6A6A954EDC6F02C68A67897D0D21456F2F7D28F9FEC3A49A9829054216C540CCEF658B515274E8E95E284E0638E7C89B1F3D8FD5CA3003DB9E795CBE83ECF3C3DE0023294FF940D6295E3192D0EF4" +
                "07520A1CF47C52C699A35475436956966CBDBED07276C61F095BF4794D69E9BC2C7D241E1B23E6DEAAC8A71F6DD376412575BCF45FFAD373A0E4FC1F3B06D3DCFF02709819BCDFE09A80EF7DEFF65C6A46544A46D5" +
                "15FF4DD4FEE6C24426530FDC58CA6B0DB69C5853A176C1D62DEBAA5ABCA4B08ACA266430B06BCA0E54ECC5A0A0C995F7\",\"sign\":\"767d191e88183d1923c0710a0423a9e4\",\"timestamp\":\"2017-07-12 " +
                "17:37:29\",\"version\":\"1.0.0\"}";
        StringEntity entity = new StringEntity(json, "utf-8");//解决中文乱码问题
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        httpPost.setEntity(entity);
//        表单方式
//        try {
//            List<BasicNameValuePair> pairList = new ArrayList<BasicNameValuePair>();
//            pairList.add(new BasicNameValuePair("params", json));
//            pairList.add(new BasicNameValuePair("pass", "123456"));
//            httpPost.setEntity(new UrlEncodedFormEntity(pairList, "utf-8"));
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
        try {
            HttpResponse resp = client.execute(httpPost);
            if (resp.getStatusLine().getStatusCode() == 200) {
                HttpEntity he = resp.getEntity();
                try {
                    String  respContent = EntityUtils.toString(he, "UTF-8");
                    System.out.println(respContent);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
