package com.tpadsz.servlet.pattern;

/**
 * Created by hongjian.chen on 2017/11/2.
 */
public class MyHandler extends AbstractHandler implements Handler {
    private String name;

    public MyHandler(String name) {
        this.name = name;
    }

    public void operator() {
        System.out.println(name + "deal!");
        System.out.println("----------------------");
        if (getHandler() != null) {
            getHandler().operator();
        }
    }
}
