package com.sunrise.leetcode.code.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * @description: 217. 存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 * <p>
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 * @date: 2019/5/29 12:37
 * @auther: sunrise
 * @Gmail: liu575563079@gmail.com
 */
public class ContainsDuplicateSolution {

    //暴力破解，不怎么合格。超出了时间限制
    public static boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    //先排序，然后相邻比较
    public static boolean containDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;

    }

    //利用HashSet去重后，算数量
    public static boolean containDuplicate3(int[] nums) {
        /**
         * HashSet setNum = new HashSet();
         *         int len =nums.length;
         *         for (int i=0;i<len;i++){
         *             if (setNum.add(nums[i])==false){
         *                 return true;
         *             }
         *         }
         *         return false;
         */
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i : nums) {
            hashSet.add(i);
        }
        return nums.length != hashSet.size() ? true : false;

    }


    //高手的解答
    //从左往右，然后从右往左遍历已经遍历的数组部分，判断
    public static boolean containDuplicate4(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {//与之前出现过的比
                if (nums[i] > nums[j]) {
                    break;
                } else if (nums[i] == nums[j]) {
                    return true;
                }
            }

        }
        return false;

    }

    public static void main(String[] args) {
        int[] ints = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        int[] ints1 = new int[]{1, 3};
        System.out.println(containsDuplicate(ints));
        System.out.println(containsDuplicate(ints1));

        System.out.println(containDuplicate3(ints));
        System.out.println(containDuplicate3(ints1));
    }
}
