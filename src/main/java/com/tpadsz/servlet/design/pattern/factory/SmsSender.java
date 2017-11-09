package com.tpadsz.servlet.design.pattern.factory;

/**
 * Created by hongjian.chen on 2017/11/2.
 */
public class SmsSender implements Sender {
    public void Send() {
        System.out.println("this is sms sender!");
    }
}
