package com.tpadsz.servlet.design.pattern.prototype.mypackage;/*
 * A Graphic Interface ( A prototype interface )
 */
import java.io.*;

public interface IGraphic extends Cloneable, Serializable {
     String getName() ;
     void setName(String gName);
}