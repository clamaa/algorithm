package com.clamaa.algorithm.simple.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 说有一数组int[]{1,2,2,4,6,8,9,5,3,7,5}，里面可能还有很多，想要知道”两两相加等于10“的这样的数有几对，可以重复如：2+6，6+2
 * User: mazhqa
 * Date: 14-3-31
 */
public class SumPossible {


    public List<SumPossibleBean> checkSumPossible(List<Integer> intList, int sumResult) {
        List<SumPossibleBean> result = new ArrayList<SumPossibleBean>();
        int size = intList.size();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (intList.get(i).intValue() + intList.get(j).intValue() == sumResult) {
                    SumPossibleBean sumPossibleBean = new SumPossibleBean();
                    sumPossibleBean.setFirst(intList.get(i).intValue());
                    sumPossibleBean.setSecond(intList.get(j).intValue());
                    result.add(sumPossibleBean);
                }
            }
        }
        return result;
    }

    /**
     * 不错，两个循环嵌套，当考官问你，有没有更好的算法时，70%以上的人基本歇菜！！！
     * <p/>
     * 唉哎。。。二分来一个吗，以前在学校怎么学的？
     * @param intList
     * @param sumResult
     * @return
     */
    public List<SumPossibleBean> checkSumPossibleSearch(List<Integer> intList, int sumResult) {
        List<SumPossibleBean> result = new ArrayList<SumPossibleBean>();
        int size = intList.size();
        Collections.sort(intList);
        for (int i = 0, j = size - 1; i < j; ) {
            Integer iInt = intList.get(i);
            Integer jInt = intList.get(j);
            if ((iInt + jInt) == sumResult) {
                SumPossibleBean sumPossibleBean = new SumPossibleBean();
                sumPossibleBean.setFirst(iInt);
                sumPossibleBean.setSecond(jInt);
                i++;
                j--;
                result.add(sumPossibleBean);
            } else if ((iInt + jInt) < sumResult) {
                i++;
            } else if ((iInt + jInt) > sumResult) {
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SumPossible sumPossible = new SumPossible();
        List<Integer> intList = new ArrayList<Integer>(Arrays.asList(new Integer[]{1, 4, 5, 45, 23, 32, 13, 45, 53, 3, 4, 5}));
        sumPossible.checkSumPossibleSearch(intList, 18);
    }


    public static class SumPossibleBean {
        int first;
        int second;

        public int getFirst() {
            return first;
        }

        public void setFirst(int first) {
            this.first = first;
        }

        public int getSecond() {
            return second;
        }

        public void setSecond(int second) {
            this.second = second;
        }
    }
}
