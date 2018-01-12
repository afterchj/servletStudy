package com.tpadsz.servlet.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class HttpClientTest {
    public HttpClientTest() {
    }

    @Test
    public void jUnitTest() {
        this.get();
    }

    public void ssl() {
        CloseableHttpClient httpclient = null;

        try {
            KeyStore e = KeyStore.getInstance(KeyStore.getDefaultType());
            FileInputStream instream = new FileInputStream(new File("c:\\tomcat.keystore"));

            try {
                e.load(instream, "123456".toCharArray());
            } catch (CertificateException var60) {
                var60.printStackTrace();
            } finally {
                try {
                    instream.close();
                } catch (Exception var58) {
                    ;
                }

            }

            SSLContext sslcontext = SSLContexts.custom().loadTrustMaterial(e, new TrustSelfSignedStrategy()).build();
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[]{"TLSv1"}, (String[]) null, SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
            httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
            HttpGet httpget = new HttpGet("https://localhost:8443/web/login");
            System.out.println("executing request" + httpget.getRequestLine());
            CloseableHttpResponse response = httpclient.execute(httpget);

            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    System.out.println(response.getStatusLine());
                    System.out.println("----------------------------------------");
                    System.out.println("Response content length: " + entity.getContentLength());
                    System.out.println("Response content:" + EntityUtils.toString(entity));
                    System.out.println("----------------------------------------");
                    EntityUtils.consume(entity);
                }
            } finally {
                response.close();
            }
        } catch (ParseException var62) {
            var62.printStackTrace();
        } catch (IOException var63) {
            var63.printStackTrace();
        } catch (KeyManagementException var64) {
            var64.printStackTrace();
        } catch (NoSuchAlgorithmException var65) {
            var65.printStackTrace();
        } catch (KeyStoreException var66) {
            var66.printStackTrace();
        } finally {
            if (httpclient != null) {
                try {
                    httpclient.close();
                } catch (IOException var57) {
                    var57.printStackTrace();
                }
            }

        }

    }

//    @HttpUtilTest
    public void postForm() throws Exception {
        String json = "{\"app_id\":\"hfax10001test\",\"biz_content\":\"30F9C7EBEF0C204F0040FAB2D6323CD0344DCDD2E5FE448FFA465154D4AF870234" +
                "23A4A07DA4CC32C5783FB117190A99009639361461C4BF7ABC0F4410F0EFFE624712959AC8265E6A135CC47FDD6B55A7420CDB25D24AAD4C80FF71925E06B65A1FBE96" +
                "FB4856693AC3A1E918D86D6B507F2B49FDEC28C41A8E931A7FFE3DE66536E0C3D7EEC647162D065E92F6B12F0AC6E894A65154A93BC3ACC4E98BB65C4DF0B2461464D243CA1632F4" +
                "F6A6A954EDC6F02C68A67897D0D21456F2F7D28F9FEC3A49A9829054216C540CCEF658B515274E8E95E284E0638E7C89B1F3D8FD5CA3003DB9E795CBE83ECF3C3DE0023294FF940D6295E3192D0EF4" +
                "07520A1CF47C52C699A35475436956966CBDBED07276C61F095BF4794D69E9BC2C7D241E1B23E6DEAAC8A71F6DD376412575BCF45FFAD373A0E4FC1F3B06D3DCFF02709819BCDFE09A80EF7DEFF65C6A46544A46D5" +
                "15FF4DD4FEE6C24426530FDC58CA6B0DB69C5853A176C1D62DEBAA5ABCA4B08ACA266430B06BCA0E54ECC5A0A0C995F7\",\"sign\":\"767d191e88183d1923c0710a0423a9e4\",\"timestamp\":\"2017-07-12 " +
                "17:37:29\",\"version\":\"1.0.0\"}";
        CloseableHttpClient httpclient = HttpClients.createDefault();
//        HttpPost httppost = new HttpPost("http://localhost:8080/testboss-locker/auth/user/saveKey.json");
        HttpPost httppost = new HttpPost("http://www.uichange.com/ceshi/auth/user/saveKey.json");
        ArrayList formparams = new ArrayList();
        formparams.add(new BasicNameValuePair("params", json));
//        formparams.add(new BasicNameValuePair("pwd", "98bd3a1bebde01ad363d3c5a0d1e56da"));
//        new UrlEncodedFormEntity(formparams, "UTF-8");
        UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
        httppost.setEntity(uefEntity);
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
    public void post() {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost("http://localhost:8080/bossLocker-store/alipay/callbacks.do");
        ArrayList formparams = new ArrayList();
        formparams.add(new BasicNameValuePair("id", "12"));

        try {
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
            httppost.setEntity(uefEntity);
            System.out.println("executing request " + httppost.getURI());
            CloseableHttpResponse e = httpclient.execute(httppost);

            try {
                HttpEntity entity = e.getEntity();
                if (entity != null) {
                    System.out.println("Response content:" + e.getStatusLine());
                    System.out.println("--------------------------------------");
                    System.out.println("Response content: " + EntityUtils.toString(entity, "UTF-8"));
                    System.out.println("--------------------------------------");
                }
            } finally {
                e.close();
            }
        } catch (ClientProtocolException var28) {
            var28.printStackTrace();
        } catch (UnsupportedEncodingException var29) {
            var29.printStackTrace();
        } catch (IOException var30) {
            var30.printStackTrace();
        } finally {
            try {
                httpclient.close();
            } catch (IOException var26) {
                var26.printStackTrace();
            }
        }
    }

    public void get() {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet e = new HttpGet("http://www.baidu.com/");
            System.out.println("executing request " + e.getURI());
            CloseableHttpResponse response = httpclient.execute(e);
            try {
                HttpEntity entity = response.getEntity();
                System.out.println(response.getStatusLine());
                System.out.println("--------------------------------------");
                System.out.println(response.getStatusLine());
                if (entity != null) {
                    System.out.println("Response content length: " + entity.getContentLength());
                    System.out.println("Response content: " + EntityUtils.toString(entity));
                }
                System.out.println("------------------------------------");
            } finally {
                response.close();
            }
        } catch (ClientProtocolException var26) {
            var26.printStackTrace();
        } catch (ParseException var27) {
            var27.printStackTrace();
        } catch (IOException var28) {
            var28.printStackTrace();
        } finally {
            try {
                httpclient.close();
            } catch (IOException var24) {
                var24.printStackTrace();
            }
        }
    }

    public void upload() {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        try {
            HttpPost e = new HttpPost("http://localhost:8080/web/fileUpload");
            FileBody bin = new FileBody(new File("C:\\image\\sendpix0.jpg"));
            StringBody comment = new StringBody("A binary file of some kind", ContentType.TEXT_PLAIN);
            HttpEntity reqEntity = MultipartEntityBuilder.create().addPart("bin", bin).addPart("comment", comment).build();
            e.setEntity(reqEntity);
            System.out.println("executing request " + e.getRequestLine());
            CloseableHttpResponse response = httpclient.execute(e);

            try {
                System.out.println("----------------------------------------");
                System.out.println(response.getStatusLine());
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    System.out.println("Response content length: " + resEntity.getContentLength());
                }
                EntityUtils.consume(resEntity);
            } finally {
                response.close();
            }
        } catch (ClientProtocolException var26) {
            var26.printStackTrace();
        } catch (IOException var27) {
            var27.printStackTrace();
        } finally {
            try {
                httpclient.close();
            } catch (IOException var24) {
                var24.printStackTrace();
            }
        }
    }
}
