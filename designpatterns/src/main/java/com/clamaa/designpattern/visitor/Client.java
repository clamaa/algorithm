package com.clamaa.designpattern.visitor;

/**
 * User: clamaa
 * Date: 5/6/13
 */
public class Client {
    private static ObjectStructure objectStructure;
    private static Visitor visitor;

    public static void main(String[] args){
        objectStructure = new ObjectStructure();
        objectStructure.add(new NodeA());
        objectStructure.add(new NodeB());
        visitor = new VisitorA();
        objectStructure.action(visitor);
    }
}
