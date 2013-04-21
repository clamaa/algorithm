package com.clamaa.algorithm.sort;

/**
 * User: clamaa
 * Date: 4/21/13
 */
public class ShellSort<T extends Comparable> extends AbstractSortAlgorithm<T> {

    @Override
    public void sort(T[] toSortArray) {
        int nElements = toSortArray.length;
        int inner, outer;
        T temp;

        int interval = 1;
        while (interval <= nElements / 3) {
            interval = interval * 3 + 1;
        }

        while (interval > 0) {
            for (outer = interval; outer < nElements; outer++) {
                temp = toSortArray[outer];
                inner = outer;
                while (inner > interval - 1 && toSortArray[inner - interval].compareTo(temp) >= 0) {
                    toSortArray[inner] = toSortArray[inner - interval];
                    inner = inner - interval;
                }
                toSortArray[inner] = temp;
            }
            interval = (interval - 1) / 3;
        }
    }
}
