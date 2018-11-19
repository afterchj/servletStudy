package com.tpadsz.servlet.utils;

/**
 * Created by hongjian.chen on 2018/11/19.
 */
public enum CommonParam {
    APPURL("https://eco.taobao.com/router/rest"), APPKER("25208405"), APPSECRET("d0a228c9cca6bd42a9e0ecd537db0ad1");
    private String value;

    CommonParam(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static void main(String[] args) {
        for (CommonParam param : CommonParam.values()) {
            System.out.println(param.value);
        }
    }
}
