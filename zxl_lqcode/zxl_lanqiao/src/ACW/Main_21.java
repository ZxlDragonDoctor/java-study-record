package ACW;

import java.util.Arrays;

public class Main_21 {
    //迪杰斯特拉算法 基于领结矩阵
    static int N = 100010;
    static int[] dist = new int[N];//路径数组
    static int INF = Integer.MAX_VALUE;
    public static void dijkstra(int g[][],int start) {
        int n =  g.length;
        boolean[] visted = new boolean[n];
        Arrays.fill(dist,INF);
        dist[start] = 0;//初始化

        for(int i=0;i<n;i++) {
            int u = -1;
            for(int j=0;j<n;j++) {
                if(visted[j]==false&&(u==-1||dist[j]<dist[u])) {
                    u = j;
                }
            }
            visted[u] = true;
            for(int v=0;v<n;v++) {
                if(visted[v]==false&&g[u][v]!=INF&&dist[v]>dist[u]+g[u][v]) {
                    dist[v] = dist[u]+g[u][v];
                }
            }
        }

    }
    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {0, 2, INF, 6, INF},
                {2, 0, 3, 8, 5},
                {INF, 3, 0, INF, 7},
                {6, 8, INF, 0, 9},
                {INF, 5, 7, 9, 0}
        };
        int start = 0;
        dijkstra(graph, start);
        for(int i=0;i<5;i++){
            System.out.println(dist[i]);
        }
    }
}
