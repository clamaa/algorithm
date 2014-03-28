package com.clamaa.algorithm.simple;

/**
 * 要求：Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb"
 * is "abc", which the length is 3.
 * For "bbbbb" the longest substring is "b", with the length of 1.
 * User: mazhqa
 * Date: 14-3-28
 */
public class LongestStringWithoutRepeat {

    int status;

    /**
     * 整形的长度为32为，字符串中a-z为26位，因此整型可以表示字符串的移位操作而不溢出
     * 利用位或操作进行合并，注意在合并前需要判断是否已经在字符串中存在
     *
     * @param a
     */
    void addToSet(char a) {
        int value = a - 'a';
        int t = 1;
        status = status | (t << value);
    }

    /**
     * 判断某个字符是否在当前status中存在
     * 利用位与操作进行判断，如果要查找的字符串已经存在于status变量中，返回true，否则false
     *
     * @param a
     * @return
     */
    boolean existOrNot(char a) {
        int value = a - 'a';
        int t = 1;
        return !((status & (t << value)) == 0);
    }

    /**
     * 注意一点就是，在字符串匹配过程中指针回溯问题：遇到重复字符后，左指针如果只前移1步然后继续下一轮判断，这样会产生不必要的比较。
     * 比较好的一个方案是当遇到重复字符后，将左指针移到重复字符的后面。如”abcdcabc“，遇到第二'c'时发现重复时，将左指针移到第一个‘c'后的位置。然后下一轮从那开始判断。
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubString(String s) {
        int n = s.length();
        if (n == 0 || n == 1) {
            return n;
        }
        int i = 0;
        int j = 0;
        int maxLength = 0;
        while (i < n) {
            status = 0;
            j = i;
            while (j < n) {
                if (!existOrNot(s.charAt(j))) {
                    //不存在冲突，加入到当前状态表中，并判断是否已经超出最大长度
                    addToSet(s.charAt(j));
                    if (j - i + 1 > maxLength) {
                        maxLength = j - i + 1;
                    }
                    j++;
                } else {
                    //进行回溯，退回到最后一个与前一个字符冲突的地址
                    while (s.charAt(i) != s.charAt(j)) {
                        i++;
                    }
                    i++;
                    break;
                }
            }
            if (j == n) {
                break;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestStringWithoutRepeat demo = new LongestStringWithoutRepeat();
        System.out.println(demo.lengthOfLongestSubString("abcabcbb"));
    }

}
