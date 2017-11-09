package com.tpadsz.servlet.design.pattern.mediator;

/**
 *  An abstract Mediator
 */
public interface Mediator  {
    public void Register(Colleague c, String type);
    public void Changed(String type);
}