package com.sunrise.leetcode.easy;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * @description: 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * <p>
 * eg:  输入: 123
 * 输出: 321
 * @date: 2019/5/22 18:35
 * @auther: sunrise
 * @Gmail: liu575563079@gmail.com
 */
public class IntReverseSolution {

    //转换为字符串处理，这样不太好，没有体现数字处理时的位数的变化
    public static int reverse(int x) {

        if (x == 0) {
            return x;
        }
        StringBuilder value = new StringBuilder(String.valueOf(x));
        try {
            if (value.charAt(0) == '-') {
                value = new StringBuilder(value.subSequence(1, value.length()));
                value.reverse();
                return Integer.valueOf(value.insert(0, '-').toString());

            } else {
                //正数
                StringBuilder reverse = value.reverse();

                if (reverse.charAt(0) == '0') {
                    return Integer.valueOf(reverse.substring(1, reverse.length()));

                } else {
                    return Integer.valueOf(reverse.toString());
                }

            }
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    // 利用进制来反转数字
    public static int reverseInt(int x) {
        int res = 0;
        while (x != 0) {
            int tail = x % 10;   //求的小数位
            int newRes = res * 10 + tail; // 当res=0时，还是最小位数
            //这个判断是：
            if ((newRes - tail) / 10 != res)
                return 0;
            res = newRes;
            x /= 10;
        }
        return res;
    }


    public static int reverseInt2(int x) {
        int result = 0;

        while (x != 0) {
            // x % 10 可以取到 x 最后一位的值，即此时 pop 是 x 的最后一位，也就是新值的第一位
            int pop = x % 10;
            // x 的位数少了最后一位
            x = x / 10;

            // 由于后续运算 result = result * 10 + pop
            // 如果 result 的值大于 Integer.MAX_VALUE / 10 ，那么一定会溢出
            // 如果 result 的值等于 Integer.MAX_VALUE / 10，那么 pop 的值如果大于 Integer.MAX_VALUE % 10 也会溢出
            // 相反的，result 的值小于 Integer.MIN_VALUE / 10 ，那么一定会溢出
            // 如果 result 的值等于 Integer.MIN_VALUE / 10，那么 pop 的值如果小于于 Integer.MIN_VALUE % 10 也会溢出

            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)) {
                result = 0;
                return result;
            } else if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pop < Integer.MIN_VALUE % 10)) {
                result = 0;
                return result;
            }

            result = result * 10 + pop;
        }
        return result;

    }


    public static void main(String[] args) {
//        int[] nums = new int[]{123, -2345, 340, 0, -10, -1220};
//        for (int i : nums) {
//            //System.out.println(i + "----reverse---->: " + reverse(i));
//
//            System.out.println(i + "----reverse---->: " + reverseInt2(i));
//
//
//        }


        System.out.println(reverseInt2(-2147483412));
        System.out.println(2143847412);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        // -2143847412
        //int x = 1534236469;
        //reverse(x);

    }
}
