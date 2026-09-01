package chaoxintest.practice_7;

import java.util.Scanner;

public class Sequence {
    public static void main(String[] args) {
        System.out.println("请输入你要查询斐波那契数列的第n个数：");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(judgeSequence(n));

    }
    public static int  judgeSequence(int n){
        if(n==1){
           return 0;
        }
        if(n==2){
            return 1;
        }
        return judgeSequence(n-1) + judgeSequence( n-2);

    }
}
