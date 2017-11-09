package com.tpadsz.servlet.design.pattern.singleton;

/**
 *  A real Singleton we want to have
 *  imp
 */
public class SubSingletonB extends SingletonB {
    public static boolean instanceFlag = false; //true if 1 instance
    //private int i = 0;
    
    public SubSingletonB() {
        if(instanceFlag) {
           return;
        } else {
            instanceFlag = true;
            super.Register("Sub1", this);
        }
    }
    
    public void finalize() {
        instanceFlag = false;
    }
}