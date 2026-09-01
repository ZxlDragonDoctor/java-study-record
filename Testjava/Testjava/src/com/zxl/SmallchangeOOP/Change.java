package com.zxl.SmallchangeOOP;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Change{
    Double money;
    Double balance = 0.0;
    String detial = "===========零钱通明细=========";
    String note = "";
    boolean loop = true;
    Scanner scanner = new Scanner(System.in);
    int choice;
    String acept = "";
    Date date = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    public void menu(){
        do {
            System.out.println("=============零钱通===========");
            System.out.println("\t\t1  零钱通明细");
            System.out.println("\t\t2  收  入");
            System.out.println("\t\t3  消  费");
            System.out.println("\t\t4  退  出");
            System.out.println("请输入你的选择");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    this.detail();
                    break;
                case 2:
                    this.income();
                    break;
                case 3:
                    this.pay();
                    break;
                case 4:
                    this.exit();
                    break;
                default:
                    System.out.println("你的输出有误，请重新输入");
                    break;
            }
        } while (loop);
    }
    public void detail() {
        System.out.println(detial);
    }
    public void income(){
        System.out.print("收益入账：");
        money = scanner.nextDouble();
        //金额范围判断
        if(money <= 0){
            System.out.println("收入异常");
            loop = false;
            return;
        }
        balance += money;
        date = new Date();
        detial += "\n收入入账" + "\t" + money + "\t" + sdf.format(date) + "\t余额：" + balance;
        System.out.println(detial);
        return;
    }
    public void pay(){
        System.out.println("支付金额：");
        money = scanner.nextDouble();
        balance -= money;
        //金额范围判断
        if(money <= 0||balance < 0){
            System.out.println("支出异常");
            loop = false;
            return;
        }
        System.out.println("支付明细:");
        note = scanner.next();
        date = new Date();
        detial += "\n" + note + "支出\t" + -money + "\t" + sdf.format(date) + "\t余额：" + balance;
        System.out.println(detial);
        return;
    }
    public void exit(){
        do{
            System.out.println("你确定要推出吗？ y/n");
            acept = scanner.next();
            if("y".equals(acept)||"n".equals(acept)){
                break;
            }
        }while (true);
        loop = false;
        return;
    }
}