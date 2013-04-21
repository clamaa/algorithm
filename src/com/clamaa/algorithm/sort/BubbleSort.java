package com.clamaa.algorithm.sort;

/**
 * Created with IntelliJ IDEA.
 * User: clamaa
 * Date: 13-4-14
 * Time: 下午4:35
 * To change this template use File | Settings | File Templates.
 */
public class BubbleSort extends AbstractSortAlgorithm<String> {

    @Override
    public void sort(String[] toSortArray) {
        int out, in;
        int elementsLength = toSortArray.length;
        for (out = elementsLength - 1; out > 1; out--) {
            for (in = 0; in < out; in++) {
                if (toSortArray[in].compareTo(toSortArray[in + 1]) > 0) {
                    swap(toSortArray, in, in + 1);
                }
            }
        }
    }
}
