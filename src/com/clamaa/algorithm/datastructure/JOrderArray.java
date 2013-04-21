package com.clamaa.algorithm.datastructure;

/**
 * User: clamaa
 * Date: 4/20/13
 */
public class JOrderArray<T extends Comparable> {

    private Object[] dataArray;
    private int nElements;

    public JOrderArray(int maxSize) {
        this.nElements = 0;
        dataArray = new Object[maxSize];
    }

    public int size() {
        return nElements;
    }

    public int find(T searchKey) {
        return recursiveFind(searchKey, 0, nElements - 1);
    }

    public int recursiveFind(T searchKey, int lowBound, int upperBound) {
        int currentIndex = (lowBound + upperBound) / 2;
        if (searchKey.equals(dataArray[currentIndex])) {
            return currentIndex;
        } else if (lowBound > upperBound) {
            return nElements;
        } else {
            if (((T) dataArray[currentIndex]).compareTo(searchKey) < 0) {
                return recursiveFind(searchKey, currentIndex + 1, upperBound);
            } else {
                return recursiveFind(searchKey, lowBound, currentIndex - 1);
            }
        }
    }

    public void insert(T data) {
        for (int i = 0; i < nElements; i++) {
            if (((T) dataArray[i]).compareTo(data) > 0) {
                break;
            }
            for (int j = nElements; j > i; j--) {
                dataArray[j] = dataArray[j - 1];
            }
            dataArray[i] = data;
            nElements++;
        }
    }

}
