package 算法设计课程答案;

import java.util.*;

public class KnapsackBranchAndBound {

    static class Item implements Comparable<Item> {
        int weight, value;
        double unitValue;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
            this.unitValue = (double) value / weight;
        }

        @Override
        public int compareTo(Item other) {
            return Double.compare(other.unitValue, this.unitValue); // 按单位价值降序
        }
    }

    static class Node {
        int level;          // 当前处理到第几个物品
        int profit;         // 当前总价值
        int weight;         // 当前总重量
        double bound;       // 上界估计

        public Node(int level, int profit, int weight, double bound) {
            this.level = level;
            this.profit = profit;
            this.weight = weight;
            this.bound = bound;
        }
    }

    static int knapsack(int capacity, Item[] items) {
        Arrays.sort(items); // 按单位价值排序

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Double.compare(b.bound, a.bound)); // 大顶堆
        Node u, v;
        int n = items.length;
        int maxProfit = 0;

        v = new Node(0, 0, 0, bound(0, 0, 0, items, capacity));
        pq.offer(v);

        while (!pq.isEmpty()) {
            v = pq.poll();

            if (v.bound <= maxProfit) continue;

            // 尝试包含下一个物品
            if (v.level < n) {
                Item item = items[v.level];

                // 分支1：选择该物品
                int nextWeight = v.weight + item.weight;
                int nextProfit = v.profit + item.value;
                if (nextWeight <= capacity && nextProfit > maxProfit) {
                    maxProfit = nextProfit;
                }
                u = new Node(v.level + 1, nextProfit, nextWeight,
                             bound(v.level + 1, nextWeight, nextProfit, items, capacity));
                if (u.bound > maxProfit) {
                    pq.offer(u);
                }

                // 分支2：不选择该物品
                u = new Node(v.level + 1, v.profit, v.weight,
                             bound(v.level + 1, v.weight, v.profit, items, capacity));
                if (u.bound > maxProfit) {
                    pq.offer(u);
                }
            }
        }

        return maxProfit;
    }

    static double bound(int level, int weight, int profit, Item[] items, int capacity) {
        if (weight >= capacity) return 0;

        double bound = profit;
        int n = items.length;
        int totalWeight = weight;

        for (int i = level; i < n && totalWeight < capacity; i++) {
            if (totalWeight + items[i].weight <= capacity) {
                totalWeight += items[i].weight;
                bound += items[i].value;
            } else {
                // 只装一部分
                bound += (capacity - totalWeight) * items[i].unitValue;
                break;
            }
        }
        return bound;
    }

    public static void main(String[] args) {
        int capacity = 50;
        Item[] items = {
            new Item(10, 60),
            new Item(20, 100),
            new Item(30, 120)
        };

        int maxValue = knapsack(capacity, items);
        System.out.println("最大价值为: " + maxValue);
    }
}
