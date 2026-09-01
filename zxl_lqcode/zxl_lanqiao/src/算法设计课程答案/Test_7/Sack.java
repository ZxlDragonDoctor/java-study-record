package 算法设计课程答案.Test_7;

// 0-1背包问题
public class Sack {
    public int knapsack(int[] weight, int[] value, int maxWeight) {
        int n = weight.length;
        int[][] dp = new int[n + 1][maxWeight + 1];
        for(int i = 1; i < n+1; i++){
            for(int j=1;j<maxWeight+1;j++){
                if(j<weight[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i-1]]+value[i-1]);
                }
            }
        }
        return dp[n][maxWeight];
    }

    public static void main(String[] args) {
        int[] weight = {2, 3, 4, 5};
        int[] value = {3, 4, 5, 6};
        int maxWeight = 8;
        Sack sack = new Sack();
        int result = sack.knapsack(weight, value, maxWeight);
        System.out.println(result);
    }
}
