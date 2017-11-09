package com.tpadsz.servlet.design.pattern.observer;

import java.util.Vector;

/**
 *  Subject interface
 *  In this interface , we can only declare top 3 function, 
 *  other function we can define in an abstract class which implements
 *  this interface
 */

public interface Subject  {
      void attach(Observer o);
      void detach(Observer o);
      void sendNotify();

      Vector getState();
      void setState(String act, String str);
}