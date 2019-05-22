package com.sunrise.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * @date: 2019/5/22 00:45
 * @auther: sunrise
 * @Gmail: liu575563079@gmail.com
 */
public class TwoSumSolution {
    //  双重循环，但是因为不能重复利用元素，所以ij 不能同时取一个相同的值
    public static int[] twosum(int[] nums, int target) {
        for (int i = 0; i <= nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    //suck method
    public static int[] twosumSet(int[] nums, int target) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(i,nums[i]);
        }
        for (Map.Entry<Integer,Integer> entry:hashMap.entrySet()){
            int i = target-entry.getValue();
            for (Map.Entry<Integer,Integer> entrys:hashMap.entrySet()){
                if (entry.getKey()!=entrys.getKey()){
                    if (entrys.getValue()==i){
                        return new int[]{entry.getKey(),entrys.getKey()};
                    }
                }

            }

        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 13;

        int[] nums2 = new int[]{3, 2, 4};
        int target2 = 6;

        int[] twosum = twosum(nums2, target2);
        for (int num : twosum) {
            System.out.println(num);

        }


        //map
        int[] twosumSet = twosumSet(nums2, target2);
        for (int num : twosumSet) {
            System.out.println(num);

        }


    }
}
