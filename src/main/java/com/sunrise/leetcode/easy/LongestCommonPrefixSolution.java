package com.sunrise.leetcode.easy;

import java.util.Arrays;

/**
 * @description:
 *               题号：14
 *              编写一个函数来查找字符串数组中的最长公共前缀。
 *              如果不存在公共前缀，返回空字符串 ""。
 *
 * eg： 输入: ["flower","flow","flight"]
 *      输出: "fl"
 * @date: 2019/5/24 11:33
 * @auther: sunrise
 * @Gmail: liu575563079@gmail.com
 */
public class LongestCommonPrefixSolution {

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length<=0){
            return "";
        }
        String minis=strs[0];
        for (int i = 1; i <strs.length ; i++) {
            if (strs[i].length()<minis.length()){
                minis = strs[i];
            }else {
                continue;
            }
        }

        //char[] chars = new char[minis.length()];
        StringBuilder stringBuilder = new StringBuilder();
        //得到最短的子字符串 minis
        for (int i = 0; i <minis.length() ; i++) {
            char index=minis.charAt(i);

            for (String s:strs){
                if (s.charAt(i)!=index){
                    return String.valueOf(stringBuilder);
                }
            }
            stringBuilder.append(index);
            //chars[i] = index;
        }

        //返回子串
        return String.valueOf(stringBuilder);
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight",""}));

        char[] chars = new char[5];
        for (char c:chars){
            System.out.println((int)c);
        }
    }
}
