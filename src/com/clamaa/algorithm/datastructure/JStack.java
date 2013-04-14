package com.clamaa.algorithm.datastructure;

import com.clamaa.algorithm.exception.ContainerIndexException;

/**
 * User: clamaa
 * Date: 13-4-14
 */
public class JStack {
    private int stackSize;
    private long[] stackArray;
    private int top;

    public JStack(int size){
        this.stackSize = size;
        this.stackArray = new long[this.stackSize];
        this.top = -1;
    }

    public boolean isEmpty(){
        return this.top == -1;
    }

    public boolean isFull(){
        return this.top == stackSize - 1;
    }

    public void push(long data) throws ContainerIndexException {
        if(!isFull()){
            stackArray[++top] = data;
        }
        throw new ContainerIndexException("The stack is full!");
    }

    public long pop() throws ContainerIndexException {
        if(!isEmpty()){
            return stackArray[top--];
        }
        throw new ContainerIndexException("The stack is empty!");
    }



}
