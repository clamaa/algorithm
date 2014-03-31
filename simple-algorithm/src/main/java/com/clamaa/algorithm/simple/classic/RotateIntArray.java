package com.clamaa.algorithm.simple.classic;

/**
 * User: mazhqa
 * Date: 14-3-28
 */
public class RotateIntArray {

    public int[] rotate(int[] data, int rote) {
        int temp = 0;
        int length = data.length;

        int first = 0;

        for (int i = 0; i < rote; i++) {
            temp = data[i];

            int j = i + rote;
            while (j < length) {
                data[j - rote] = data[j];
                j += rote;
            }

            if (i == 0) {
                first = j - rote;
            }
            data[j - rote] = temp;
        }

        int last = length - rote - 1;
        while (first != last + 1) {
            temp = data[last + 1];
            for (int index = last + 1; index < length - 1; index++) {
                data[index] = data[index + 1];
            }
            data[length - 1] = temp;
            first--;
        }
        return data;
    }

    public static void main(String[] args) {
        int[] data = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
//        System.out.println(new RotateIntArray().rotate(data, 5));
        System.out.println(new RotateIntArray().rotate(data, 3));
    }
}
