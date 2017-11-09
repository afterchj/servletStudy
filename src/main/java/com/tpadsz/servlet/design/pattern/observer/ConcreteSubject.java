package com.tpadsz.servlet.design.pattern.observer;

import java.util.LinkedList;
import java.util.Vector;

/**
 *  A concrete subject
 */

public class ConcreteSubject implements Subject {
    private LinkedList observerList;
    private Vector strVector;
    
    public ConcreteSubject() {
        observerList =  new LinkedList();
        strVector = new Vector();
    }
    public void attach(Observer o) {
        observerList.add(o);
    }


    public void detach(Observer observer) {

    }

    public void sendNotify() {
        for(int i = 0; i < observerList.size(); i++) {
            ((Observer)observerList.get(i)).update(this);   
        }
    }
    public void setState(String act, String str) {
        if(act.equals("ADD")) {
            strVector.add(str);
        } else if(act.equals("DEL")) {
            strVector.remove(str);
        }
    }
    public Vector getState() {
        return strVector;
    }
}