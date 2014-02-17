package com.clamaa.designpattern.builder;

/**
 * User: mazhqa
 * Date: 13-5-20
 */
public class Director {

    private Builder builder;

    public void construct(){
        builder = new ConcreteBuilder();
        builder.buildPart1();
        builder.buildPart2();
        builder.retrieveResult();
    }
}
