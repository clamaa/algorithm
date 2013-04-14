package com.clamaa.algorithm.exception;

/**
 * User: clamaa
 * Date: 13-4-14
 */
public class ContainerIndexException extends Exception {

    public ContainerIndexException(String message){
        super(message);
    }

    public ContainerIndexException(String message, Exception e){
        super(message, e);
    }

}
