package chaoxintest.practice_4;

import java.util.Arrays;
import java.util.Scanner;

public class Averages {
//    4.使用下面的方法头编写两个重载的方法，返回数组的平均数：
//    public static int average(int[] array)
//    public static double average(double[] array)
//    编写一个测试程序，提示用户输入10个double值，然后调用这个方法显示平均值。
    public static int average(int[] array){
        int sum = 0;
        for(int i:array){
            sum += i;
        }
        return sum/array.length;
    }
    public static double average(double[] array){
        double sum = 0.0;
        for(double i:array){
            sum += i;
        }
        return sum/ array.length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请依次输入10个double值");
        double[] array = new double[10];
        for (int i = 0; i < 10; i++) {
            array[i] = scanner.nextDouble();
        }
        System.out.println("平均值为：" + Averages.average(array));
    }
}
