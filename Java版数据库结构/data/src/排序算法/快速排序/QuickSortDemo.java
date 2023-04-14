package com.xhh.demo.排序算法.快速排序;

import java.util.Arrays;

/**
 * 快速排序
 * 思路: 快速排序其实就是冒泡排序的改良版, 选择一个基准值作为分割
 * 把左边元素小于, 右边元素大于, 然后递归, 直到全部有序在整合
 * 步骤:
 * 1. 选择一个基准值(固定取法, 随机取法, 三中取法)
 * 2. 设置两个指针, leftIndex rightIndex(一个指向左边, 一个指向右边)
 *    left指针指向的值小于right指向的值 +1 , 反之两个值交换
 * 3. 在按1,2步骤进行递归
 * 优缺点:
 * 优点: 对于杂乱无章的数据而言, 平均时间复杂度为O(nlogn)
 * 缺点: 对于有序的数据而言, 时间复杂度为O(n2)
 */
public class QuickSortDemo {

    public static void main(String[] args) {
        int[] arr = new int[]{5,9,11,3,4,8};
        //进行快速排序
        quickSort(arr,0,arr.length-1);
        //然后在打印结果
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 递归具备的条件:
     * 有结束条件, 自己递归自己
     */
    public static void quickSort(int[] arr, int leftIndex, int rightIndex){
        //结束条件 就是leftIndex > rightIndex的时候
        if (leftIndex > rightIndex){
            return;
        }
        //设置左右指针
        int left = leftIndex;
        int right = rightIndex;
        //设置基准值, 固定取值法, 找第一个元素
        int key = arr[left];
        //检索数组,
        while (left < right){
            //判断条件是如果比基准值要大, 右指针往后移动
            while (left < right && arr[right] >= key){
                right--;
            }
            //右边, 找到比基准值要小的元素
            arr[left] = arr[right];
            //判断条件是如果比基准值要小, 左指针往前移动
            while (left < right && arr[left] <= key){
                left++;
            }
            //左边, 找到比基准值要大的元素, 与right指向的元素进行交换
            arr[right] = arr[left];
        }
        //当left=right的时候, 也就是指针归一
        arr[left] = key;
        //打印最终的结果
        System.out.println(Arrays.toString(arr));
        //在设置递归函数
        quickSort(arr,leftIndex,left-1);
        quickSort(arr,right+1, rightIndex);
    }
}
