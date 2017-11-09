package com.tpadsz.servlet.pattern;

/**
 * Created by hongjian.chen on 2017/11/2.
 */
public class MyCollection  implements Collection{
    public String string[] = {"A","B","C","D","E"};
    public Iterator iterator() {
        return new MyIterator(this);
    }

    public Object get(int i) {
        return string[i];
    }

    public int size() {
        return string.length;
    }
}
