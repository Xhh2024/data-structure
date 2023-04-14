package com.xhh.demo.leetcode题目;

import java.util.Arrays;

/**
 * 移除数组中的目标元素: https://leetcode.cn/problems/remove-element/
 * 两种方式解决: 暴力解法, 双指针解法
 */
public class 移除数组中的元素 {
    public static void main(String[] args) {
        //这只是其中的一个式例子
        int[] nums1 = new int[]{0,1,2,2,3,0,4,2};
        int val1 = 2;
        System.out.println("移除"+val1+"后数组的长度=" + removeElement1(nums1,val1));
        int[] nums2 = new int[]{0,1,2,2,3,0,4,2};
        int val2 = 2;
        System.out.println("移除"+val2+"后数组的长度=" + removeElement2(nums2,val2));
    }

    //暴力解法
    public static int removeElement1(int[] nums, int val){
        //得到数组长度
        int size = nums.length;
        //for循环遍历整个数组
        for (int i = 0; i < size; i++){
            if (nums[i] == val){
                //在来一个循环把位置往前移动一位, size-1防止数组越界
                for (int j = i; j < size - 1; j++){
                    nums[j] = nums[j+1];
                }
                //然后i在-1, 因为找到一个往前移动,元素的下标发生了变化
                i--;
                //数组长度也发生了变化
                size--;
            }
        }
        System.out.println("最终数组 = " + Arrays.toString(nums));
        return size;
    }

    //双指针解法 -> 利用两个指针(慢指针和快指针, 然后定义数组最后长度)
    public static int removeElement2(int[] nums, int val){
        //慢指针
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++){
            //如果没找到目标元素, 则slow++
            if (val != nums[fast]){
                nums[slow] = nums[fast];
                //为了使得慢快指针错开, fast指向目标, slow不指向目标
                slow++;
            }
            System.out.println(fast + ", " + slow);
        }
        System.out.println("最终数组 = " + Arrays.toString(nums));
        //最后返回慢指针的指向的下标位置
        return slow;
    }
}
