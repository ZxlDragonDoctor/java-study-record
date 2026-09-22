package 华为OD;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//小牛牛超市选品
public class DoublePoint {
    public static void main(String[] args) {
        int n = 6;
        int lim = 7;
        int[] num= new int[]{
                2,3,1,2,4,3
        };
        int sum = 0;
        Queue<Integer> path = new LinkedList<>();

        int ans = Integer.MAX_VALUE;
        for(int r=0;r<num.length;r++){
            sum += num[r];
            path.offer(num[r]);
            if(sum > lim){
                int max = Integer.MIN_VALUE;
                for(int t:path){
                    max =Math.max(t,max);
                }
                if(max <= lim){
                    ans = Math.min(ans,path.size());
                }
                // 移动区间l++直到区间合小于等于lim;  贪心
                while(sum>lim){
                    sum -= path.poll();
                    max = Integer.MIN_VALUE;
                    if(sum>lim){
                        for(int t:path){
                            max =Math.max(t,max);
                        }
                        if(max <= lim){
                            ans = Math.min(ans,path.size());
                        }
                    }

                }
            }
        }
        // 修复，找不到合法区间时输出 0，不是 MAX_VALUE
        System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
    }
}
