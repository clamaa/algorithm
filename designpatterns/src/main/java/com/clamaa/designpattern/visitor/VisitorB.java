package com.clamaa.designpattern.visitor;

/**
 * User: clamaa
 * Date: 5/6/13
 */
public class VisitorB implements Visitor {
    @Override
    public void visit(NodeA nodeA) {
        System.out.println(nodeA.operationA());
    }

    @Override
    public void visit(NodeB nodeB) {
        System.out.println(nodeB.operationB());
    }
}
