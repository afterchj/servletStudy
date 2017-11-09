package com.tpadsz.servlet.design.pattern.flyweight;

/**
 *  A FlyWeight
 */
public interface Font  {
    public abstract void SetFont(String color, int size);
    public abstract void GetFont();
}