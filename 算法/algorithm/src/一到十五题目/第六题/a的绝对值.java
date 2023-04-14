package 一到十五题目.第六题;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * 输入一个浮点数, 就输出a绝对值,精确到小数点后两位
 * @author 谢环环
 * @date 2023/04/02
 */
public class a的绝对值 {
    public static void main(String[] args) {
        System.out.println("输入一个浮点数, n <= 1000 :");
        //键盘输入
        Scanner scanner = new Scanner(System.in);
        double num = scanner.nextDouble();
//        System.out.println("第二种方式 num =" + getTwoApi(num));
        getOneApi(num);
//        System.out.println("第一种方式 num = " + getOneApi(num));
    }

    /**
     * 第一种方式：
     *
     * @param num 全国矿工工会
     * @return double
     */
    public static double getOneApi(double num){
        //转化为字符串
        String str = String.valueOf(num);
        System.out.println(str);
        //设定定时器
        int count = 0;
        //循环遍历
        String[] arr = str.split(".");
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
        //返回值
        return num;
    }

    /**
     * 第二种方式：
     * 利用正则匹配规则, 但会四舍五入
     * @param num 全国矿工工会
     * @return double
     */
    public static double getTwoApi(double num){
        DecimalFormat df = new DecimalFormat("0.00");
        BigDecimal bd = new BigDecimal(num);
        num = Double.parseDouble(df.format(num));
        return Math.abs(num);
    }
}
