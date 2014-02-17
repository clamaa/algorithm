package com.clamaa.designpattern.builder;

/**
 * User: mazhqa
 * Date: 13-5-20
 */
public interface Builder {
    void buildPart1();

    void buildPart2();

    Product retrieveResult();
}
