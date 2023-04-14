package 一到十五题目.第五题;

import java.util.Scanner;

/**
 * 给定一个整数，写一个函数来判断它是否是 3的幂次方。如果是，返回 true ；否则，返回 false 。
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3的x幂次方
 * @author 谢环环
 * @date 2023/04/02
 */
public class 三的幂 {

    public static void main(String[] args) {
        //判断是否为幂次方
        int flag = 0;
        System.out.println("请输入数字: ");
        //实体化
        Scanner scanner = new Scanner(System.in);
        //接收输入键盘的数字
        int num = scanner.nextInt();
        //用于存储被三整数的数字
        int n = 0;
        while (true){
            //如果一开始就不能被3整数
            if (num % 3 != 0){
                break;
            }
            //遍历循环, 便于结束循环
            num = num / 3;
        }
        if (flag == 0){
            System.out.println(n + "不是3的x幂次方");
        }else {
            System.out.println(n + "是3的x幂次方");
        }
    }
}
