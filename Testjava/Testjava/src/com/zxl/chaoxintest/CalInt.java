package com.zxl.chaoxintest;

public class CalInt {
    public static void main(String[] args) {
//        编写程序显示100到1000之间能被5和6整除的数。
        for (int i = 100; i <= 1000 ; i++) {
            if(i%5==0&&i%6==0){
                System.out.print(i +"\t" );
            }
        }
    }
}
