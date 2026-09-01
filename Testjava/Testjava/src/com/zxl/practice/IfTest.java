package com.zxl.practice;

import java.util.Scanner;

public class IfTest {
    public static void main(String[] args) {
//        如何将上述代码中的（1）至（6）代码改写为一条if语句实现。
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入年份：");
        int year = scanner.nextInt();
//        if (year % 4 == 0 && year % 100 != 0) {
//            System.out.println(year + "是闰年");
//        } else if (year % 400 == 0) {
//            System.out.println(year + "是闰年");
//        } else {
//            System.out.println(year + "不是闰年");
//        }
        if((year % 4 == 0 && year % 100 != 0) ||(year % 400 == 0)){
            System.out.println(year + "是闰年");
        }else{
            System.out.println(year + "不是闰年");
        }
    }
}
