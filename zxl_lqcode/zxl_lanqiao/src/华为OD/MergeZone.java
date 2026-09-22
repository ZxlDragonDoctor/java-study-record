package 华为OD;


import java.util.Arrays;

// LLM推理批次最大化
// 合并区间变体类型
public class MergeZone {
    public static void main(String[] args) {
//        int[][] arr = new int[][]{
//                {1,3},
//                {2,5},
//                {4,7},
//                {6,9},
//                {8,10},
//                {11,12}
//        };
        int[][] arr = new int[][]{
                {1,3},
                {2,4},
                {3,3},
                {4,4}
        };
        if(arr.length==1) System.out.println(1);
        // TODO: 坑点，必须按照右端点升序(贪心)，否则会出现错误
        Arrays.sort(arr,(a,b)->a[1]-b[1]);
        int end = arr[0][1];
        int ans = 1;
        for(int i=1;i<arr.length;i++){
             if(arr[i][0] > end){
                 ans++;
                 end = arr[i][1];
             }
        }
        System.out.println(ans);
    }
}
