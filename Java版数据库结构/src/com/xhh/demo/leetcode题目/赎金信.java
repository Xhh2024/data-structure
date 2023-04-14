package com.xhh.demo.leetcode题目;

/**
 * 赎金信中字符串匹配问题: https://leetcode.cn/problems/ransom-note/
 * 可以用: 哈希法或者字符串匹配法(映射)
 */
public class 赎金信 {
    public static void main(String[] args) {
        String ransomNote = "aab";
        String magazine = "aabc";
        System.out.println(ransomNote + " == " + magazine + " = " + canConstruct(ransomNote,magazine));
    }
    //分析条件 1. ransomNote能不能由magazine里面的字符构成
    //       2. magazine中的每个字符只能在ransomNote中使用一次
    public static boolean canConstruct(String ransomNote, String magazine){
        //第一个条件就是magazine的长度大于ransomNote, 如果小于返回false
        if (ransomNote.length() > magazine.length()){
            return false;
        }
        //第二个条件每个字母只能使用一次
        //作为把数据都映射到数组里面,且初始化为0
        int[] result = new int[26];
        //把第一个字符串映射到数组中
        for (char c: magazine.toCharArray()) {
            result[c-'a']++;
        }
        //把第二个字符串也映射到数组中, 利用ransomNote有的字母而magazine有来判断 0,1表示可以组成, -1表示不能组成
        for (char c : ransomNote.toCharArray()){
            result[c-'a']--;
            if (result[c-'a'] < 0){
                return false;
            }
        }
        return true;
    }
}
