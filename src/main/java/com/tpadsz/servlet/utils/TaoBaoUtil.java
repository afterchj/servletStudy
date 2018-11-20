package com.tpadsz.servlet.utils;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkUatmFavoritesGetRequest;
import com.taobao.api.request.TbkUatmFavoritesItemGetRequest;
import com.taobao.api.response.TbkUatmFavoritesGetResponse;
import com.taobao.api.response.TbkUatmFavoritesItemGetResponse;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hongjian.chen on 2018/11/19.
 */


public class TaoBaoUtil {

    public static void main(String[] args) throws Exception {
//        favoritesGet();
//        System.out.println();
//        favoritesItemGet();
//        System.out.println();
//        urlEncode();
        Map map = new HashMap();
        map.put("vekey", CommonParam.VEKEY.getValue());
        map.put("para", "556602244435");
        map.put("pid", "mm_43238250_191900396_54299000426");
        String ret1 = HttpClientUtil.httpGet(CommonParam.VEHICPI.getValue(), map);
        map.put("start_time", "2018-10-25 19:48:24");
        map.put("span", "1200");
        String ret2 = HttpClientUtil.httpGet(CommonParam.VEORDER.getValue(), map);
        System.out.println("response1:\n" + ret1);
        System.out.println("response2:\n" + ret2);
    }

    public static void favoritesGet() throws ApiException {
        TaobaoClient client = new DefaultTaobaoClient(CommonParam.APPURL.getValue(), CommonParam.APPKER.getValue(), CommonParam.APPSECRET.getValue());
        TbkUatmFavoritesGetRequest req = new TbkUatmFavoritesGetRequest();
        req.setPageNo(1L);
        req.setPageSize(20L);
        req.setFields("favorites_title,favorites_id,type");
        req.setType(1L);
        TbkUatmFavoritesGetResponse rsp = client.execute(req);
        System.out.println(rsp.getBody());
    }

    public static void favoritesItemGet() throws ApiException {
        TaobaoClient client = new DefaultTaobaoClient(CommonParam.APPURL.getValue(), CommonParam.APPKER.getValue(), CommonParam.APPSECRET.getValue());
        TbkUatmFavoritesItemGetRequest req = new TbkUatmFavoritesItemGetRequest();
        req.setPlatform(1L);
        req.setPageSize(20L);
        req.setAdzoneId(44740840L);
        req.setUnid("3456");
        req.setFavoritesId(18745394L);
        req.setPageNo(1L);
        req.setFields("num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url,seller_id,volume,nick,shop_title,zk_final_price_wap,event_start_time,event_end_time,tk_rate,status,type");
        TbkUatmFavoritesItemGetResponse rsp = client.execute(req);
        System.out.println(rsp.getBody());
    }

    public static void urlEncode() throws UnsupportedEncodingException {
        String encode = "{\"itemNumId\":\"557691028742\"}";
        String urlEncode = URLEncoder.encode(encode, "utf-8");
        System.out.println(urlEncode);
    }
}
