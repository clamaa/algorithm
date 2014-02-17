package com.clamaa.designpattern.factorymethod;

/**
 * User: mazhqa
 * Date: 13-5-24
 */
public class ConcreteCreator implements Creator {
    @Override
    public Product createProduct() {
        return new ConcreteProduct();
    }
}
