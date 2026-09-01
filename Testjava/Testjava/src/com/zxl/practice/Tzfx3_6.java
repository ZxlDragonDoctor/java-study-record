package com.zxl.practice;

import java.util.Scanner;

//下面是投资分析程序的部分代码，请补全下列代码，
//        并且在main方法中实现输入数字
//        1、用于计算存款余额，（预期存款总额）
//        2、计算存款年限；
//        3、计算存款本金；
//        4、计算存款利率；
//        0、退出系统。

public class Tzfx3_6{
    //计算存款总额
    public static void tzfx3_1(double x,double n,double d ){
//        double y;
//        int i;
//        z=Math.pow(1+d,n)*x;
//        y=(z-x)*100.00;
//        i=(int)y;
//        y=i/100.00;
//        System.out.println("预期存款总额为z="+z);
//        System.out.println(" 存款年限为n="+n+"存款年利率"+d);
//        System.out.println("本金x="+x+"  利息y="+y);
            double z = x*(Math.pow(1+d,n));
           System.out.println("预期存款总额为z="+z);
    }
    //实现计算存款年限；
    public static void tzfx3_2(double x,double z,double d ){
        double n = Math.log(z/x)/Math.log(1+d);
        System.out.println("存款年限为n=" + n);
    }
    // 计算存款本金
    public static void tzfx3_3(double z,double n,double d ){
        double x = z/(Math.pow(1+d,n));
        System.out.println("本金为x=" + x);
    }
    //计算存款利率
    public static void tzfx3_4(double x,double z,double n ){
        double d = Math.pow(z/x,1/n) - 1;
        System.out.println("存款利率为d=" + d);
    }

    //main方法
    public static void main(String args[]){
        int  choice = 0;
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        do{
            System.out.println("=====请选择你要求的值=====");
            System.out.println("\t\t0" + "退出系统");
            System.out.println("\t\t1" + "用于计算存款余额(z)");
            System.out.println("\t\t2" + "计算存款年限(n)");
            System.out.println("\t\t3" + "计算存款本金(x)");
            System.out.println("\t\t4" + "计算存款利率(d)");
            System.out.println("请输入你的选择：");
            choice = scanner.nextInt();
            switch (choice){
                case 0:
                    System.out.println("退出系统");
                    loop = false;
                    break;
                case  1:
                    System.out.println("请依次输入x,n,d");
                    tzfx3_1(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble());
                    break;
                case  2:
                    System.out.println("请依次输入x,z,d");
                    tzfx3_2(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble());
                    break;
                case  3:
                    System.out.println("请依次输入z,n,d");
                    tzfx3_3(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble());
                    break;
                case  4:
                    System.out.println("请依次输入x,z,n");
                    tzfx3_4(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble());
                    break;
                default:
                    System.out.println("你的输入有误，请重新输入~");
                    break;
            }
         }while(loop);

    }
}