package com.tpadsz.servlet.activemq;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleJMSReceiver {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("config/ApplicationContext3C.xml");
        while(true) {  
        }  
    }  
}
