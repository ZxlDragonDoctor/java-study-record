package ACM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static int N = 40010;
    static int t,f,s;
    static int a,b,n,m;
    static int[] dist = new int[N];
    static int[] q = new int[N];
    static boolean[] visted = new boolean[N];
    static int first =0,end=0;
    public static void bfs(int[][] g,int val){
        Arrays.fill(dist,-1);
        q[end++] = val;
        visted[val] = true;
        dist[val] = 0;

        while(first<=t){
            int u = q[first++];

            for(int v=1;v<=n;v++){
                if(g[u][v]!=0&&!visted[v]){
                    dist[v] = dist[u]+1;
                    q[t++] = v;
                    visted[v]=true;
                }
            }

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        f = sc.nextInt();
        s = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] g  = new int[m+1][m+1];
        while (m-->0){
            int x = sc.nextInt();
            int y = sc.nextInt();
            g[x][y] = 1;
            g[y][x] = 1;
        }
        int ans = Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            if(i==a||i==b||i==n){
                continue;
            }
            int val = i;
            int[] res = new int[3];
            bfs(g,val);
            res[0] = dist[a];
            res[1] = dist[b];
            res[2] = dist[n];
            if(dist[n]!=-1) {
                ans = Math.min(ans, t * res[0] + f * res[1] + (t + f - s) * res[2]);
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(dist[i]+",");
        }
        System.out.println(ans);
    }

}