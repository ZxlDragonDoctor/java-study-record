package com.zxl.practice;

import java.util.Scanner;

public class PrintStar {
//            *             //星数等于2倍行数-1
//           ***            //空格数是行数减一
//          *****
//         *******
    public static void main(String[] args) {
        //输入行数
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入行数：");
        int n = scanner.nextInt();
        //最外层控制行数
        for (int i = 1; i <= n; i++) {
            //输出空格
            for (int j = 1; j <=n-i; j++){
                System.out.print(" ");
            }
            for (int k = 1; k <= (2*i-1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
