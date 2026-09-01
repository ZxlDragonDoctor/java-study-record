package 算法设计课程答案.Test_8;

import java.util.*;

class KEdge implements Comparable<KEdge> {
    int from, to, weight;

    public KEdge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    // 按边权升序排序
    public int compareTo(KEdge other) {
        return this.weight - other.weight;
    }
}

class UnionFind {
    int[] parent;

    public UnionFind(int n) {
        parent = new int[n];
        // 初始化：每个顶点是一个集合的根
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]); // 路径压缩
        return parent[x];
    }

    public boolean union(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fx == fy) return false; // 已经连通
        parent[fx] = fy; // 合并集合
        return true;
    }
}

public class KruskalMST {
    public static int kruskal(int n, List<KEdge> KEdges) {
        Collections.sort(KEdges); // 按权值升序排列
        UnionFind uf = new UnionFind(n);
        int totalCost = 0;
        int KEdgeCount = 0;

        for (KEdge KEdge : KEdges) {
            if (uf.union(KEdge.from, KEdge.to)) {
                totalCost += KEdge.weight;
                KEdgeCount++;
                if (KEdgeCount == n - 1) break; // 构造出n-1条边即可
            }
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int n = 5; // 顶点数（编号从0开始）
        List<KEdge> KEdges = new ArrayList<>();
        
        // 添加边：from, to, weight
        KEdges.add(new KEdge(0, 1, 2));
        KEdges.add(new KEdge(0, 3, 6));
        KEdges.add(new KEdge(1, 2, 3));
        KEdges.add(new KEdge(1, 3, 8));
        KEdges.add(new KEdge(1, 4, 5));
        KEdges.add(new KEdge(2, 4, 7));
        KEdges.add(new KEdge(3, 4, 9));

        int cost = kruskal(n, KEdges);
        System.out.println("最小生成树的总权值: " + cost);
    }
}
