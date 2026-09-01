package chaoxintest.practice_7;

import java.sql.SQLOutput;
import java.util.Scanner;

public class JudgeNumber {
    public static void main(String[] args) {
        System.out.println("请输入一个正整数：");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double m = Math.sqrt(n);
        int i;
        if(n==2){
            System.out.println("该数是素数");
        }
        else {
            for(i = 2;i<=m; i++){
                if(n%i==0){
                    System.out.println("该数不是素数");
                    break;
                }
            }
            if(i>m){
                System.out.println("该数是素数");
            }
        }



    }
}
