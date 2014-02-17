package com.clamaa.designpattern.singleton;

/**
 * User: mazhqa
 * Date: 13-5-20
 */
public class EagerSingleton {

    private static final EagerSingleton m_instance = new EagerSingleton();

    private EagerSingleton(){

    }

    public static EagerSingleton getInstance(){
        return m_instance;
    }

}
