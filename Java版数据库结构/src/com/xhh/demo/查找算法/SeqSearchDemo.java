package com.xhh.demo.查找算法;

/**
 * 线性查找算法:
 * 1. 适合顺序存储结构的线性表
 * 2. 属于无序查找
 * 3. 从表的一端开始顺序查找, 依次扫描各个元素, 然后把查找的元素的节点元素进行比较
 */
public class SeqSearchDemo {

    public static void main(String[] args) {
        int[] arr = new int[]{1,7,3,5,4};
        int index = seqSearch(arr,3);
        if (index != -1){
            System.out.printf("目标值的下标%d",index);
        }else{
            System.out.println("目标值未找到");
        }
    }
    /**
     * 线性查找属于无序查找, 从表的一端进行一一匹配, 直到找到该目标值
     */
     public static int seqSearch(int[] arr,int findNum){
        //存储目标值的下标(如果下标为-1则表示未找到)
        int index = -1;
        for (int i = 0; i < arr.length; i++){
            //匹配与目标值相同的元素
            if (arr[i] == findNum){
                index = i;
                //只查找一个出现的元素
                break;
            }
        }
        return index;
    }
}
