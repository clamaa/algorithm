package com.clamaa.algorithm.sort;

/**
 * User: clamaa
 * Date: 13-4-14
 */
public class InsertSort extends AbstractSortAlgorithm<String> {

    @Override
    public void sort(String[] toSortArray) {
        int in, out;
        for(out=0; out < toSortArray.length; out++){
            String current = toSortArray[out];
            in = out;
            //to save the memory but add the complexity.
            while (in > 0 && toSortArray[in - 1].compareTo(current) >= 0){
                toSortArray[in] = toSortArray[in -1];
                in--;
            }
            toSortArray[in] =  current;
        }
    }
}
