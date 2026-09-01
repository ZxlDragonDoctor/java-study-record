package ACW;



import java.util.Scanner;
public class Main_10{
    //蜗牛，动态规划
    public static void main(String[] args){
        int n = 0;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        double[] x = new double[n+1];
        for(int i=1;i<=n;i++){
            x[i] = sc.nextInt();
        }
        double[][] a = new double[n][2];
        double[][] dp = new double[n+1][2];
        for(int i=1;i<=n-1;i++){
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
        }
        dp[1][0] = x[1];//dp[i][0]代表到达第i根竹杆的底部
        dp[1][1] = x[1] + a[1][0]/0.7;//dp[i][1]代表到达第i根竹杠上a[i][0]的位置
        double k = 0;
        for(int i=2;i<=n-1;i++){
            dp[i][0] = Math.min(dp[i-1][0]+x[i]-x[i-1],dp[i-1][1]+a[i-1][1]/1.3);
            if(a[i-1][1]>a[i][0]){
                k = 1.3;
            }else{
                k = 0.7;
            }
            dp[i][1] = Math.min(dp[i][0]+a[i][0]/0.7,dp[i-1][1]+Math.abs(a[i-1][1]-a[i][0])/k);
        }
        System.out.printf("%.2f",Math.min(dp[n-1][0]+x[n]-x[n-1],dp[n-1][1]+a[n-1][1]/1.3));
    }
}