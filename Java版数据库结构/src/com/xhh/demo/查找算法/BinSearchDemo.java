package com.xhh.demo.查找算法;

/**
 * 二分查找
 * 属于有序查找, 必须查找存有序的表
 */
public class BinSearchDemo {

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,7,9,11};
        //用于接收目标值的下标
        int index = binSearch(arr,0, arr.length-1, 13);
        if (index != -1){
            System.out.printf("目标值的下标%d",index);
        }else{
            System.out.println("未找到目标值");
        }
    }

    /**
     * 二分查找思路:
     * 1. 找到mid的值, 目标值比mid值小, 则往左查找, 比mid值大, 则往右查找, 一直递归直到start >= end这个条件结束
     */
    public static int binSearch(int[] arr, int start, int end, int findNum){
       //递归结束条件
       if (start > end){
           return -1;
       }
       //中间值
       int mid = (start + end) / 2;
       //目标值比选出的中间值大, 则往右边递归
       if (findNum > arr[mid]){
           //然后将区间变小, 在进行递归, 直到找到目标值或者start>end结束递归
           return binSearch(arr,mid+1, end, findNum);
       //如果小于选出的中间值, 则往左边进行查找
       }else if(findNum < arr[mid]){
           return binSearch(arr,start, mid-1, findNum);
       //最后就是找到该元素则返回它的下标
       }else{
           return mid;
       }
    }
}
