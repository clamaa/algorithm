package com.clamaa.designpattern.visitor;

/**
 * User: clamaa
 * Date: 5/6/13
 */
public class NodeB extends Node {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String operationB(){
        return "Node B is visited";
    }
}
