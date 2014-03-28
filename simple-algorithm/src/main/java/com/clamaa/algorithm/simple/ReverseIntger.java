package com.clamaa.algorithm.simple;

/**
 * 将一个整数逆转 Reverse Integer
 * User: mazhqa
 * Date: 14-3-28
 */
public class ReverseIntger {

    public int reverse(int x) {
        boolean negative = false;
        if (x < 0) {
            negative = true;
            x = -x;
        } else if (x > 0) {
            negative = false;
        } else {
            return x;
        }

        int i = 0;
        int[] a = new int[11];
        while (x != 0) {
            a[i++] = x % 10;
            x = x / 10;
        }
        int result = 0;
        int cost = 1;
        for (int j = i - 1; j >= 0; j--) {
            result += a[j] * cost;
            cost *= 10;
        }
        return negative ? -result : result;
    }

    public static void main(String[] args) {
        ReverseIntger reverseIntger = new ReverseIntger();
        System.out.println(reverseIntger.reverse(125803));
        System.out.println(reverseIntger.reverse(-921630));
    }

}
