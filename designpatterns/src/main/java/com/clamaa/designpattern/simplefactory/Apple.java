package com.clamaa.designpattern.simplefactory;

/**
 * User: mazhqa
 * Date: 13-5-20
 */
public class Apple implements Fruit {
    @Override
    public void grow() {
        System.out.println("grow apple");
    }

    @Override
    public void harvest() {
        System.out.println("harvest apple");
    }

    @Override
    public void plant() {
        System.out.println("plant apple");
    }
}
