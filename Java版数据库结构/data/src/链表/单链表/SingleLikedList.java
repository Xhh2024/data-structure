package com.xhh.demo.链表.单链表;

/**
 * 单链表 -> 数据结构是由指针域和数据域组成
 */
public class SingleLikedList {
    //创建一个线程测试
    public static void main(String[] args) {
        //创建单链表
        SingleLiked singleLiked = new SingleLiked();
        //创建节点
        DataNode node1 = new DataNode(1,"xhh1");
        DataNode node2 = new DataNode(2,"xhh2");
        DataNode node3 = new DataNode(3,"xhh3");
        DataNode node4 = new DataNode(4,"xhh4");
        //添加数据
        singleLiked.addDataNode(node1);
        singleLiked.addDataNode(node2);
        singleLiked.addDataNode(node3);
        singleLiked.addDataNode(node4);
        //删除数据
        singleLiked.delDataNode(3);
        //修改数据
        singleLiked.upDataNode(new DataNode(4,"lxy"));
        //遍历数据
        singleLiked.showDataNode();
        //获取倒数第k个元素
        System.out.println("倒数第" + 2 + "个元素的值: " + singleLiked.getLastDataNode(2));
    }
}

//创建单链表(有头结点的单链表)
class SingleLiked {
    //创建头结点
    public DataNode head = new DataNode(0, "");
    //链表的元素个数
    private int length = 0;
    //添加节点
    public void addDataNode(DataNode node){
        //创建辅助指针 -> 先指向头结点
        DataNode cur = head;
        //空指针判断条件
        boolean flag = false;
        //循环遍历节点, 找到next指向为null的节点
        while(true){
            if (cur.next == null){
                flag = true;
                break;
            }
            //辅助指针指向下一个节点
            cur = cur.next;
        }
        if (flag){
            //将指针指向添加进来的新元素
            cur.next = node;
            //单链表元素+1
            length++;
        }else{
            throw new RuntimeException("插入失败, 未找到指针指向null的元素");
        }
    }
    //单链表遍历节点
    public void showDataNode(){
        //辅助指针
        DataNode cur = head;
        System.out.println("执行了该方法");
        //循环遍历节点
        while(cur.next != null){
            System.out.println(cur);
            //指向下一个节点
            cur = cur.next;
        }
    }
    //单链表删除节点通过id去删除
    public void delDataNode(int id){
        //创建辅助指针
        DataNode cur = head;
        boolean flag = false;
        //循环遍历节点, 找到节点的id和id相同的节点
        while(cur.next != null){
            //判断节点的下一个节点是否id相同
            if (cur.next.id == id){
                flag = true;
                break;
            }
            //指向下一个节点
            cur = cur.next;
        }
        //将节点移除(前驱节点的next指向该元素的后驱节点)
        if (flag){
            cur.next = cur.next.next;
            //将链表元素-1
            length--;
        }else{
            throw new RuntimeException("未找到该节点" + id + "的元素");
        }
    }
    //单链表修改某个节点信息
    public void upDataNode(DataNode node){
        //辅助指针
        DataNode cur = head;
        boolean flag = false;
        while(cur.next != null){
            //判断两个id是否相同
            if (cur.next.id == node.id){
                flag = true;
                break;
            }
            //辅助指针往后移动
            cur = cur.next;
        }
        //找到该元素信息进行修改
        if (flag) {
            cur.next.id = node.id;
            cur.next.data = node.data;
        }else{
            throw new RuntimeException("修改失败, 未找到该元素信息");
        }
    }
    //获取链表的长度
    public int getLength(){
        return length;
    }

    //获取单链表倒数第k个元素
    public DataNode getLastDataNode(int k) {
        //判断k是否合法
        if (k == 0 || k > length){
            System.out.println("参数k不合法");
            return null;
        }
        //设置辅助指针
        DataNode cur = head;
        //获取整个链表的长度
        int len = getLength();
        System.out.println("链表的长度: " + len);
        //判断是否为空链表
        if (len == 0){
            throw new RuntimeException("链表为空, 无法操作");
        }
        //找到倒数第k个元素的链表规律是(链表长度 -k + 1)
        for (int i = 0; i < len - k + 1; i++){
            cur = cur.next;
        }
        return cur;
    }
}

//单链表节点
class DataNode {
    //节点的id
    public int id;
    //节点的数据域
    public String data;
    //节点的指针域
    public DataNode next;
    //初始化节点
    public DataNode(int id, String data){
        this.id = id;
        this.data = data;
    }
    @Override
    public String toString() {
        return "DataNode{" +
                "id=" + id +
                ", data='" + data + '\'' +
                ", next=" + next +
                '}';
    }
}
