package com.sunrise.leetcode.easy;

/**
 * @description: 题号：35
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * eg: 输入: [1,3,5,6], 5
 * 输出: 2
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * @date: 2019/5/27 22:34
 * @auther: sunrise
 * @Gmail: liu575563079@gmail.com
 */
public class SearchInsertPositionSolution {
    // 自己的实现
    public static int searchInsert(int[] nums, int target) {
        if (target < nums[0]) return 0;
        if (target > nums[nums.length - 1]) return nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return i;
            }

            if ((i <= nums.length - 1) && (nums[i] < target) && (nums[i + 1] > target)) {
                return i + 1;
            }
        }

        return -1;
    }

    //别人优雅的实现
    public static int searchInsert2(int[] nums, int target) {
        int i;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                break;
            }
        }
        return i;

    }

    //二分法查找实现
    public static int searchInsert3(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        //使用二分查找
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start + (end - start) / 2;

    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        int target = 5;

        int[] nums2 = new int[]{1, 3, 5, 6};
        int target2 = 0;

        System.out.println(searchInsert(nums, target));
        System.out.println(searchInsert(nums2, target2));


        searchInsert2(nums2, target2);
    }
}
