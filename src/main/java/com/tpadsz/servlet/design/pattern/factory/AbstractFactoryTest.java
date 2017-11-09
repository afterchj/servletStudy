package com.tpadsz.servlet.design.pattern.factory;

/**
 * Created by hongjian.chen on 2017/11/2.
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        Provider provider = new SendMailFactory();
        Sender sender = provider.produce();
        sender.Send();
    }
}
