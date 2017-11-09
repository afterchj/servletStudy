package com.tpadsz.servlet.design.pattern.abstractpatterns;

/*
 * AbstractFactory
 */
public abstract  class Room  {
    public abstract Wall makeWall();
    public abstract Door makeDoor();
}