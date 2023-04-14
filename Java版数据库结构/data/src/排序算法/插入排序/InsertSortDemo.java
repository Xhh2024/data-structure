package com.xhh.demo.排序算法.插入排序;

import java.util.Arrays;

/**
 * 插入排序
 * 将集合分成无序序列和有序序列, 将无序序列里面的元素一个个把它和有序序列的元素进行排序
 */
public class InsertSortDemo {

    public static void main(String[] args) {
        int[] arr = new int[]{8,7,9,3,1,5};
        System.out.println("未排序之前的结果: " + Arrays.toString(arr));
        System.out.println("插入排序的结果: " + Arrays.toString(InsertSort(arr)));
    }
    //插入排序
    public static int[] InsertSort(int[] arr){
        //第一层循环, 目的就是控制循环次数, 1开头的原因是下标为0的元素已经是有序序列了
        for (int i = 1; i < arr.length; i++){
            //第二层循环, 排列待插入的无序序列和有序序列
            for (int j = i; j > 0; j--){
                //比较元素, 进行排序
                if (arr[j-1] > arr[j]){
                    //交换元素位置
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
            System.out.println("第" + i + "趟 = " + Arrays.toString(arr));
        }
        return arr;
    }
}
