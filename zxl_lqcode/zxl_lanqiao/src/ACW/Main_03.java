package ACW;

import java.io.IOException;
import java.util.Scanner;

public class Main_03 {
    //Ac.借教室 二分+差分+前缀和
    static int n,m;
    static final int Max = (int)Math.pow(10,6) + 10;
    static int[] r = new int[Max];
    static int[] d = new int[Max];
    static int[] s = new int[Max];
    static int[] t = new int[Max];
    static long[] ttl = new long[Max];
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i=1;i<=n;i++){
            r[i] = sc.nextInt();
        }
        for(int i=1;i<=m;i++){
            d[i] = sc.nextInt();
            s[i] = sc.nextInt();
            t[i] = sc.nextInt();
        }
        int L = 1,R = m ;
        int mid = 0;
        while (L < R){//二分
            mid = (L+R)/2;
            if(checked(mid)){//前mid个订单不满足
                R = mid ;
            }else {//前mid个订单满足
                L = mid + 1;
            }
        }
        if(R==m){
            System.out.println(0);
        }else {
            System.out.println(-1 + "\n" + R);
        }
    }
    public static boolean  checked(int mid){
        for(int i=1;i<=n;i++)  {
            ttl[i] = r[i] - r[i-1];//初始化
        }
        for(int i=1;i<=mid;i++){
            ttl[s[i]] -= d[i];
            ttl[t[i]+1] += d[i];//差分
        }
        long s = 0;
        for(int i=1;i<=n;i++){
            s += ttl[i];//前缀和
            if(s<0){
                return true;
            }
        }
        return false;
    }
}

