package com.clamaa.algorithm.datastructure;

/**
 * Use array to implement priority queue.
 * User: clamaa
 * Date: 13-4-14
 */
public class JPriorityQueue {

    private int maxSize;
    private long[] queueArray;
    private int nItems;

    public JPriorityQueue(int size){
        this.maxSize = size;
        this.queueArray = new long[this.maxSize];
        nItems = 0;
    }

    public void insert(long data){
        int j;
        if(nItems == 0){
            queueArray[0] = data;
        } else {
            for (j = nItems - 1; j >=0; j--){
                if(data > queueArray[j]){
                    queueArray[j+1] = queueArray[j];
                } else {
                    break;
                }
            }
            queueArray[j+1] = data;
        }
        nItems++;
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

    public long peekMin(){
        return queueArray[nItems - 1];
    }

    public long remove(){
        return queueArray[--nItems];
    }

}
