package com.clamaa.designpattern.decorator;

/**
 * User: mazhqa
 * Date: 13-5-20
 */
public class Decorator implements Component {

    private Component component;

    public Decorator(Component component){
        this.component = component;
    }

    @Override
    public void sampleOperation() {
        component.sampleOperation();
//        this.sampleOperation();
    }
}
