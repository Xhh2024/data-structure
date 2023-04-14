package com.xhh.demo.栈与队列;

/**
 * 数据结构-队列（顺序队列-链式队列）
 * 一种受操作限制的线性表, 队列的前端进行删除, 队列的尾部进行插入
 * 先进先出原则
 */
public class QueueDemo {

    public static void main(String[] args) {
        QueueData queue = new QueueData(2);
//        System.out.println("出对操作: " + queue.getElement());
        queue.addElement(2);
        queue.addElement(3);
        queue.showQueue();
        System.out.println("出对操作: " + queue.getElement());
        queue.showQueue();
    }
}

/**
 * 顺序栈 -> 采用的是数组结构+双指针
 */
class QueueData {
    //存储队列的元素
    private int[] data;
    //实际元素个数
    private int size;
    //队列容量
    private int maxSize;
    //对头指针 指向最前面一个元素
    private int font;
    //队尾指针 指向最后一个元素
    private int rear;
    //构造函数
    public QueueData(){}
    public QueueData(int maxSize){ //初始化容量
        this.maxSize = maxSize;
        //初始化数组
        this.data = new int[maxSize];
        //初始化实际数组大小
        this.size = 0;
        //初识指针都指向对尾(数组的下标为0的位置)
        this.font = 0;
        this.rear = 0;
    }
    //判断队列是否为空 -> 判断实际元素个数是否为0 且 队尾指针和对头指针指向通一个地方
    public boolean isEmpty(){
        return size == 0 && rear == font;
    }
    //判断队列是否满 -> 判断头指针是否指向最大容量
    public boolean isFull(){
        return rear == maxSize;
    }
    //添加元素到队列中 -> 入队操作
    public void addElement(int num){
        //判断队列是否已经满
        if (isFull()){
            throw new RuntimeException("队列空间已经占满");
        }
        //添加元素进入队列
        data[rear] = num;
        //尾部指针+1
        rear++;
        //实际大小+1
        size++;
    }
    //获取队列里面的元素 -> 出队操作
    public int getElement(){
        //判断队列是否为null
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        //去除队列元素(遵守先进先出的原则)
        int element = data[font++];
        //实际大小-1
        size--;
        //返回取出的元素
        return element;
    }
    //遍历队列
    public void showQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列是空");
        }
        for (int i = font; i < rear; i++){
            System.out.print(data[i] + ",");
        }
        System.out.println();
    }
    //获取队列的元素个数
    public int getElementNum(){
        return size;
    }
}


