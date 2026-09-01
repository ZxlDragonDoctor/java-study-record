package 算法设计课程答案.Test_10;

import java.util.*;

public class ZeroOneKnapsack {
    static class Item implements Comparable<Item> {
        int weight, value;
        double ratio;

        Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
            this.ratio = (double) value / weight;
        }

        @Override
        public int compareTo(Item other) {
            return Double.compare(other.ratio, this.ratio); // 按单位价值降序
        }
    }

    static int n, C;
    static Item[] items;
    static int bestV = 0;

    public static void main(String[] args) {
        // 示例数据
        items = new Item[]{
            new Item(2, 40),
            new Item(3, 50),
            new Item(4, 65),
            new Item(5, 35),
            new Item(1, 10)
        };
        C = 10; // 背包容量
        n = items.length;

        Arrays.sort(items); // 预处理，按单位价值降序

        backtrack(0, 0, 0);

        System.out.println("最大总价值: " + bestV);
    }

    static void backtrack(int i, int currW, int currV) {
        if (i == n) {
            if (currV > bestV) {
                bestV = currV;
            }
            return;
        }

        // 左子树：选择第i个物品
        if (currW + items[i].weight <= C) {
            backtrack(i + 1, currW + items[i].weight, currV + items[i].value);
        }

        // 右子树：不选择第i个物品
        if (bound(i + 1, currW, currV) > bestV) {
            backtrack(i + 1, currW, currV);
        }
    }

    // 上界函数：用部分装填法估计还能拿到的最大价值
    static double bound(int i, int currW, int currV) {
        double totalV = currV;
        int totalW = currW;

        while (i < n && totalW + items[i].weight <= C) {
            totalW += items[i].weight;
            totalV += items[i].value;
            i++;
        }

        if (i < n) {
            // 还能装一部分
            totalV += (C - totalW) * items[i].ratio;
        }

        return totalV;
    }
}
