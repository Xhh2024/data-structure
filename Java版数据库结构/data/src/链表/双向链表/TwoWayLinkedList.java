package com.xhh.demo.链表.双向链表;

/**
 * 双向链表
 */
public class TwoWayLinkedList {
    public static void main(String[] args) {
        TwoLiked twoLiked = new TwoLiked();
        DataNode node1 = new DataNode(1, "xhh1");
        DataNode node2 = new DataNode(2, "xhh2");
        DataNode node3 = new DataNode(3, "xhh3");
        //添加元素
        twoLiked.addDataNode(node1);
        twoLiked.addDataNode(node2);
        twoLiked.addDataNode(node3);
        //删除元素
        twoLiked.delDataNode(2);
        //进行修改操作
        twoLiked.upDataNode(new DataNode(3, "谢环环"));
        //遍历元素
        twoLiked.showDataNode();
        //获取双向链表的长度
        System.out.println("双向链表的长度: " + twoLiked.getLength());
        //获取某一个节点的元素
        int id = 3;
        System.out.println("{id = " + id + "的元素的节点值: " + twoLiked.getDataNode(id) + "}");
    }
}

//双向链表的数据结构和操作
class TwoLiked{
    //头结点(可有可无)
    public DataNode head = new DataNode(0,"");
    //链表长度
    private int length = 0;
    //双向链表增加一个元素
    public void addDataNode(DataNode node){
        //添加一个辅助指针
        DataNode cur = head;
        boolean flag = false;
        while(true){
            //按顺序进行添加
            if (cur.next == null){
                flag = true;
                break;
            }
            //一直遍历下去
            cur = cur.next;
        }
        //如果找到了添加的位置, 添加进去
        if (flag){
            //将后驱指针指向添加进来的元素
            cur.next = node;
            //新元素的前驱指针指向前一个元素
            node.pre = cur;
            //链表元素+1
            length++;
        }else{
            throw new RuntimeException("双向链表添加元素失败");
        }
    }
    //删除双向链表的某个元素
    public void delDataNode(int id){
        //创建一个辅助节点
        DataNode cur = head.next;
        boolean flag = false;
        //找到想要的元素
        while(cur != null){
            //判断id是否相同, 找到想要删除的元素
            if (cur.id == id){
                flag = true;
                break;
            }
            //一直遍历
            cur = cur.next;
        }
        //删除该元素
        if (flag){
            // 步骤1 将data1.next -> data3
            cur.pre.next = cur.next;
            //步骤2 将data3.pre -> data1
            if (cur.next != null){
                cur.next.pre = cur.pre;
            }
            //双向链表元素-1
            length--;
        }else{
            throw new RuntimeException("双向链表删除"+ id +"该元素失败");
        }
    }
    //获取链表长度
    public int getLength(){
        return length;
    }
    //获取链表里面的某一个元素
    public DataNode getDataNode(int id){
        //设置一个辅助指针
        DataNode cur = head.next;
        boolean flag = false;
        //通过id找到该节点
        while (cur != null){
            if (cur.id == id){
                flag = true;
                break;
            }
            //一直遍历下去
            cur = cur.next;
        }
        //通过flag去判断是否找到该元素
        return flag ? cur : null;
    }
    //双向链表修改某个元素的操作(仅仅只能修改id和data)
    public void upDataNode(DataNode node){
        //创建辅助指针
        DataNode cur = head.next;
        boolean flag = false;
        //找到想要修改的元素
        while (cur != null){
            //如果id相同的话, 作为判断条件
            if (cur.id == node.id){
                flag = true;
                break;
            }
            //一直遍历
            cur = cur.next;
        }
        if (flag){
            //进行修改操作
            cur.id = node.id;
            cur.data = node.data;
        }else{
            throw new RuntimeException("双向链表修改失败");
        }
    }
    //双向链表遍历整个元素
    public void showDataNode(){
        //辅助指针
        DataNode cur = head;
        //空双向链表的情况
        if (cur.next == null){
            throw new RuntimeException("双向链表为空");
        }
        //循环遍历节点
        while(true){
            //遍历完成
            if (cur.next == null){
                break;
            }
            //打印结果
            System.out.println(cur.next);
            //一直遍历下去
            cur = cur.next;
        }
    }
}

//双向链表节点数据结构封装
class DataNode {
    //节点序号
    public int id;
    //数据域
    public String data;
    //前驱指针
    public DataNode pre;
    //后驱指针
    public DataNode next;
    //初始化节点
    public DataNode(int id, String data){
        this.id = id;
        this.data = data;
    }
    //重写方法
    @Override
    public String toString() {
        return "DataNode{" +
                "id=" + id +
                ", data='" + data + '\'' +
                ", next=" + next +
                '}';
    }
}
