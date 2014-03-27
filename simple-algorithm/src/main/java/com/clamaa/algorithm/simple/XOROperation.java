package com.clamaa.algorithm.simple;

/**
 * һ������������ֶ��ǳɶԵģ�ֻ��һ���ǵ����ģ��ҳ�����
 * <p/>
 * 1��������^�Ǻ�����ġ��Լ����Լ���򣬽����õ�ȫ0����ȫ0��򣬽�����䣻��ȫ1��򣬽����õ��Լ���ȡ����
 * <p/>
 * 2����������ص㡣�����е�����Ԫ������������ɶԵ�Ԫ�ػ����õ�0���������Ǹ�Ԫ�ؾͻᱣ���š�
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
     * ͨ����λ������㣬����ʵ������ֵ�Ľ�����������ʹ����ʱ���������罻����������a��b��ֵ����ͨ���������ʵ��
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
