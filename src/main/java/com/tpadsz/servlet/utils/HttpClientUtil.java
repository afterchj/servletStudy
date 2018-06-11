package com.tpadsz.servlet.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.junit.Test;

import java.io.*;

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
    public void testForm() throws Exception {
        HttpClient httpClient = new HttpClient();
        String url = "http://localhost:8080/boss-locker/maiyou/list";
        String url1 = "http://www.uichange.com/bosslocker-test/maiyou/list.json";
        String uri = "http://localhost:8080/ums3-client2/spfile/getChildrenTypes/pid4";
        String uri1 = "http://www.uichange.com/bosslocker-test/cpl/getPrizeInfo.json";
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

    @Test
    public void testJson() {
        String contents = "{\"task_id\":\"29630\",\"auth_id\":\"1000375122\"}";

        String result = requePost("http://localhost:8080/boss-locker/auth/user/saveKey.json", JSON.parseObject(contents));
        System.out.println(result);
    }

    @Test
    public void uploadFile() throws FileNotFoundException {
        File file = new File("C:\\temp\\tool.png");
        File file1 = new File("C:\\temp\\shopping.jpg");
        HttpClient client = new HttpClient();
        PostMethod filePost = new PostMethod("http://localhost:8080/web-ssm/file/upload2");
//       MultipartPostMethod filePost = new MultipartPostMethod(msUrl);
        // 若上传的文件比较大 , 可在此设置最大的连接超时时间
        client.getHttpConnectionManager().getParams().setConnectionTimeout(8000);
        try {
            FilePart fp = new FilePart(file.getName(), file);
            FilePart fp1 = new FilePart(file1.getName(), file1);
            StringPart sp = new StringPart("comment", "this is test");
            MultipartRequestEntity mrp = new MultipartRequestEntity(new Part[]{sp, fp, fp1}, filePost.getParams());
            filePost.setRequestEntity(mrp);
            //使用系统提供的默认的恢复策略
            filePost.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());

            int httpStat = client.executeMethod(filePost);

            if (httpStat == HttpStatus.SC_OK) {
                InputStream in = filePost.getResponseBodyAsStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String result = new String(br.readLine().getBytes("utf-8"), "utf-8");
                System.out.println("result=" + result);
                br.close();
                in.close();
                System.out.println("UPLOAD FILE SUCCESS");
            } else {
                System.out.println("UPLOAD FILE FAILURE");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        filePost.releaseConnection();
    }
}
