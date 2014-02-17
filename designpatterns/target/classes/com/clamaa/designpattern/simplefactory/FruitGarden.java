package com.clamaa.designpattern.simplefactory;

/**
 * User: mazhqa
 * Date: 13-5-24
 */
public class FruitGarden {

    public static Fruit factory(String which) throws BadFruitException {
        if (which.equalsIgnoreCase("apple")) {
            return new Apple();
        } else if (which.equalsIgnoreCase("strawberry")) {
            return new Strawberry();
        } else {
            throw new BadFruitException("Bad Fruit Request!");
        }
    }
}
