package ACW;


import java.io.IOException;

import  java.util.*;

public class Main_25 {
    //ac.扫雷 dfs,bfs,并查集
    static int N = 310;
    static char[][] s = new char[N][N];
    static int[][] g = new int[N][N];
    static int[] dx = {0,1,1,1,0,-1,-1,-1};
    static int[] dy = {1,1,0,-1,-1,-1,0,1};
    public  static void dfs(int x,int y,int n){
        int t = g[x][y];
        g[x][y]=-1;

        if(t!=0){//记得将g初始化
            return;
        }
        for(int i=0;i<8;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0&&nx<n&&ny>=0&&ny<n&&g[nx][ny]!=-1){
                dfs(nx,ny,n);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            for(int j=0;j<n;j++){
                String str = sc.next();
                char[] arr = str.toCharArray();
                s[j] = Arrays.copyOf(arr,n);
            }
            for(int a=0;a<n;a++){
                for(int b=0;b<n;b++){
                    if(s[a][b]=='*') g[a][b] = -1;
                    else {
                        g[a][b]=0;
                        for(int d=0;d<8;d++){
                            int nx = a + dx[d];
                            int ny = b + dy[d];
                            if(nx>=0&&nx<n&&ny>=0&&ny<n&&s[nx][ny]=='*'){
                                g[a][b]++;//初始化 0~8
                            }
                        }
                    }
                }
            }
            int res = 0;
            for(int a=0;a<n;a++){
                for(int b=0;b<n;b++){
                    if(g[a][b]==0){
                        dfs(a,b,n);
                        res++;
                    }
                }
            }
            for(int a=0;a<n;a++){
                for(int b=0;b<n;b++){
                    if(g[a][b]!=-1){
                        res++;
                    }
                }
            }
             System.out.println("Case #" +(i+1) +": "+res );
        }
    }
}
