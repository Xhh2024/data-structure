package com.xhh.demo.排序算法.冒泡排序;

import java.util.Arrays;

/**
 * 冒泡排序属于交换排序的一种
 * 将最大的数字往数组末尾放, 以冒泡的形式, 所有称为冒泡排序
 */
public class BubbleSortDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{4,7,9,5,8,0};
        System.out.println("无序数组: " + Arrays.toString(arr));
        System.out.println("有序数组: " + Arrays.toString(bubbleSort(arr)));
    }
    //冒泡排序, 每进行一轮循环, 第二层循环次数-1, 每轮都会把最大数移至末尾, 以此来达到排序的目的
    public static int[] bubbleSort(int[] arr){
        // 嵌套循环, 第一层控制循环次数, 第二层控制每一次循环比较相邻数之间大小, 然后在进行交换
        int count = 0; //计数器
        // 第一层循环: 数组长度-1目的是防止数组越界, 以及循环的次数就是数组长度-1,
        // 比如拥有4个元素无序数组, 至多只需要三次就能将无序数组转化为有序数组
        for (int i = 0; i < arr.length - 1; i++){
            //第二层循环: 每次循环都要减少一次, 每次循环最大的元素都在数组末尾不需要进行排序
            for (int j = 0; j < arr.length -1 - i; j++){
                //存储变量
                int temp;
                //两数之间进行交换, 需要借助额外的内存空间
                if (arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            count++;
            System.out.println("第"+ count + "次循环结果: " + Arrays.toString(arr));
        }
        System.out.println("计数器: " + count);
        //返回已经排序好的数组
        return arr;
    }
}
