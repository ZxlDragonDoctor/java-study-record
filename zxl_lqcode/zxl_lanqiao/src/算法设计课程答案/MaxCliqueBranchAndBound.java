package 算法设计课程答案;

import java.util.*;

public class MaxCliqueBranchAndBound {

    static int n;                      // 顶点数
    static int[][] graph;             // 邻接矩阵
    static int maxSize = 0;           // 当前最大团大小
    static List<Integer> bestClique;  // 最大团记录

    public static void main(String[] args) {
        // 示例图：顶点编号从0开始，邻接矩阵
        n = 5;
        graph = new int[][]{
                // 1  2  3  4  5
                {0, 1, 0, 1, 1}, // 1
                {1, 0, 1, 0, 1}, // 2
                {0, 1, 0, 0, 1}, // 3
                {1, 0, 0, 0, 1}, // 4
                {1, 1, 1, 1, 0}  // 5
        };

        bestClique = new ArrayList<>();
        List<Integer> currentClique = new ArrayList<>();
        List<Integer> candidates = new ArrayList<>();
        for (int i = 0; i < n; i++) candidates.add(i);

        branchAndBound(0, currentClique, candidates);
        System.out.println("最大团大小: " + maxSize);
        System.out.println("最大团顶点: " + bestClique);
    }

    // 分支限界法主体
    static void branchAndBound(int level, List<Integer> currentClique, List<Integer> candidates) {
        if (candidates.isEmpty()) {
            if (currentClique.size() > maxSize) {
                maxSize = currentClique.size();
                bestClique = new ArrayList<>(currentClique);
            }
            return;
        }

        while (!candidates.isEmpty()) {
            // 剪枝：如果当前团 + 候选还不如 maxSize，提前终止
            if (currentClique.size() + candidates.size() <= maxSize) return;

            int v = candidates.get(0);
            candidates.remove(0);

            // 判断是否能加入团
            boolean canJoin = true;
            for (int u : currentClique) {
                if (graph[u][v] == 0) {
                    canJoin = false;
                    break;
                }
            }

            if (canJoin) {
                currentClique.add(v);
                // 构造新候选集：v 的所有邻接点中同时也是 candidates 中的点
                List<Integer> newCandidates = new ArrayList<>();
                for (int u : candidates) {
                    if (graph[v][u] == 1) newCandidates.add(u);
                }

                branchAndBound(level + 1, currentClique, newCandidates);
                currentClique.remove(currentClique.size() - 1);
            }
        }
    }
}
