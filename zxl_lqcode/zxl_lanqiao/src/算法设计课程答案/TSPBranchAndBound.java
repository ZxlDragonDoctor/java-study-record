package 算法设计课程答案;

import java.util.*;

public class TSPBranchAndBound {
    static int N = 4; // 城市数
    static int[][] cost = {
        { 0, 30, 6, 4 },
        { 30, 0, 5, 10 },
        { 6, 5, 0, 20 },
        { 4,10,20, 0 }
    };

    static class Node implements Comparable<Node> {
        List<Integer> path;
        boolean[] visited;
        int costSoFar;
        int bound;

        Node(List<Integer> path, boolean[] visited, int costSoFar, int bound) {
            this.path = new ArrayList<>(path);
            this.visited = visited.clone();
            this.costSoFar = costSoFar;
            this.bound = bound;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.bound, o.bound);
        }
    }

    static int calculateBound(List<Integer> path, boolean[] visited, int costSoFar) {
        int bound = costSoFar;
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < N; j++) {
                    if (i != j && (!visited[j] || j == 0)) {
                        min = Math.min(min, cost[i][j]);
                    }
                }
                bound += min;
            }
        }
        return bound;
    }

    public static void solveTSP() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        List<Integer> startPath = new ArrayList<>();
        startPath.add(0);
        boolean[] visited = new boolean[N];
        visited[0] = true;

        int bound = calculateBound(startPath, visited, 0);
        pq.offer(new Node(startPath, visited, 0, bound));

        int minCost = Integer.MAX_VALUE;
        List<Integer> bestPath = new ArrayList<>();

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (node.path.size() == N) {
                int totalCost = node.costSoFar + cost[node.path.get(N - 1)][0];
                if (totalCost < minCost) {
                    minCost = totalCost;
                    bestPath = new ArrayList<>(node.path);
                    bestPath.add(0); // 回到起点
                }
                continue;
            }

            int last = node.path.get(node.path.size() - 1);
            for (int i = 0; i < N; i++) {
                if (!node.visited[i]) {
                    List<Integer> newPath = new ArrayList<>(node.path);
                    newPath.add(i);

                    boolean[] newVisited = node.visited.clone();
                    newVisited[i] = true;

                    int newCost = node.costSoFar + cost[last][i];
                    int newBound = calculateBound(newPath, newVisited, newCost);

                    if (newBound < minCost) {
                        pq.offer(new Node(newPath, newVisited, newCost, newBound));
                    }
                }
            }
        }

        System.out.println("最短路径长度: " + minCost);
        System.out.println("最短路径: " + bestPath);
    }

    public static void main(String[] args) {
        solveTSP();
    }
}
