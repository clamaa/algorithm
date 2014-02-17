package com.clamaa.designpattern.visitor;

/**
 * User: clamaa
 * Date: 5/6/13
 */
public class NodeA extends Node {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String operationA(){
        return "Node A is visited";
    }
}
