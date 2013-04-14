package com.clamaa.algorithm.sort;

/**
 * User: clamaa
 * Date: 13-4-14
 */
public abstract class AbstractSortAlgorithm<T> implements ISortAlgorithm<T> {

    protected void swap(String[] array, int m, int n) {
        String mString = array[m];
        String nString = array[n];
        array[m] = nString;
        array[n] = mString;
    }

}
