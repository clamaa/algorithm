package com.clamaa.designpattern.mediator;

/**
 * User: mazhqa
 * Date: 13-5-7
 */
public abstract class Colleague {
    private Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public Mediator getMediator() {
        return mediator;
    }

    /**
     * Action method, implemented by subclass.
     */
    public abstract void action();

    public void change(){
        mediator.colleagueChanged(this);
    }
}
