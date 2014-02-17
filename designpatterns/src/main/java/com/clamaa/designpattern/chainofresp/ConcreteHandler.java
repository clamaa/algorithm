package com.clamaa.designpattern.chainofresp;

/**
 * User: clamaa
 * Date: 5/13/13
 */
public class ConcreteHandler extends Handler {
    @Override
    public void handleRequest() {
        if (getSuccessor() != null) {
            System.out.println(String.format("The request is passed to %s", getSuccessor()));
        } else {
            System.out.println("The request is handled here");
        }
    }

}
