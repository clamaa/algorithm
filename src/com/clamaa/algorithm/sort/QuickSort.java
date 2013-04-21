package com.clamaa.algorithm.sort;

/**
 * User: clamaa
 * Date: 4/21/13
 */
public class QuickSort<T extends Comparable> extends AbstractSortAlgorithm<T> {

    @Override
    public void sort(T[] toSortArray) {
        recursiveQuickSort(toSortArray, 0, toSortArray.length - 1);
    }

    private void recursiveQuickSort(T[] toSortArray, int left, int right){
        if(right - left <= 0){
            return;
        } else{
            T pivot = toSortArray[right];
            int partition = partitionIt(toSortArray, left, right, pivot);
            recursiveQuickSort(toSortArray, left, partition -1);
            recursiveQuickSort(toSortArray, partition+1, right);
        }
    }

    private int partitionIt(T[] toSortArray, int left, int right, T pivot){
        int leftPtr = left -1;
        int rightPtr=right;
        while (true){
            while (toSortArray[++leftPtr].compareTo(pivot) < 0){
                ;
            }
            while (rightPtr > 0 && toSortArray[--rightPtr].compareTo(pivot) > 0){
                ;
            }
            if(leftPtr>=rightPtr){
                break;
            } else {
                swap(toSortArray, leftPtr, rightPtr);
            }
        }
        swap(toSortArray, leftPtr, right);
        return leftPtr;
    }
}
