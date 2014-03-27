package com.clamaa.algorithm.simple;

/**
 * 一个序列里的数字都是成对的，只有一个是单个的，找出来。
 * <p/>
 * 1，异或操作^是很特殊的。自己和自己异或，结果会得到全0；和全0异或，结果不变；和全1异或，结果会得到自己的取反。
 * <p/>
 * 2，利用这个特点。将序列的所有元素异或起来。成对的元素会异或得到0，单个的那个元素就会保留着。
 * <p/>
 * User: mazhqa
 * Date: 14-3-27
 */
public class XOROperation {

    private static final int[] intArray = new int[]{12, 56, 34, 66, 34, 12, 66};

    public static void main(String[] args) {
        int a = -10;
        System.out.println(~a + 1);

        int result = 0;
        for (int i : intArray) {
            result = result ^ i;
        }
        System.out.println(result);

        swap(10, 20);
    }

    /**
     * 通过按位异或运算，可以实现两个值的交换，而不必使用临时变量。例如交换两个整数a，b的值，可通过下列语句实现
     *
     * @param a
     * @param b
     */
    public static void swap(int a, int b) {
        System.out.println(String.format("origin a=%s, origin b=%s", a, b));
        a = a ^ b;
        b = b ^ a;
        a = a ^ b;
        System.out.println(String.format("changed a=%s, changed b=%s", a, b));
    }

}
