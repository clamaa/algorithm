package com.clamaa.algorithm.simple;

/**
 * User: mazhqa
 * Date: 14-3-27
 */
public class BitCalculate {

    /**
     * 位运算实现加法,
     * 位的异或运算跟求'和'的结果一致：
     * <p/>
     * 异或 1^1=0 1^0=1 0^0=0
     * <p/>
     * 求和 1+1=0 1+0=1 0+0=0
     * <p/>
     * 位的与运算跟求'进位‘的结果一致：
     * <p/>
     * 位与 1&1=1 1&0=0 0&0=1
     * <p/>
     * 进位 1+1=1 1+0=0 0+0=1
     *
     * @param a
     * @param b
     * @return
     */
    public static int add(int a, int b) {
        if (b == 0) {
            return a;
        }
        int s = a ^ b;
        int c = (a & b) << 1;
        return add(s, c);
    }

    public static int addNonRecursive(int a, int b) {
        int s, c;
        while (b != 0) {
            s = a ^ b;
            c = (a & b) >> 1;
            a = s;
            b = c;
        }
        return a;
    }

    /**
     * 求一个数的负的操作是将其连符号位一起取反然后加1
     *
     * @param a
     * @return
     */
    public static int negative(int a) {
        return add(~a, 1);
    }

    /**
     * 减法其实是用加法来实现的。在ALU中，当我求a-b，其实是求[a-b]补。因为有[a-b]补=[a]补 - [b]补= [a]补+[-b]补。所以我就要先求出-b。求一个数的负的操作是将其连符号位一起取反然后加1。
     * 于是有办法做减法了：先把减数求负，然后做加法。
     *
     * @param a
     * @param b
     * @return
     */
    public static int substraction(int a, int b) {
        return add(a, negative(b));
    }

    /**
     * 取一个数的符号，看是正还是负
     *
     * @param a
     * @return
     */
    public static boolean getSign(int a) {
        return (a >> 31) == 0;
    }

    /**
     * 将一个数变为正数，如果本来就是正，则不变；如果是负，则变为相反数。注意对于-2147483648，求负会溢出。
     *
     * @param a
     * @return
     */
    public static int bePositive(int a) {
        if (getSign(a)) {
            return a;
        } else {
            return negative(a);
        }
    }

    /**
     * 做乘法的第一种思路：
     * <p/>
     * 很直观，就是用循环加法替代乘法。a*b，就是把a累加b次。时间复杂度为O(N)。
     *
     * @param a
     * @param b
     * @return
     */
    public static int multiply(int a, int b) {
        boolean flag = (getSign(a) != getSign(b));
        a = bePositive(a);
        b = bePositive(b);
        int ans = 0;
        while (b != 0) {
            ans = add(ans, a);
            b = substraction(b, 1);
        }
        if (flag) {
            ans = negative(ans);
        }
        return ans;
    }

//    public static int multiply_2(int a, int b) {
//        boolean flag = (getSign(a) != getSign(b));
//        a = bePositive(a);
//        b = bePositive(b);
//        int ans = 0;
//        while (b != 0) {
//            if (b & 1) {
//
//            }
//            a = (a << 1); //把a错位加在积上
//            b = (b >> 1); //从最低位开始依次判断b的每一位
//        }
//
//
//    }

    /**
     * 也比较直观，从被除数上减去除数，看能减多少次之后变得不够减。时间复杂度为O(N)。
     * @param a
     * @param b
     * @return
     */
    public static int division(int a, int b){
        if(b == 0){
            return 0;
        }
        boolean flag = (getSign(a) != getSign(b));
        a = bePositive(a);
        b = bePositive(b);

        int n = 0;
        a = substraction(a, b);
        while (a >= 0){
            n = add(n, 1);
            a = substraction(a, b);
        }
        if(flag){
            return negative(n);
        }
        return n;
    }

    public static void main(String[] args) {
        int a = 13;
        int b = -234;
        System.out.println(String.format("a = %s, b = %s, a + b = %s", a, b, BitCalculate.add(a, b)));
        System.out.println(String.format("a = %s, b = %s, a - b = %s", a, b, BitCalculate.substraction(a, b)));
        System.out.println(String.format("a = %s, b = %s, a * b = %s", a, b, BitCalculate.multiply(a, b)));
        System.out.println(String.format("a = %s, b = %s, b / a = %s", a, b, BitCalculate.division(b, a)));
    }

}
