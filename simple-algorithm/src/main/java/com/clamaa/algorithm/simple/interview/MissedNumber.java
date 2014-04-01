package com.clamaa.algorithm.simple.interview;

/**
 * 简单吧，数组内的数的总和减去（（数组长度+1）*数组长度/2），即为missed number
 * User: mazhqa
 * Date: 14-3-31
 */
public class MissedNumber {

    /**
     * 上次有朋友在美国去yahoo面试，说一道题把它给整了，题目如下：
     * <p/>
     * 说有一数组如 int[]{0,1,2} 这样的一个数组，这个数组的第一个必须从0开始，以次+1列出，该数组内最后一个数是这个数组的长度，因此：
     * <p/>
     * int[]{1,2}, missed number为0
     * <p/>
     * int[]{0,1,2}, missed number为3
     * <p/>
     * int[]{0,2}, missed number为1
     * <p/>
     * 我朋友和我说这看上去有点像等差数列，我当时就在MSN里和他说：等差数你个头啊！
     * <p/>
     * 然后我朋友说，他用了两个循环嵌套也搞不定
     * <p/>
     * 我和他说：两个循环你个头啊
     * <p/>
     * 他在MSN上又要和我说什么，我还没等他把它打出来直接就是”你个头啊“回过去了。
     *
     * @param numArray
     * @return
     */
    public int findMissedOne(int[] numArray) {
        int sum = 0;

        for (int i = 0; i < numArray.length; i++) {
            sum += numArray[i];
        }

        int total = numArray.length * (numArray.length + 1) / 2;
        return total - sum;
    }

    public static void main(String[] args) {
        int[] testArray = {0, 1, 3, 4, 5};
        int missedNumber = new MissedNumber().findMissedOne(testArray);
        System.out.println(missedNumber);
    }
}
