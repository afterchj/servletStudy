package com.tpadsz.servlet.test;

import com.sun.org.apache.bcel.internal.generic.NEWARRAY;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hongjian.chen on 2017/10/10.
 */
public class MutilyTest {
    @Test
    public void test(){
        int num=3;
        for (;;){
            System.out.println("外循环---->"+num);
            if (num!=3){
                return;
            }
            else {
                num++;
            }
            for (int i = 0; i < 5; i++) {
                System.out.println("内循环"+i);
            }
        }
    }
}
