package com.tpadsz.servlet.pattern;


/**
 * Created by hongjian.chen on 2017/11/2.
 */
public interface Collection {
     Iterator iterator();

    /*取得集合元素*/
     Object get(int i);

    /*取得集合大小*/
     int size();
}
