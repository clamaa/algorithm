package com.clamaa.designpattern.mediator;

/**
 * User: mazhqa
 * Date: 13-5-7
 */
public class Colleague1 extends Colleague {

    public Colleague1(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void action() {
        System.out.println("This is an action from Colleague1 !");
    }
}
