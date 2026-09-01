package com.zxl.RestAssured;


import java.util.Arrays;

/**
 * 题目： 循环滚动数组
 * 答题要求：
 *     1. 要求实现对数组（列表）元素循环滚动的算法。
 *     2. 使用Java 实现。
 *     3. 要求必须使用以下模版（不使用模版，自动判零分）。
 * 题目要求：
 *     1. 给定一个包含若干元素的数组(列表) nums
 *     2. 将数组中的元素依次向左进行顺时针滚动 k 个位置， k 为非负数
 *     3. 滚动出去的首元素按照滚动顺序放到尾元素之后的位置
 *     4. 除代码实现区域外，其它任何代码不可编辑改动，否则零分。
 *     - 示例：
 *     输入: Object[] nums = [1,2,3,4,5,6,7], k = 4
 *     输出: [5,6,7,1,2,3,4]
 *     解释:
 *     向左轮转 1 步: [2,3,4,5,6,7,1]
 *     向左轮转 2 步: [3,4,5,6,7,1,2]
 *     向左轮转 3 步: [4,5,6,7,1,2,3]
 *     向左轮转 4 步: [5,6,7,1,2,3,4]
 */
public class Part1Topic {
    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        cyclicRolling(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 实现数组元素循环滚动的方法
     * @param nums 待滚动的数组
     * @param k 滚动的步数
     */
    public static void cyclicRolling(Object[] nums, int k) {
        //在此处编写代码
        while (k-->0){
            Object lef = nums[0];
            for(int i=0;i<nums.length-1;i++){
                nums[i]=nums[i+1];
            }
            nums[nums.length-1]=lef;
        }

    }
}
