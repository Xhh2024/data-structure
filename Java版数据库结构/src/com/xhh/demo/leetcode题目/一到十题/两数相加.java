package com.xhh.demo.leetcode题目.一到十题;

import java.util.Arrays;

/**
 * 两数相加： https://leetcode.cn/problems/add-two-numbers/
 *
 */

public class 两数相加 {
    public static void main(String[] args) {
        //举一个小例子 头节点node3
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(4,node1);
        ListNode node3 = new ListNode(2,node2);
        //头节点 node6
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(6,node4);
        ListNode node6 = new ListNode(5,node5);
        addTwoNumbers(node3,node6);
    }
    //两数之和 -> 两个链表的数据合并
    public static void addTwoNumbers(ListNode l1, ListNode l2){
        //开启新的空间
        String a = "";
        String b = "";
        while (true){
            //拼在一起
            a += l1.val;
            //循环结束条件
            if (l1.next == null){
                break;
            }
            //促进下一个循环
            l1 = l1.next;
        }
        while (true){
            //拼在一起
            b += l2.val;
            //循环结束条件
            if (l2.next == null){
                break;
            }
            //促进下一个循环
            l2 = l2.next;
        }
        //将结果处理
        String result = a + b;
        //转化为数组
        char[] arr = result.toCharArray();
        System.out.println(Arrays.toString(arr));
        ListNode[] nodeArr = new ListNode[arr.length];
        //生成节点
        for (int i = 0; i < arr.length; i++){
        }
    }
}

//提供一个链表
class ListNode{
    //数据域
    public int val;
    //指针域
    public ListNode next;
    //构造函数
    public ListNode(){}
    public ListNode(int val){this.val = val;}
    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}