package com.tpadsz.servlet.design.pattern.bridge;

/**
 *  The ConcreteImplementor
 */
public class TextImpLinux implements TextImp {
    public TextImpLinux() {
    }
    public void DrawTextImp() {
        System.out.println("The text has a Linux style !");
    }
}