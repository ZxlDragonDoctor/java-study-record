package ACW;

import java.util.Arrays;
import java.util.Scanner;

public class Main_16 {
    //ac.钓鱼塘 贪心 多路归并
    static int N = 110;
    static int[] a = new int[N];
    static int[] l = new int[N];
    static int[] p = new int[N];
    static int[] spend = new int[N];//存每个鱼塘经过的时间
    public static int get(int j){
        return Math.max(0,a[j]-l[j]*spend[j]);//防止减为负数,当为负数意味着没有一条鱼了，即0条
    }
    public static int work(int n,int T){
        int res = 0;
        Arrays.fill(spend,0);//填充为0
        for(int i=0;i<T;i++){
            int t=1;//这里要找到该减去次数的是哪个鱼塘
            for(int j=2;j<=n;j++) {
               if(get(t)<get(j)){
                   t = j;
               }
            }
            res += get(t);
            spend[t]++;

        }
        return res;
    }
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         for(int i=1;i<=n;i++){
             a[i] = sc.nextInt();
         }
         for(int i=1;i<=n;i++){
             l[i] = sc.nextInt();
         }
         for(int i=1;i<n;i++){
             p[i] = sc.nextInt();
             p[i] += p[i-1];//存到第i个鱼塘花费的总时间
         }
         int T = sc.nextInt();
         int res = 0;
         for(int i=1;i<=n;i++){
             res = Math.max(res,work(i,T-p[i-1]));
         }
         System.out.println(res);

     }
}
