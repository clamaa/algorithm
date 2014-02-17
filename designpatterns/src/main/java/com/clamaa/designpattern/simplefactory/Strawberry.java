package com.clamaa.designpattern.simplefactory;

/**
 * User: mazhqa
 * Date: 13-5-24
 */
public class Strawberry implements Fruit {

    @Override
    public void grow() {
        System.out.println("grow strawberry");
    }

    @Override
    public void harvest() {
        System.out.println("harvest strawberry");
    }

    @Override
    public void plant() {
        System.out.println("plant strawberry");
    }
}
