package com.clamaa.algorithm.simple;

import java.util.Arrays;
import java.util.List;

/**
 * 题目：数组的n个数值代表n个高度各异的垂线段。以x轴作为底座，选2个垂线段作为高。形成一个三面的容器。求储水量最大的那个。
 * User: mazhqa
 * Date: 14-3-28
 */
public class ContainerWithMostWater {

    /**
     * 方法：容器的储水量与底座长度成正比，与两边高的较小值成正比。
     * <p/>
     * 如果使用双循环依次选取两个高进行判断，时间复杂度太高。O(n*n)。
     * <p/>
     * 较好的方法是左右端双指针向中间接近。因为要找的是储水量最大值，所以首先让底座是最大值。怎么对两边的高度进行择优选择呢？首先要知道，左右端双指针向中间移动会使得底座长度变小，但可能会使得两边高的增大。
     * <p/>
     * 根据木桶原理，增加高度较高一边的高度不会增加容器的储水量，应该设法改善高度较低一遍的高度。因此，指针移动的规则应该是，尝试性的改变高度较低一边指针的位置。即，如果左指针所在的高度较低，则将左指针向右移动一格。反之，有指针所在的高度较低，则将右指针向左移动一格。这样的择优策略可以避免判断那些根本不可能是最大值的情况，更快的选出结果。
     *
     * @param height
     * @return
     */
    public int maxArea(List<Integer> height) {
        int right = height.size() - 1;
        int left = 0;
        int max = 0;
        int temp;
        while (left < right) {
            temp = min(height.get(left), height.get(right)) * (right - left);
            if (temp > max) {
                max = temp;
            }

            if (height.get(left) < height.get(right)) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    private int min(int a, int b) {
        return a > b ? b : a;
    }

    public static void main(String[] args) {
        ContainerWithMostWater demo = new ContainerWithMostWater();
        System.out.print(demo.maxArea(Arrays.asList(4, 5, 9, 7, 10, 2, 8)));
    }
}
