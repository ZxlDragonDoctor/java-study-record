package com.zxl.practice;

public class ForTest {
    public static void main(String[] args) {
        //for循环
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 7 == 0) {
                System.out.println(i);
            }
        }
        //while循环
        int j = 100;
        while(j!=0)
        {
            if (j % 3 == 0 && j % 7 == 0) {
                System.out.println(j);
            }
            j--;
        }
        //do_while循环
        int k = 1;
        do{
            if (k % 3 == 0 && k % 7 == 0) {
                System.out.println(k);
            }
            k++;
        }while (k<=100);
    }

}
