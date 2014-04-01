package com.clamaa.algorithm.simple.interview;

/**
 * 这道题老套了，即2角，5角，1角硬币，问有多少种组合可得到1块钱
 * User: mazhqa
 * Date: 14-3-31
 */
public class CentsCombination {

    public static void main(String[] args) {
        int total;

        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 5; j++) {
                for (int k = 0; k <= 2; k++) {
                    total = 1 * i + 2 * j + 5 * k;
                    if (total > 10) {
                        break;
                    }
                    if (total == 10) {
                        System.out.println(String.format("1 cents:%s, 2 cents:%s, 5 cents:%s", i, j, k));
                    }
                }
            }
        }
    }

}
