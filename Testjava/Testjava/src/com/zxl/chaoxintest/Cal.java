package com.zxl.chaoxintest;

public class Cal {
    public static void main(String[] args){
        int sum = 0;
        int allsum = 0;
        for(int i=1;i<=20;i++){
            sum = 1;
            for(int j =1;j<=i;j++){
                while (j!=i){
                    sum = sum * (++j);
                }

            }
            allsum += sum;
        }
        System.out.println("1!+2!+3!......+20!=" + allsum);
    }
}
