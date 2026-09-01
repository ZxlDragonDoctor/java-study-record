package com.zxl.chaoxintest;

import java.util.Scanner;

public class Shusu {
//    编写一个java程序。给定一个正整数，判定它是否为素数并输出
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个正整数：");
        int N = scanner.nextInt();
        if(N==2){
            System.out.println("该正整数是素数");
        }else if(N%2==0||N%3==0||N%5==0){
            System.out.println("该正整数不是素数");
        }else {
            System.out.println("该正整数是素数");
        }
    }
}
