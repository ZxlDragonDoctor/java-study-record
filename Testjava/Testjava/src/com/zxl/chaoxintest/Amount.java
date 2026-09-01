package com.zxl.chaoxintest;

import java.util.Scanner;

public class Amount {
//    企业发放的奖金根据利润提成。
//    利润(I)低于或等于10万元时，奖金可提10%；
//    利润高于10万元，低于20万元时，低于10万元的部分按10%提成，高于10万元的部分，可提成7.5%；
//            20万到40万之间时，高于20万元的部分，可提成5%；
//            40万到60万之间时高于40万元的部分，可提成3%；
//            60万到100万之间时，高于60万元的部分，可提成1.5%，
//    高于100万元时，超过100万元的部分按1%提成，从键盘输入当月利润I，求应发放奖金总数？
   public static void main(String[] args){
      RewardTest rewardTest = new RewardTest();
      System.out.println("请输入当月利润(单位：万元)：");
      Scanner scanner = new Scanner(System.in);
      double profit = scanner.nextDouble();
      System.out.println("应发放奖金总数为：" + rewardTest.menue(profit));
   }


}

