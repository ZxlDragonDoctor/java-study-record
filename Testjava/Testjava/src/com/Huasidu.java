package com;

import java.util.Scanner;

public class Huasidu {
    public static void main(String[] args) {
        System.out.println("请输入摄氏温度（℃）");
        Scanner myScanner = new Scanner(System.in);
        int a = myScanner.nextInt();
        int reuslt = 9 / a + 32;
        System.out.println("转化的华氏温度为" + reuslt + "（℉）");
    }
}
