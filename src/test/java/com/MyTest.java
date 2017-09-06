package com;


import java.util.Random;
import java.util.UUID;

/**
 * Created by hongjian.chen on 2017/8/4.
 */
public class MyTest {
    public static void test() {
        Random random=new Random();
        for (int i=0;i<10;i++){
            System.out.println(random.nextInt(10));
        }
    }

    public static void main(String[] args) {
        System.out.println("uuid="+ UUID.randomUUID().toString().replaceAll("-",""));
        String str="time:2017-08-4 12:12:21|method:test|context:hello world";
        String[] strs=str.trim().split("\\|");
        for (String txt:strs){
            System.out.println("txt="+txt);
        }
//        test();
    }
}
