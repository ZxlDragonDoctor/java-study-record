package 华为OD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


// 2026/9/6  华为OD  图的深度优先遍历
public class DfsAndBfs {

    List<Integer> resultList = new ArrayList<>();
    List<Integer>[]  g;
    boolean[] visted = new boolean[100] ;

    public  void dfs(int u){
        resultList.add(u);
        visted[u] = true;
        for(int v:g[u]){  //
            if(!visted[v]){
                dfs(v);
            }
        }
    }

    public Integer[] solve(int n,int[][] edge){
        // 建立邻接表
        g = new ArrayList[n+1];  //建立list数组

        // 初始化邻接表
        for(int i=0;i<=n;i++){
            g[i] = new ArrayList<>();
        }
        for(int[] t:edge){
            //无向图，双向边
            g[t[0]].add(t[1]);
            g[t[1]].add(t[0]);
        }
        // 排好序序
        for(int i=1;i<=n;i++){
            Collections.sort(g[i]);
        }

        visted = new boolean[n+1];
        resultList.clear();
        dfs(1);

        //转化维数组输出

        return resultList.toArray(new Integer[0]);


    }

    //  受限任务分配  DFS + 记忆化
    int addCost =0,returnCost = 0;
    int budget = 0; // 预算
    int cost = 0; // c成本
    int ops = 0; // 操作 数
    long[][] memo;
    boolean[] computex;

    public  long[] dfsAndMemo(int x){
        // 直接返回初始值 x == 1
        if(x == 1) return new long[]{0,0};
        // 使用记忆化，已经计算过的x的结果
        if(computex[x]) return memo[x];
        computex[x] = true;

        long bestCost = Integer.MAX_VALUE;
        long bestOps = Integer.MAX_VALUE;
        // 任务为偶数，直接减半
        if(x % 2 == 0){
            //  返回的结果
            long[] next = dfsAndMemo(x/2);
            long cost = 1 + next[0];
            long ops  = 1+ next[1];
            if(cost< bestCost || (cost == bestCost && ops < bestOps)) {
                 bestCost = cost;
                 bestOps = ops;
            }
        }else{
            // 任务为奇数， 两种处理方式
            // 注意处理ops数相同，成本最低的方法
            // 奇数 + 1
            long[] next = dfsAndMemo((x+1)/2);
            long cost = addCost +  1 + next[0];
            long ops =  2 + next[1];
            if(cost< bestCost || (cost == bestCost && ops < bestOps)) {
                bestCost = cost;
                bestOps = ops;
            }

            // 奇数 - 1
            next =  dfsAndMemo((x-1)/2);
            cost = returnCost + 1 +next[0];
            ops = 2 + next[1];
            if(cost< bestCost || (cost == bestCost && ops < bestOps)) {
                bestCost = cost;
                bestOps = ops;
            }
        }

        memo[x] = new long[]{bestCost,bestOps};
        return memo[x];


    }

    public static void main(String[] args) {
        DfsAndBfs dfsAndBfs = new DfsAndBfs();
        int n = 6;
        int[][] edges = {{1,2},{1,3},{2,4},{3,5},{3,6}};
        System.out.println(Arrays.toString(dfsAndBfs.solve(n, edges)));
    }


}
