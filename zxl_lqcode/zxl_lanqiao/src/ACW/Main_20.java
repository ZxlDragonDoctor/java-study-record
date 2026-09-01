package ACW;

import java.util.*;
public class Main_20 {
    static int n =0;
    //ac.有序分数 两种做法1.暴力 2.sb树（数学定理）
    public static void dfs(int a,int b,int c,int d){
        if((b+d)>n){
            return;
        }
        dfs(a,b,a+c,b+d);
        System.out.println((a+c)+"/"+(b+d));
        dfs(a+c,b+d,c,d);
    }
    public static void main(String[] args) {
        //sb树
        Scanner sc = new Scanner(System.in);
        n= sc.nextInt();
        System.out.println("0/1");
        dfs(0,1,1,1);
        System.out.println("1/1");
    }
}
