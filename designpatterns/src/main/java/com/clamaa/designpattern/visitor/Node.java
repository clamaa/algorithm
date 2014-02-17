package com.clamaa.designpattern.visitor;

/**
 * User: clamaa
 * Date: 5/6/13
 */
public abstract class Node {

    /**
     * Double dispatch to implement visitor mode.
     * @param visitor
     */
    public abstract void accept(Visitor visitor);
}
