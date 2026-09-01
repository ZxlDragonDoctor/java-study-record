package 腾讯云智;

import java.util.*;

public class Main {
    // 算法题目是这样的牛牛开了一家餐厅，n代表一共有几到菜，m代表顾客带了总共带了多少钱，
    // 后续n行代表每一道菜的成本和卖价，注：上给顾客的菜不会重复，求牛牛的最大收益是？
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];

        for(int i = 0; i < n; i++){
            a[i] = in.nextInt();
            b[i] = in.nextInt();
            c[i] = b[i] - a[i];
        }

        int[][] dp = new int[n + 1][m + 1];
        //dp[i][j]代表前i道菜，顾客带了j块钱，牛牛的最大收益

        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= m; j++){
                dp[i][j] = dp[i - 1][j];//不选第i道菜
                if(j >= b[i - 1]){//选第i道菜
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - b[i - 1]] + c[i - 1]);//选第i道菜，收益增加c[i-1]，顾客的钱减少b[i-1]
                }
            }
        }

        System.out.println(dp[n][m]);
    }
}
