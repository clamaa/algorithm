package com.clamaa.designpattern.builder;

/**
 * User: mazhqa
 * Date: 13-5-20
 */
public class ConcreteBuilder implements Builder {

    private Product product = new Product();

    @Override
    public void buildPart1() {
        System.out.println("building product part 1.");
    }

    @Override
    public void buildPart2() {
        System.out.println("building product part 2.");
    }

    @Override
    public Product retrieveResult() {
        return product;
    }
}
