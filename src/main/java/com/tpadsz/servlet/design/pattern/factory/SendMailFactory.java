package com.tpadsz.servlet.design.pattern.factory;

/**
 * Created by hongjian.chen on 2017/11/2.
 */
public class SendMailFactory implements Provider{
    public Sender produce() {
        return new MailSender();
    }
}
