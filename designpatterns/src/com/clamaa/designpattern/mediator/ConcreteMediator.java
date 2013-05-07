package com.clamaa.designpattern.mediator;

/**
 * User: mazhqa
 * Date: 13-5-7
 */
public class ConcreteMediator extends Mediator {

    private Colleague1 colleague1;
    private Colleague2 colleague2;

    @Override
    public void colleagueChanged(Colleague colleague) {
        colleague1.action();
        colleague2.action();
    }

    public void createConcreteMediator(){
        colleague1 = new Colleague1(this);
        colleague2 = new Colleague2(this);
    }

    public Colleague2 getColleague2() {
        return colleague2;
    }

    public Colleague1 getColleague1() {
        return colleague1;
    }
}
