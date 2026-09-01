package 算法设计课程答案.Test_10;

import java.util.*;

public class MaximumClique {
    static int n;                // 顶点数
    static boolean[][] graph;    // 邻接矩阵
    static List<Integer> bestClique = new ArrayList<>(); // 最大团
    static List<Integer> tempClique = new ArrayList<>(); // 当前临时团

    public static void main(String[] args) {
        // 示例图
        n = 5;
        graph = new boolean[n][n];
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(1, 2);
        addEdge(1, 3);
        addEdge(2, 3);
        addEdge(3, 4);

        findMaxClique(0);

        System.out.println("最大团大小: " + bestClique.size());
        System.out.print("最大团顶点: ");
        for (int v : bestClique) {
            System.out.print(v + " ");
        }
    }

    // 加边
    static void addEdge(int u, int v) {
        graph[u][v] = true;
        graph[v][u] = true;
    }

    // 回溯搜索
    static void findMaxClique(int start) {
        if (tempClique.size() > bestClique.size()) {
            bestClique = new ArrayList<>(tempClique);
        }

        for (int v = start; v < n; v++) {
            if (canAdd(v)) {
                tempClique.add(v);
                // 剪枝优化：如果加上剩余所有点，数量也不会超过best，直接return
                if (tempClique.size() + (n - v - 1) > bestClique.size()) {
                    findMaxClique(v + 1);
                }
                tempClique.remove(tempClique.size() - 1); // 回溯
            }
        }
    }

    // 判断是否可以将顶点v加入当前团
    static boolean canAdd(int v) {
        for (int u : tempClique) {
            if (!graph[u][v]) {
                return false;
            }
        }
        return true;
    }
}
