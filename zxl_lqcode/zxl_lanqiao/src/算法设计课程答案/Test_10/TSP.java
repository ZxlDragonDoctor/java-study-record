package 算法设计课程答案.Test_10;

import java.util.*;

public class TSP {
    static int n;                 // 城市数量
    static int[][] distance;       // 距离矩阵
    static boolean[] visited;      // 城市是否访问过
    static int bestCost = Integer.MAX_VALUE; // 当前最短总路程
    static List<Integer> bestPath = new ArrayList<>(); // 最优路径
    static List<Integer> currPath = new ArrayList<>(); // 当前路径

    public static void main(String[] args) {
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        // 示例数据：城市数量和城市间距离
        distance = new int[][]{
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };
        n = distance.length;
        visited = new boolean[n];

        visited[0] = true; // 从城市0出发
        currPath.add(0);

        dfs(0, 0, 0);

        System.out.println("最短路程: " + bestCost);
        System.out.print("最优路线: ");
        for (int city : bestPath) {
            System.out.print(city + " ");
        }
        System.out.println("0"); // 回到起点
    }

    // currentCity: 当前所在城市
    // count: 已经走过的城市数
    // currCost: 当前总路程
    static void dfs(int currentCity, int count, int currCost) {
        if (count == n - 1) { // 已经走了n-1条边（所有城市走过一次）
            int totalCost = currCost + distance[currentCity][0]; // 回到起点
            if (totalCost < bestCost) {
                bestCost = totalCost;
                bestPath = new ArrayList<>(currPath);
            }
            return;
        }

        for (int nextCity = 0; nextCity < n; nextCity++) {
            if (!visited[nextCity] && distance[currentCity][nextCity] > 0) {
                visited[nextCity] = true;
                currPath.add(nextCity);

                int nextCost = currCost + distance[currentCity][nextCity];

                // 剪枝：如果当前累计路程已经超过了当前最优值，则不继续
                if (nextCost < bestCost) {
                    dfs(nextCity, count + 1, nextCost);
                }

                visited[nextCity] = false;
                currPath.remove(currPath.size() - 1); // 回溯
            }
        }
    }
}
