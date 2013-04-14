package com.clamaa.algorithm.datastructure;

import com.clamaa.algorithm.exception.ContainerIndexException;

/**
 * User: clamaa
 * Date: 13-4-14
 */
public class JQueue {

    private int maxSize;
    private long[] queueArray;
    private int front;
    private int rear;
    private int nItems;

    public JQueue(int size){
        this.maxSize = size;
        queueArray = new long[queueArray.length];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(long data) throws ContainerIndexException {
        if(isFull()){
            throw new ContainerIndexException("The queue is full!");
        }
        if(rear == maxSize - 1){
            rear = -1;
        }
        queueArray[++rear] = data;
        nItems++;
    }

    public long remove() throws ContainerIndexException {
        if(isEmpty()){
            throw new ContainerIndexException("The queue is empty!");
        }
        long result = queueArray[front++];
        if(front == maxSize){
            front = 0;
        }
        nItems--;
        return result;
    }

    public boolean isEmpty(){
        return nItems == 0;
    }

    public boolean isFull(){
        return nItems == maxSize;
    }

    public int size(){
        return nItems;
    }

}
