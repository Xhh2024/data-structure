package com.xhh.demo.排序算法.选择排序;

import java.util.Arrays;

/**
 * 选择排序, 每一轮选择一个最小的数, 将其放置数组前列
 */
public class SelectSortDemo {

    public static void main(String[] args) {
        int[] arr = new int[]{8,4,7,3,9,2};
        System.out.println("有序数组: " + Arrays.toString(selectSort(arr)));
    }

    //选择排序
    public static int[] selectSort(int[] arr){
        //双层嵌套循环, 第一层控制循环次数, 第二层比较大小, 然后选出最小数, 将其放置数组前列
        for (int i = 0; i < arr.length - 1; i++){
            //设置变量k, 作为最小数的下标, 用来比较大小(设置目前最小数)
            int k = i;
            //第二层循环, 从k开始, 每次大循环都会将数组的最小数选出放置前列, 所以有序数组不需要比较
            for (int j = k; j < arr.length; j++){
                //与目前最小数进行比较, 若小于目前最小数, 则最小数就是当前下标, 进行交换
                if (arr[k] > arr[j]){
                    k = j;
                }
            }
            //如果k==i则表示, 已经是最小数, 无需在交换
            if (k != i){
                //设置一个存储空间, 用于存储交换的数据
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }
        }
        return arr;
    }
}
