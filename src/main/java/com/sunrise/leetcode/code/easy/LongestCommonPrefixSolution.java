package com.sunrise.leetcode.code.easy;

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

    // 思路：
    // 找出最短的字符串
    //循环最短字符串的每一个字符，和另外的字符串的字符比较，只要有一个不一样就返回
    //否则就把字符保存
    //最后返回
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


    public static String longestCommonPrefix2(String[] strs){
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;

    }

    public static void main(String[] args) {
        //是找前串，如果是中间的串就无能为力了
        System.out.println(longestCommonPrefix(new String[]{"cflower","aflow","bflight"}));
        System.out.println(longestCommonPrefix2(new String[]{"flower","flow","flight"}));


        //数组有默认值
        char[] chars = new char[5];
        for (char c:chars){
            System.out.println((int)c);
        }
    }
}
