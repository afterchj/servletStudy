package com.tpadsz.servlet.test;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by hongjian.chen on 2017/8/31.
 */
public class Test {
    @org.junit.Test
    public void test() throws IOException {
        String content = "{\"app_id\":\"hfax10001test\",\"biz_content\":\"30F9C7EBEF0C204F0040FAB2D6323CD0344DCDD2E5FE448FFA465154D4AF870234" +
                "23A4A07DA4CC32C5783FB117190A99009639361461C4BF7ABC0F4410F0EFFE624712959AC8265E6A135CC47FDD6B55A7420CDB25D24AAD4C80FF71925E06B65A1FBE96" +
                "FB4856693AC3A1E918D86D6B507F2B49FDEC28C41A8E931A7FFE3DE66536E0C3D7EEC647162D065E92F6B12F0AC6E894A65154A93BC3ACC4E98BB65C4DF0B2461464D243CA1632F4" +
                "F6A6A954EDC6F02C68A67897D0D21456F2F7D28F9FEC3A49A9829054216C540CCEF658B515274E8E95E284E0638E7C89B1F3D8FD5CA3003DB9E795CBE83ECF3C3DE0023294FF940D6295E3192D0EF4" +
                "07520A1CF47C52C699A35475436956966CBDBED07276C61F095BF4794D69E9BC2C7D241E1B23E6DEAAC8A71F6DD376412575BCF45FFAD373A0E4FC1F3B06D3DCFF02709819BCDFE09A80EF7DEFF65C6A46544A46D5" +
                "15FF4DD4FEE6C24426530FDC58CA6B0DB69C5853A176C1D62DEBAA5ABCA4B08ACA266430B06BCA0E54ECC5A0A0C995F7\",\"sign\":\"767d191e88183d1923c0710a0423a9e4\",\"timestamp\":\"2017-07-12 " +
                "17:37:29\",\"version\":\"1.0.0\"}";
        HttpClient httpClient = new HttpClient();
        //url是请求的url
//        PostMethod postMethod = new PostMethod("http://www.uichange.com/ceshi/auth/user/saveKey.json");
        PostMethod postMethod = new PostMethod("http://localhost:8080/boss-locker/auth/user/saveKey.json");
        RequestEntity requestEntity = new StringRequestEntity(content, "application/json", "utf-8");
        postMethod.setRequestEntity(requestEntity);

        int statusCode = httpClient.executeMethod(postMethod);
        System.out.println(statusCode);
//        byte[] responseBody = postMethod.getResponseBody();
        InputStream in = postMethod.getResponseBodyAsStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String str = br.readLine();
        String result = new String(str.getBytes("utf-8"), "utf-8");
        System.out.println("服务器的响应是:\n" + result);
        br.close();
        in.close();
    }
}
