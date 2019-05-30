package com.sunrise.leetcode.code.easy;

import java.util.Arrays;

/**
 * @description: 题号：
 * 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * @date: 2019/5/30 14:53
 * @auther: sunrise
 * @Gmail: liu575563079@gmail.com
 */
public class SingleNumberSolution {
    //排序后 每两个两个比较
    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length - 1;

        int i = 0;
        while (i <= length) {
            if ((i <= length - 2) && (nums[i] == nums[i + 1])) {
                i += 2;

            } else {
                return nums[i];
            }

        }
        return -1;
    }


    //高手解答： 异或的使用
    //原理：
    //交换律：a ^ b ^ c <=> a ^ c ^ b
    //
    //任何数于0异或为任何数 0 ^ n => n
    //
    //相同的数异或为0: n ^ n => 0
    //
    //var a = [2,3,2,4,4]
    //
    //2 ^ 3 ^ 2 ^ 4 ^ 4等价于 2 ^ 2 ^ 4 ^ 4 ^ 3 => 0 ^ 0 ^3 => 3
    public static int singleNumber2(int[] nums) {
        int result = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            result = result ^ nums[i];
        }
        return result;

    }


    public static void main(String[] args) {
        int[] ints = new int[]{4, 1, 2, 1, 2};
//        11224
        System.out.println(singleNumber(ints));
    }
}
