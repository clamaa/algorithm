package com.clamaa.algorithm.sort;

/**
 * User: clamaa
 * Date: 13-4-14
 */
public abstract class AbstractSortAlgorithm<T> implements ISortAlgorithm<T> {

    protected void swap(T[] array, int m, int n) {
        T mString = array[m];
        T nString = array[n];
        array[m] = nString;
        array[n] = mString;
    }

}
