package com.tpadsz.servlet.pattern;

/**
 * Created by hongjian.chen on 2017/11/2.
 */
public interface Iterator {
    //前移
     Object previous();

    //后移
     Object next();
     boolean hasNext();

    //取得第一个元素
     Object first();
}
