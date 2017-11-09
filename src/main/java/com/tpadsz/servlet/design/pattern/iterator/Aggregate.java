package com.tpadsz.servlet.design.pattern.iterator;

/**
 *  The interface to create concrete iterator
 *  When create iterator, we can use Factory Method pattern
 */
public interface Aggregate  {
     Iterator CreateIterator();
}