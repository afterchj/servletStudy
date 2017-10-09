package com.sign;

import com.google.gson.Gson;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by hongjian.chen on 2017/9/5.
 */
public class TestUtil {

    @Test
    public void test() {
        final String PUB_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCC+Sv22pZ//YSG51jShbxT7VwfTCxCNv3etP7g9hn++hlAFD" +
                "PEjBHnlrvLqKeHOv41tCAPmsbkrpAccyy0KchqBcTlMt3/NABW0qnLDGHhnjHyU0UiTboAx3kqBqzuvdzq" +
                "YFjr5kdf7uTUcTlYh5qaQfemWzXpEl9Ur/tWDmwW+wIDAQAB";

        String params = "{\"app_id\":\"hfax10001test\",\"biz_content\":\"30F9C7EBEF0C204F0040FAB2D6323CD0344DCDD2E5FE448FFA465154D4AF870234" +
                "23A4A07DA4CC32C5783FB117190A99009639361461C4BF7ABC0F4410F0EFFE624712959AC8265E6A135CC47FDD6B55A7420CDB25D24AAD4C80FF71925E06B65A1FBE96" +
                "FB4856693AC3A1E918D86D6B507F2B49FDEC28C41A8E931A7FFE3DE66536E0C3D7EEC647162D065E92F6B12F0AC6E894A65154A93BC3ACC4E98BB65C4DF0B2461464D243CA1632F4" +
                "F6A6A954EDC6F02C68A67897D0D21456F2F7D28F9FEC3A49A9829054216C540CCEF658B515274E8E95E284E0638E7C89B1F3D8FD5CA3003DB9E795CBE83ECF3C3DE0023294FF940D6295E3192D0EF4" +
                "07520A1CF47C52C699A35475436956966CBDBED07276C61F095BF4794D69E9BC2C7D241E1B23E6DEAAC8A71F6DD376412575BCF45FFAD373A0E4FC1F3B06D3DCFF02709819BCDFE09A80EF7DEFF65C6A46544A46D5" +
                "15FF4DD4FEE6C24426530FDC58CA6B0DB69C5853A176C1D62DEBAA5ABCA4B08ACA266430B06BCA0E54ECC5A0A0C995F7\",\"sign\":\"767d191e88183d1923c0710a0423a9e4\",\"timestamp\":\"2017-07-12 " +
                "17:37:29\",\"version\":\"1.0.0\"}";
        Gson gson = new Gson();
        HashMap<String, String> map;
        try {
            map = gson.fromJson(params, HashMap.class);
            String sign = map.get("sign");
            map.remove("sign");
            Map<String, String> sortedMap = new TreeMap<String, String>();
            for (Map.Entry<String, String> en : map.entrySet()) {
                sortedMap.put(en.getKey(), en.getValue());
            }
            String bizContent = MD5Utils.getSignContent(sortedMap);
            System.out.println("bizContent="+bizContent);
            bizContent = map.get("biz_content");
            String content = RSAUtils.decryptInPub(bizContent, PUB_KEY);
            System.out.println("解密后数据="+content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
