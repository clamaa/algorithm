package com.clamaa.algorithm.sort;

import com.clamaa.algorithm.CommonAlgorithmUtil;

/**
 * User: clamaa
 * Date: 13-4-14
 */
public class SortExecutor {

    public static void main(String[] args) {
        String[] toSortArray = CommonAlgorithmUtil.getExampleArray();
        ISortAlgorithm<String> bubbleSort = new BubbleSort();
        System.out.println("To Sort Array, use bubble sort:");
        bubbleSort.sort(toSortArray);
        printArray(toSortArray);

        toSortArray = CommonAlgorithmUtil.getExampleArray();
        ISortAlgorithm<String> selectSort = new SelectSort();
        System.out.println("To Sort Array, use select sort:");
        selectSort.sort(toSortArray);
        printArray(toSortArray);

        toSortArray = CommonAlgorithmUtil.getExampleArray();
        ISortAlgorithm<String> insertSort = new InsertSort();
        System.out.println("To Sort Array, use insert sort:");
        selectSort.sort(toSortArray);
        printArray(toSortArray);
//        System.out.println(CommonAlgorithmUtil.EXAMPLE_ARRAY);
    }

    protected static void printArray(String[] array){
        System.out.println("Result:");
        for (String s : array) {
            System.out.println(s);
        }
    }

}
