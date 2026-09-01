package ACW;

import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class Main {
    //k倍区间 蓝桥 中等
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n,k;
        int count = 0;//计数
        n = scan.nextInt();
        k = scan.nextInt();
        int[] N = new int[n];
        for(int i=0;i<n;i++){
            N[i] = scan.nextInt();
        }
        int[] cnt = new int[k];
        long sum = 0;
        cnt[0] = 1;//临界情况
        for(int i=0;i<n;i++){
            sum += N[i];
            cnt[(int)(sum%k)]++;
        }
        sum = 0;
        for(int i=0;i<k;i++){
            sum += (long)(cnt[i]*(cnt[i]-1)/2);
        }
        System.out.println(sum);
        scan.close();
    }
}