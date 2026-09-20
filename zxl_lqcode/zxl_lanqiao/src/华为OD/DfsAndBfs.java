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


    public static void main(String[] args) {
        DfsAndBfs dfsAndBfs = new DfsAndBfs();
        int n = 6;
        int[][] edges = {{1,2},{1,3},{2,4},{3,5},{3,6}};
        System.out.println(Arrays.toString(dfsAndBfs.solve(n, edges)));
    }

}
