package com.xhh.demo.leetcode题目;

import java.util.Arrays;

/**
 * 字符串反转: https://leetcode.cn/problems/reverse-string/
 * 方法就是用双指针方法实现的
 */
public class 字符串反转 {
    public static void main(String[] args) {
        //举的第一个例子
        char[] s = new  char[]{'h','e','l','l','o'};
        System.out.println("未反转的结果 = " + Arrays.toString(s));
        reverseString(s);
        System.out.println("反转的结果 = " + Arrays.toString(s));
    }
    //反转字符串: 用的就是双指针方式
    public static void reverseString(char[] s){
        //第一个指针指向第一个元素
        int start = 0;
        //第二个指针指向最后一个元素
        int end = s.length - 1;
        while(start < end){
            //开辟一个辅助空间, 然后在利用交换法, 将位置互换一下, 不开辟新的空间
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            //指针向右移动
            start++;
            //指针向左移动
            end--;
        }
    }
}
