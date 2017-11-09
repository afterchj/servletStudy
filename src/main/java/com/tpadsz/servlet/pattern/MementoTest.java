package com.tpadsz.servlet.pattern;

/**
 * Created by hongjian.chen on 2017/11/2.
 */
public class MementoTest {
    public static void main(String[] args) {

        Original origi = new Original("egg");

        Storage storage = new Storage(origi.createMemento());

        System.out.println("initial status：" + origi.getValue());
        origi.setValue("niu");
        System.out.println("modify status：" + origi.getValue());

        origi.restoreMemento(storage.getMemento());
        System.out.println("restore status：" + origi.getValue());
    }
}
