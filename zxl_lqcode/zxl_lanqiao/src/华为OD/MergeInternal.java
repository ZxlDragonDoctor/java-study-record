package 华为OD;

import java.util.*;

// 华为OD，2026/9/23机考
// 区间调度 获得最大利润
// 错误解法
public class MergeInternal {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param times long长整型ArrayList
     * @param deadlines long长整型ArrayList
     * @param profits long长整型ArrayList
     * @return long长整型
     */
    public long maxProfit (ArrayList<Long> times, ArrayList<Long> deadlines, ArrayList<Long> profits) {
        // write code here
        // 合并区间
        int n = times.size();
        List<long[]> m = new ArrayList();
        for(int i=0;i<n;i++){
            long start = deadlines.get(i) - times.get(i) + 1;
            long end = deadlines.get(i);
            m.add(new long[]{start,end,i});
        }
        // 处理下表映射
        long ans = 0;
        long[][] array = m.toArray(new long[0][]);
        // 去重，找最大利润
        Arrays.sort(array,(a,b)-> Long.compare(a[0],b[0]));
        long start = array[0][0];
        long end = array[0][1];
        long index = array[0][2];
        for(int i=1;i<array.length;i++){
            if(end>=array[i][0]){  //重合，取利润最大的区间
                //
                long t1 = profits.get((int)array[i][2]);
                long t2 = profits.get((int)index);
                if(t1>t2){
                    start = array[i][0];
                    end = array[i][1];
                    index = array[i][2];
                }
            }else{ // 不重叠加上一个
                ans += profits.get((int)index);
                start = array[i][0];
                end = array[i][1];
            }
        }

        ans += profits.get((int) index);

        return ans;

    }
}