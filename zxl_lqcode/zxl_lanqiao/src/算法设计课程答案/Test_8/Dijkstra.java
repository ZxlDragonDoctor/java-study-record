package 算法设计课程答案.Test_8;

import java.util.*;

class Edge {
    int to;
    double weight;

    public Edge(int to, double weight) {
        this.to = to;
        this.weight = weight;
    }
}

public class Dijkstra {

    public static double[] dijkstra(List<List<Edge>> graph, int source) {
        int n = graph.size();
        double[] dist = new double[n];
        Arrays.fill(dist, Double.POSITIVE_INFINITY);
        dist[source] = 0;

        // 最小堆：按当前路径长度排序
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> a[1]));
        pq.offer(new int[]{source, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0];
            double currentDist = dist[u];

            for (Edge edge : graph.get(u)) {
                int v = edge.to;
                double weight = edge.weight;

                // 松弛操作
                if (currentDist + weight < dist[v]) {
                    dist[v] = currentDist + weight;
                    pq.offer(new int[]{v, (int) dist[v]});
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int n = 5; // 顶点数
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // 添加边 (有向图)
        graph.get(0).add(new Edge(1, 10));
        graph.get(0).add(new Edge(2, 3));
        graph.get(1).add(new Edge(2, 1));
        graph.get(1).add(new Edge(3, 2));
        graph.get(2).add(new Edge(1, 4));
        graph.get(2).add(new Edge(3, 8));
        graph.get(2).add(new Edge(4, 2));
        graph.get(3).add(new Edge(4, 7));
        graph.get(4).add(new Edge(3, 9));

        int source = 0;
        double[] distances = dijkstra(graph, source);

        System.out.println("源点到各点的最短路径长度：");
        for (int i = 0; i < distances.length; i++) {
            System.out.println("从 " + source + " 到 " + i + " 的最短路径长度为: " + distances[i]);
        }
    }
}
