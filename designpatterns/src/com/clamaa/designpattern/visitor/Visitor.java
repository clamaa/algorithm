package com.clamaa.designpattern.visitor;

/**
 * Visitor object, use overload to static dispatch.
 * User: clamaa
 * Date: 5/6/13
 */
public interface Visitor {
    /**
     * Param type is different from other node.
     * Visitor use node as context to do actually things.
     * @param nodeA
     */
    void visit(NodeA nodeA);

    /**
     *
     * @param nodeB
     */
    void visit(NodeB nodeB);
}
