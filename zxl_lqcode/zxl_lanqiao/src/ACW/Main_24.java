package ACW;

import java.util.Arrays;
import java.util.Scanner;

public class Main_24 {
    //ac.母亲的奶牛 bfs,dfs
    //bfs 常用于求从初始状态到目标状态  和 最短路径即最找到的一组解
    static int N = 21;
    static int M = N*N*N;
    static boolean[][][] vis = new boolean[N][N][N];
    static int[] ans = new int[N];
    static S[] q = new S[M];//队列
    static int h=0,t=0;//队头，队尾指针
    static int[] w = new int[3];//容量大小
    static int[] W = new int[3];//当前容量
    public static void bfs() {
        q[0] = new S(0,0,w[2]);
        vis[0][0][w[2]] = true;//初始化

        while(h<=t) {
            S s = q[h++];//出队
            gainAnswer(s);
            for(int i=0;i<3;i++) {
                for(int j=0;j<3;j++) {
                    if(i!=j) {
                        W[0] = s.a; W[1] = s.b; W[2]=s.c;
                        int tmp = Math.min(W[i],w[j]-W[j]);
                        W[i] -= tmp; W[j] += tmp;//从i倒入j
                        int a = W[0]; int b = W[1]; int c = W[2];
                        S tmp_s = new S(a,b,c);
                        if(!vis[a][b][c]) {
                            vis[a][b][c] = true;
                            q[++t] = tmp_s;//进队
                        }
                    }
                }
            }
        }
    }
    static int count= 0;
    public static void gainAnswer(S s) {
        if(s.a==0) {
            ans[count++] = s.c;
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<3;i++) {
            w[i] = sc.nextInt();
        }
        bfs();
        Arrays.sort(ans,0,count);
        for(int i=0;i<count;i++) {
            System.out.print(ans[i]+" ");
        }
    }

}
class S{
    int a;
    int b;
    int c;
    public S(int a,int b,int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
