package com.sunrise.leetcode.easy;

/**
 * @description:
 *               题号： 9
 *              判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 *              eg： 输入: 121
 *                  输出: true
 * @date: 2019/5/23 17:13
 * @auther: sunrise
 * @Gmail: liu575563079@gmail.com
 */
public class NumberOfTractsSolution {

    //将其作为字符串处理，只要反转判断和原来是否相同
    public static boolean isPalindrome(int x) {
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(x));
        String substring = stringBuilder.substring(0);
        String builder = stringBuilder.reverse().toString();
        if (builder.equals(substring)) {
            return true;
        }
        return false;
    }

    //不使用字符串的形式处理
    public static boolean isPalindrome2(int x) {
        // 负数肯定不是，以及首尾不对称的非0数
        if (x < 0 || (x % 10 == 0 && x != 0))
            return false;

        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10; //将低位一半的数取反。
            x = x / 10;
            System.out.println("recv= "+rev+"  x= "+x);
        }
        //有rev >= x， 奇数情况下需要除去10
        return x == rev || x == (rev / 10);

    }

    //不使用字符串的形式处理2
    public static boolean isPalindrome3(int x) {
        if (x < 0) return false;
        int div = 1;
        while (x / div >= 10) {
            div *= 10;
        }
        while (x != 0) {
            int l = x / div;
            int r = x % 10;
            if (l != r) return false;
            x = (x % div) / 10;  //去掉两边的数
            div /= 100;
        }
        return true;
    }


    public static void main(String[] args) {
        int x = 121;
        System.out.println(isPalindrome(x));
        System.out.println(isPalindrome2(x));
        System.out.println(isPalindrome3(x));
    }

}
