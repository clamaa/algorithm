package com.clamaa.designpattern.visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Store the nodeList, and iterator this structure.
 * Each node accept same type visitor.
 * User: clamaa
 * Date: 5/6/13
 */
public class ObjectStructure {
    private List<Node> nodeList;
    private Node node;

    public ObjectStructure(){
        nodeList = new ArrayList<Node>();
    }

    public void action(Visitor visitor){
        for (Iterator<Node> it = nodeList.iterator(); it.hasNext();){
            node = it.next();
            node.accept(visitor);
        }
    }

    public void add(Node node){
        nodeList.add(node);
    }
}
