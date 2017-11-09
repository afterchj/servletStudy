package com.tpadsz.servlet.pattern;

/**
 * Created by hongjian.chen on 2017/11/2.
 */
public class MyIterator implements Iterator {
    private Collection collection;
    private int pos = -1;

    public MyIterator(Collection collection) {
        this.collection = collection;
    }

    public Object previous() {
        if (pos > 0) {
            pos--;
        }
        return collection.get(pos);
    }

    public Object next() {
        if (pos < collection.size() - 1) {
            pos++;
        }
        return collection.get(pos);
    }

    public boolean hasNext() {
        if (pos < collection.size() - 1) {
            return true;
        } else {
            return false;
        }
    }

    public Object first() {
        pos = 0;
        return collection.get(pos);
    }
}
