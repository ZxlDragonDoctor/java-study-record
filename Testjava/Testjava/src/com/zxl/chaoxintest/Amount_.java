package com.zxl.chaoxintest;

import java.util.Scanner;
/**
 * 该代码有待修改，没有增加每个值的范围判定
 */
public class Amount_ {
    public static void main(String[] args) {
        Economic eco = new Economic();
        Scanner scanner = new Scanner(System.in);
        System.out.println("=====请选择你要求的值=====");
        System.out.println("\t\t1" + "求本金(x)");
        System.out.println("\t\t2" + "求存款总额预期值(z)");
        System.out.println("\t\t3" + "求存款年限(n)");
        System.out.println("\t\t4" + "求存款利率(d)");
        int choice = scanner.nextInt();
        double result;
        switch (choice){
            case 1:
                System.out.println("请依次输入d,n,z");
                result = eco.calx(scanner.nextDouble(),scanner.nextDouble(),scanner.nextDouble());
                System.out.println("本金为：" + result);
                break;
            case 2:
                System.out.println("请依次输入d,x,z");
                result = eco.calz(scanner.nextDouble(),scanner.nextDouble(),scanner.nextDouble());
                System.out.println("存款总额预期值为：" + result);
                break;
            case 3:
                System.out.println("请依次输入d,z,x");
                result = eco.caln(scanner.nextDouble(),scanner.nextDouble(),scanner.nextDouble());
                System.out.println("存款年限为：" + result);
                break;
            case 4:
                System.out.println("请依次输入z,n,x");
                result = eco.cald(scanner.nextDouble(),scanner.nextDouble(),scanner.nextDouble());
                System.out.println("存款利率为：" + result);
                break;
            default:
                System.out.println("你的输入有误");
                break;
        }
    }
}

