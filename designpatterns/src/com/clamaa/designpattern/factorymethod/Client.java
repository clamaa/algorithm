package com.clamaa.designpattern.factorymethod;

/**
 * User: mazhqa
 * Date: 13-5-24
 */
public class Client {

    public static void main(String[] args){
        Creator creator = new ConcreteCreator();
        Product product = creator.createProduct();
    }

}
