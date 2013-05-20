package com.clamaa.designpattern.singleton;

/**
 * User: mazhqa
 * Date: 13-5-20
 */
public class LazySingleton {

    private static LazySingleton instance = null;

    private LazySingleton(){

    }

    public synchronized static LazySingleton getInstance(){
        if(instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }
}
