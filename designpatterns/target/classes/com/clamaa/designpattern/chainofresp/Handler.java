package com.clamaa.designpattern.chainofresp;

/**
 * User: clamaa
 * Date: 5/13/13
 */
public abstract class Handler {

    protected Handler successor;

    public abstract void handleRequest();

    public Handler getSuccessor() {
        return successor;
    }

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }
}
