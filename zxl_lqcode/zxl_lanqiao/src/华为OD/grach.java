package 华为OD;

import java.lang.reflect.Array;
import java.util.Arrays;

public class grach {
    public static void main(String[] args) {

    }
    // 迪杰斯特拉，朴素版
    // graph 无向有权（正）图
    public  int[] dijkstra(int[][] graph,int start){
        int n = graph.length;
        int[] dist = new int[n];
        boolean[] visted = new boolean[n];

        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;

        for(int i=0;i<n;i++){
            int u  = -1;
            for(int j=0;j<n;j++){
                if(!visted[j] && (u==-1 || dist[j] < dist[i])){
                    u = j;
                }
            }

            if(u==-1) break;
            // 此时u 就是 最短的邻接结点
            for(int j=0;j<n;j++){
                if(!visted[j] &&  graph[u][j]<Integer.MAX_VALUE && dist[u]+graph[u][j]<dist[j]){
                     dist[j] = dist[u] + graph[u][j];
                }
            }

        }
        return dist;
    }

    // Floyd
    public int[][] floyd(int[][] graph,int start){
        int n = graph.length;
        int[][] dist = new int[n][n];
        for(int i=0;i<n;i++){
            dist[i] = graph[i].clone();
        }

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][k] + dist[k][j] < dist[i][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        return dist;
    }

    //无人机巡检航线规划
    // TSP 状压 DP（旅行商问题变种）
    public int droneDp(int n,int[][] nums){
        int full = 1 << n;
        int[][] dp = new int[full][n]; // 去过full这些地方最后停在 第 j 塔的最短距离
        // 初始化
        for(int[] row:dp) Arrays.fill(row,Integer.MAX_VALUE);
        for(int i=0;i<n;i++){
            dp[1 << i][i] = nums[i][0] + nums[i][1]; // 1<=x,y<=200
        }
        // 遍历所有状态
        for(int mask=0;mask<full;mask++){
            // 选择停在哪一个塔
            for(int i=0;i<n;i++){
                // mask必须包含停留在的塔
                if((mask & (1<<i)) == 0) continue; // 表示第 i 个塔没去过
                if(dp[mask][i] == Integer.MAX_VALUE) continue; // 表示这个塔不可达

                // 去没去过的塔
                for(int j=0;j<n;j++){
                    if((mask & (1<<j)) != 0) continue; // 表示第 j 个塔已经去过

                    // 核心， 状态转移
                    int newMask = mask | (1 << j);
                    int core =  dp[mask][i] + Math.abs(nums[i][0]-nums[j][0]) + Math.abs(nums[i][1]- nums[j][1]);
                    dp[newMask][j] = Math.min(dp[newMask][j],core);
                }
            }

        }

        // 求最短路径，全去完后，任意一个塔上
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            ans = Math.min(ans,dp[full-1][i]);
        }

        return ans;

    }


}
