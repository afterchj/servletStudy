package com.tpadsz.servlet.design.pattern.visitor;

public abstract class Visitor {
    public abstract void visit(Employee emp);

    public abstract void visit(Boss emp);
}
