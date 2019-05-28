package com.sunrise.leetcode.code.easy;

/**
 * @description: 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 题号：27
 * 示例 1:
 * <p>
 * 给定 nums = [3,2,2,3], val = 3,
 * <p>
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * <p>
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 * <p>
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * <p>
 * 注意这五个元素可为任意顺序。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * @date: 2019/5/28 21:33
 * @auther: sunrise
 * @Gmail: liu575563079@gmail.com
 */
public class RemoveElementSolution {
    public static int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (val == nums[i]) {
                nums[i] = -1;
                count++;
                continue;
            }
        }

        //交换数组元素
        for (int i = 0; i < nums.length - count; i++) {
            if (nums[i] == -1) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != -1) {
                        nums[i] = nums[j];
                        nums[j] = -1;
                        break;
                    }
                }
                continue;
            }
        }

        return nums.length - count;
    }

    //leetcode 方法
    public static int removeElement2(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;

    }


    public static void main(String[] args) {
        int[] ints = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        int c = removeElement(ints, val);
//        System.out.println(c);
        for (int j = 0; j < c; j++) {
            System.out.println(ints[j]);
        }
    }
}
