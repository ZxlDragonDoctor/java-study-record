package 算法设计课程答案.Test_8;

import java.util.*;

class Item {
    int weight;
    int value;
    
    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
    
    // 计算单位价值
    public double valuePerWeight() {
        return (double) value / weight;
    }
}

public class FractionalKnapsack {

    // 贪心算法实现分数背包
    public static double getMaxValue(List<Item> items, int capacity) {
        // 按单位价值从高到低排序
        items.sort((a, b) -> Double.compare(b.valuePerWeight(), a.valuePerWeight()));
        
        double totalValue = 0.0;  // 当前背包中物品总价值
        int remainingCapacity = capacity;
        
        for (Item item : items) {
            if (remainingCapacity == 0) break;  // 背包装满了
            if (item.weight <= remainingCapacity) {
                // 装入整个物品
                totalValue += item.value;
                remainingCapacity -= item.weight;
            } else {
                // 装入部分物品
                totalValue += item.valuePerWeight() * remainingCapacity;
                remainingCapacity = 0;  // 背包装满
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        // 示例数据
        List<Item> items = new ArrayList<>();
        items.add(new Item(10, 60));  // 单位价值 6.0
        items.add(new Item(20, 100)); // 单位价值 5.0
        items.add(new Item(30, 120)); // 单位价值 4.0
        
        int capacity = 50;
        
        double maxValue = getMaxValue(items, capacity);
        System.out.println("最大可获得价值为: " + maxValue);
    }
}
