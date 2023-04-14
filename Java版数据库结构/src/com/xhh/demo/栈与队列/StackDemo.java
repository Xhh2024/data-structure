package com.xhh.demo.栈与队列;

/**
 * 数据结构-栈
 * 一种受操作限制的线性表, 在栈顶变化进行删除,增加, 栈底固定
 * 先进后出的原则
 */
public class StackDemo {

    public static void main(String[] args) {
        //创建一个栈空间
        StackData stack = new StackData(6);
        stack.push(1);
        stack.push(2);
        System.out.println("出栈操作: " + stack.pop());
        System.out.println("取出栈顶元素: " + stack.peekStack());
        stack.showStack();
    }
}

/**
 * 栈的数据结构
 */
class StackData {
    //存储空间
    private int[] data;
    //存储空间大小
    private int maxSize;
    //栈的元素个数
    private int size;
    //栈顶指针
    private int top;
    //构造函数
    public StackData(){};
    public StackData(int maxSize){
        //初始化数组大小
        this.data = new int[maxSize];
        this.maxSize = maxSize;
        //初始化元素个数
        this.size = 0;
        //初始化栈顶指针
        this.top = 0;
    }
    //判断栈是否为null -> 条件就是栈顶指针指向栈底(top == 0)
    public boolean isEmpty(){
        return top == 0;
    }
    //判断栈是否满
    public boolean isFull(){
        return top >= maxSize;
    }
    //入栈操作
    public void push(int num){
        //判断栈空间是否已经满了
        if (isFull()){
            throw new RuntimeException("栈空间已经满");
        }
        //入栈操作, 栈顶指针向上移动
        data[top++] = num;
        //实际元素个数+1
        size++;
    }
    //出栈操作
    public int pop(){
        //判断栈空间是否为空
        if (isEmpty()){
            throw new RuntimeException("栈空间为空");
        }
        int element = data[--top];
        //实际元素个数-1
        size--;
        return element;
    }
    //遍历栈元素
    public void showStack(){
        for (int i = 0; i < top; i++) {
            System.out.print(data[i]+",");
        }
        //换行操作
        System.out.println();
    }

    //返回栈顶元素
    public int peekStack(){
        //判断栈是否为空
        if (isEmpty()){
            throw new RuntimeException("栈空间为空");
        }
        return data[top-1];
    }
}
