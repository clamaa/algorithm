package com.clamaa.designpattern.adapter;

/**
 * User: mazhqa
 * Date: 13-5-20
 */
public class Adapter implements Target {

    private Source source;

    public Adapter(Source source){
        this.source = source;
    }

    @Override
    public void targetOperation() {
        source.sourceOperation();
    }
}
