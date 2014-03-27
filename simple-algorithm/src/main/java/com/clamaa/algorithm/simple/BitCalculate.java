package com.clamaa.algorithm.simple;

/**
 * User: mazhqa
 * Date: 14-3-27
 */
public class BitCalculate {

    /**
     * λ����ʵ�ּӷ�,
     * λ������������'��'�Ľ��һ�£�
     * <p/>
     * ��� 1^1=0 1^0=1 0^0=0
     * <p/>
     * ��� 1+1=0 1+0=1 0+0=0
     * <p/>
     * λ�����������'��λ���Ľ��һ�£�
     * <p/>
     * λ�� 1&1=1 1&0=0 0&0=1
     * <p/>
     * ��λ 1+1=1 1+0=0 0+0=1
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
     * ��һ�����ĸ��Ĳ����ǽ���������λһ��ȡ��Ȼ���1
     *
     * @param a
     * @return
     */
    public static int negative(int a) {
        return add(~a, 1);
    }

    /**
     * ������ʵ���üӷ���ʵ�ֵġ���ALU�У�������a-b����ʵ����[a-b]������Ϊ��[a-b]��=[a]�� - [b]��= [a]��+[-b]���������Ҿ�Ҫ�����-b����һ�����ĸ��Ĳ����ǽ���������λһ��ȡ��Ȼ���1��
     * �����а취�������ˣ��ȰѼ����󸺣�Ȼ�����ӷ���
     *
     * @param a
     * @param b
     * @return
     */
    public static int substraction(int a, int b) {
        return add(a, negative(b));
    }

    /**
     * ȡһ�����ķ��ţ����������Ǹ�
     *
     * @param a
     * @return
     */
    public static boolean getSign(int a) {
        return (a >> 31) == 0;
    }

    /**
     * ��һ������Ϊ����������������������򲻱䣻����Ǹ������Ϊ�෴����ע�����-2147483648���󸺻������
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
     * ���˷��ĵ�һ��˼·��
     * <p/>
     * ��ֱ�ۣ�������ѭ���ӷ�����˷���a*b�����ǰ�a�ۼ�b�Ρ�ʱ�临�Ӷ�ΪO(N)��
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
//            a = (a << 1); //��a��λ���ڻ���
//            b = (b >> 1); //�����λ��ʼ�����ж�b��ÿһλ
//        }
//
//
//    }

    /**
     * Ҳ�Ƚ�ֱ�ۣ��ӱ������ϼ�ȥ���������ܼ����ٴ�֮���ò�������ʱ�临�Ӷ�ΪO(N)��
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
