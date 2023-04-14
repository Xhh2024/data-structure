package com.xhh.demo.查找算法;

/**
 * 插值查找
 * 二分查找的优化
 */
public class InsertSearchDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,4,6,8,11};
        //接收目标值的下标
        int index = insertSearch(arr,0,arr.length-1,11);
        if (index != -1){
            System.out.printf("目标值的下标%d",index);
        }else{
            System.out.println("未找到目标值");
        }
    }

    /**
     * 插值查找和二分查找一样, 改良版, 选取mid的值的时候用了自适应算法
     * 自适应算法
     * 优势: 可以减少查找的次数, 适合比较连续的较大数据
     * 劣势: 对于比较分散的数据, 不但不能减少查找的次数, 可能性能还不如二分查找
     * 注意点: 如果查找的值比最小值小或比最大值还大, 则需要改变递归结束条件
     *        否则会出现非法索引访问数组时抛出的异常。如果索引为负或大于等于数组大小，则该索引为非法索引(ArrayIndexOutOfBoundsException)
     */
    public static int insertSearch(int[] arr, int start, int end, int findNum){
        //递归结束条件, 不能超出最大最小值的范围内, 否则会抛出越界异常
        if (start > end || findNum < arr[start] || findNum > arr[end]){
            return -1;
        }
        //自适应算法求中间值
        int mid = start + (end - start) * (findNum - arr[start]) / (arr[end] - arr[start]);
        // 如果比中间值小, 则选择左边的区间, 然后在进行递归
        if (arr[mid] > findNum){
            //递归左边区间
            return insertSearch(arr,start,mid-1,findNum);
        }else if (arr[mid] < findNum){
            //递归右边区间
            return insertSearch(arr,mid+1,end,findNum);
        }else{
            return mid;
        }
    }
}
