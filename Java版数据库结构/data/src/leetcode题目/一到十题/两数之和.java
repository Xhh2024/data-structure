package com.xhh.demo.leetcode题目.一到十题;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和：https://leetcode.cn/problems/two-sum/
 * 两种解决办法: 暴力枚举法, 哈希法
 */
public class 两数之和 {
    public static void main(String[] args) {
        //可以挑选随机数组, 这个是一个示范例子
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        int[] arr = twoSum1(nums,target);
        //暴力枚举法
        for (int ele: arr) {
            System.out.print(ele+", ");
        }
        System.out.println();
        //哈希法
        arr = twoSum2(nums,target);
        for (int ele:arr){
            System.out.print(ele + ", ");
        }
    }
    //暴力枚举法 -> 利用两个循环把元素全部遍历 时间复杂度0(n的平方)
    public static int[] twoSum1(int[] nums, int target){
        //第一次循环遍历len-1个元素
        for (int i = 0; i < nums.length; i++){
            //遍历i之后的元素
            for (int j = i+1; j < nums.length; j++){
                if (nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        //返回一个空数组,表示没找到该元素
        return new int[]{};
    }
    //哈希法 把数组的元素映射到哈希表中 key作为值, value作为下标, 再利用key = target - nums[i]这个公式找到value也就是下标
    // 时间复杂度度0(n)
    public static int[] twoSum2(int[] nums, int target){
        //将数组的值全部映射到哈希表中
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i],i);
        }
        //然后再利用公司找到该元素
        for (int j = 0; j < nums.length; j++){
            //剩余的值, 去map里面寻找
            int key = target - nums[j];
            //查看map里面是否存在该元素
            if (map.containsKey(key)){
                //不能等于本身自己
                if (j != map.get(key)){
                    return new int[]{j, map.get(key)};
                }
            }
        }
        //返回一个空数组,表示没找到该元素
        return new int[]{};
    }
}
