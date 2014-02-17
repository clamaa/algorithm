package com.clamaa.designpattern.mediator;

/**
 * Mediator Pattern.
 * User: mazhqa
 * Date: 13-5-7
 */
public abstract class Mediator {
    public abstract void colleagueChanged(Colleague colleague);

    public static void main(String[] args){
        ConcreteMediator concreteMediator = new ConcreteMediator();
        concreteMediator.createConcreteMediator();

        Colleague1 colleague1 = new Colleague1(concreteMediator);
        concreteMediator.colleagueChanged(colleague1);
    }
}
