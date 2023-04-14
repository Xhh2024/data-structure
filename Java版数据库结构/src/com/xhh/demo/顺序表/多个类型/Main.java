package com.xhh.demo.顺序表.多个类型;

/**
 * 顺序表的实现
 * 利用泛型实现存储不同类型得元素
 */
public class Main {

    public static void main(String[] args) {
        //创建一个顺序表 初始容量为4
        sequenceList list = new sequenceList(5);
        list.addNum(1);
        list.addNum(2);
        list.addNum(3);
        list.addNum(4);
        list.insertNum(4, "xhh");
        list.showNum();
        list.changeNum(0,30);
        list.showNum();
        list.delNum(3);
        list.showNum();
        System.out.println("有效长度: " + list.getLength());
        list.insertNum(4, 60);
        list.showNum();
    }
}

/**
 * 顺序表 -> 操作: 增加 删除 修改 遍历元素, 扩容操作
 * 特点:
 */
class sequenceList<T>{
    //存储数据
    private T[] list;
    //有效数据长度
    private int num;
    //初始化顺序表
    public sequenceList(int size){
        //设置初始容量
        list = (T[]) new Object[size];
        //设置初始有效长度
        num = 0;
    }
    //判断顺序表是否为空
    public boolean isEmpty(){
        //判断有效长度是否为0
        return num == 0;
    }
    //判断顺序表是否占满
    public boolean isFull(){
        //判断有效长度是否大于容量
        return num >= list.length;
    }
    //顺序表添加元素操作
    public void addNum(T element){
        //判断是否满了, 满了则扩容
        if (isFull()){
            //扩容操作
            reList(list.length * 2);
        }
        //未满则插入元素
        list[num++] = element;
    }
    //顺序表在指定位置上插入元素操作
    public void insertNum(int index, T element){
        //判断是否参数合法(索引)
        if (index < 0 || index > num){
            throw new RuntimeException("参数不合法");
        }
        //判断是否顺序表已经占满, 满则扩容
        if (isFull()){
            //扩容操作
            reList(list.length * 2);
        }
        //将数据插入到指定位置
        for (int i = num; i > index; i--){
            list[i] = list[i-1];
        }
        //将数据插入进行去
        list[index] = element;
        //有效长度+1
        num++;
    }
    //顺序表遍历元素操作
    public void showNum(){
        //普通遍历方式 -> 利用num-1作为索引 num作为下标
        for (int index = 0; index < num; index++){
            System.out.print(list[index] + " ");
        }
        //换行
        System.out.println();
    }
    //顺序表获取长度
    public int getLength(){
        return num;
    }
    //顺序表获取单个元素
    public T getNum(int index){
        if (index < 0 || index > num-1){
            throw new RuntimeException("参数不合法");
        }
        return list[index];
    }
    //顺序表修改元素
    public void changeNum(int index, T element){
        if (index < 0 || index >= num){
            throw new RuntimeException("参数不合法");
        }
        list[index] = element;
    }
    //顺序表删除元素
    public void delNum(int index){
        //判断是否参数是否不合法
        if (index < 0 || index >= num){
            throw new RuntimeException("参数不合法");
        }
        //删除元素, 移动元素
        for (int i = index; i < num-1; i++){
            list[i] = list[i+1];
        }
        //有效长度减1
        num--;
    }
    //顺序表的扩容
    public void reList(int size){
        //先将原来的数据存储起来
        T[] temp = list;
        //创建一个新的数组
        list = (T[]) new Object[size];
        //进行数据拷贝
        for (int i = 0; i < temp.length; i++){
            list[i] = temp[i];
        }
    }
}