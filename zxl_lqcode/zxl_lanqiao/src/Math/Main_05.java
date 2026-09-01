package Math;

import java.util.Arrays;

public class Main_05 {
    static int N = 10000010;
    static int[] dp = new int[N];
    public static int init(int x){
        Arrays.fill(dp,0);
        int cnt = 0;
        while(x/10!=0) {
            int res = x % 10;
            dp[cnt++] = res;
            x = x / 10;
        }
        dp[cnt++] = x;
        int sum  =0;
        for (int i=0;i<=cnt/2;i++){
            dp[i] = dp[cnt-i];
            sum += dp[i];
        }
        dp[cnt] = sum;
        return cnt;
    }
    public static int find(){
        for(int x=10000;x>=0;x--){
            System.out.println(x);
            int n = init(x);
            for(int i=n+1;;i++){
                dp[i] = 2*dp[i-1] - dp[i-n-1];
                if(dp[i]==x){
                    System.out.println(x);
                    return x;
                }
                if(dp[i]>x){
                    break;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(find());
    }
}
