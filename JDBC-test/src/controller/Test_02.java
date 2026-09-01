package controller;

import java.util.Scanner;

public class Test_02 {
    // 	问题二：猜数字游戏。张三和李四进行猜数字游戏，张三拿着2-99之间不相同的两个数字的和，李四拿着这两个数的积。
//	张三说：我不知道这两个数字是多少，但我肯定你也不知道。
//这说明能组成这两个数的一对数不止一对
// 李四说：你这么说，我就知道这两个数是多少了。
//这说明能组成这个积的一对数在能组成和的数对中是唯一的
// 张三说：你这么说，我也知道了。
// 综上
    //1. 这两个数组成一个和和一个积
    //2. 在所有能组成和的数对中只有唯一一对数能组成这个积
    //3.能组成这个和的数对至少有两个
// 请问：这两个数是多少。
    public static void main(String[] args) {
        answer();
    }
    public static void answer(){
        for(int i=2;i<100;i++){
            for(int j=i+1;j<100;j++){
                int sum = i+j;
                int product = i * j;
                isNumber(sum,product);
            }
        }
    }
    public static void isNumber(int sum, int product) {
        int count = 0;
        int first=0,second=0;
        int index=0;
       for(int i =2;i<(sum+1)/2;i++){
           index++;
           if((sum-i)*i==product){
               first = i;
               second = sum-i;
               count++;
           }
       }
       if(count==1&&index>=2){
           System.out.println("和为"+sum+",积为"+product+"时，这两个数"+first+"和"+second);
       }
    }

}