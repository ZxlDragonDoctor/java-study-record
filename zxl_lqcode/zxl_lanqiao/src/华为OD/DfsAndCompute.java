package 华为OD;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 分析电网负载均衡   BFS + 队列 + 路径存储
// TODO: 注意 这种连接结点的图论，首先要看他是有向边还是无向边
public class DfsAndCompute {
    public static void main(String[] args) {
        int[] num = new int[]{
                100,200,150,50,300
        };
        int[][] g = new int[][]{
                {0,1},
                {1,2},
                {3,4}
        };
        // 如果 无边则返回-1
        //因为是无向图，需要建立邻接表(数组+链表)
        List<Integer>[] grap = new ArrayList[5];
        for(int i=0;i<grap.length;i++){
            grap[i] = new ArrayList<>();
        }
        for(int i=0;i<g.length;i++){
            grap[g[i][0]].add(g[i][1]);
            grap[g[i][1]].add(g[i][0]);
        }
        // 链表+链表
        // 建无向邻接表
//        List<List<Integer>> adj = new ArrayList<>();
//        for (int i = 0; i < num.length; i++) adj.add(new ArrayList<>());
//        for (int[] e : g) {
//            adj.get(e[0]).add(e[1]);
//            adj.get(e[1]).add(e[0]);  // 反向也要加
//        }
        boolean[] visted = new boolean[5];
        // 记录路劲
        List<Integer> path = new ArrayList<>();
        // 记录每路径的最大补均衡度
        int ans = Integer.MIN_VALUE;
        // 从零开始
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<num.length;i++){
            if(visted[i]) continue;  // 这个节点已被之前的路径访问过
            // 检查每一个节点作为头结点
            path.clear();  //清空上一条路径
            queue.clear(); //
            queue.offer(i);  // 当前路径头节点
            visted[i] =  true;
            path.add(i);
            while(!queue.isEmpty()){
                int t = queue.poll();
//                for(int j=0;j<g.length;j++){
////                     if(g[j][0] == t && !visted[g[j][1]]){
////                         queue.offer(g[j][1]);
////                         path.add(g[j][1]);  //
////                         visted[g[j][1]] = true;
////                     }
////                }
                // 遍历无向图列表
                for(int nxt:grap[t]){
                    if(!visted[nxt]){
                        queue.offer(nxt);
                        path.add(nxt);
                        visted[nxt] = true;
                    }
                }
            }
            // 处理结果
            if(path.size()<2) continue;
            // 计算不均衡度
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for(int j=0;j<path.size();j++){
                max = Math.max(num[path.get(j)],max);
                min = Math.min(num[path.get(j)],min);
            }
            ans = Math.max((max-min)*path.size(),ans);
        }

        // 输出结果
        // 无有效区结果返回-1
        ans = ans == Integer.MIN_VALUE?-1:ans;
        System.out.println(ans);
    }
}
