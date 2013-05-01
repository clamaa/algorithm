package com.clamaa.algorithm.datastructure;

/**
 * Use array to implement priority queue.
 * User: clamaa
 * Date: 13-4-14
 */
public class JPriorityQueue<T extends Comparable<T>> {

    private int maxSize;
    private T[] queueArray;
    private int nItems;

    public JPriorityQueue(int size) {
        this.maxSize = size;
        this.queueArray = (T[]) new Object[this.maxSize];
        nItems = 0;
    }

    public void insert(T data) {
        int j;
        if (nItems == 0) {
            queueArray[0] = data;
        } else {
            for (j = nItems - 1; j >= 0; j--) {
                if (data.compareTo(queueArray[j]) > 0) {
                    queueArray[j + 1] = queueArray[j];
                } else {
                    break;
                }
            }
            queueArray[j + 1] = data;
        }
        nItems++;
    }

    public boolean isEmpty() {
        return nItems == 0;
    }

    public boolean isFull() {
        return nItems == maxSize;
    }

    public int size() {
        return nItems;
    }

    public T peekMin() {
        return queueArray[nItems - 1];
    }

    /**
     * Remove minimum element from queue.
     *
     * @return
     */
    public T removeMin() {
        return queueArray[--nItems];
    }

    public T getElementAt(int index) {
        return queueArray[index];
    }

    public T peekAtN(int n) {
        return queueArray[n];
    }

    public void removeAtN(int n) {
        for (int j = n; j < size(); j++) {
            queueArray[j] = queueArray[j + 1];
        }
        nItems--;
    }

}
