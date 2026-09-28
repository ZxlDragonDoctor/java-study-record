package 华为OD;


import java.util.Arrays;
import java.util.Comparator;

// 华为OD 9/23号，自由摄影师的最大收益
// 排序+DP
public class SortAndDP {
    public static long solve(int[] times, int[] deadlines, long[] profits) {
        // 按照截止日期升序排序
        int n = times.length;
        long[][] jobs = new long[n][3];
        long totalTime = 0;
        long maxDeadline = 0;

        for(int i=0;i<n;i++){
            jobs[i][0] = times[i];
            jobs[i][1] = deadlines[i];
            jobs[i][2] = profits[i];
            totalTime += times[i];
            maxDeadline = Math.max(maxDeadline,jobs[i][1]);
        }

        //按照截止日期升序
        Arrays.sort(jobs, Comparator.comparingLong(job->job[1]));

        // 设置dp最大值，总工作时间不能超过最大截止日期
        int capacity = (int) Math.min(totalTime,maxDeadline);

        long[] dp = new long[capacity+1];

        for(long[] job:jobs){
            int deadline = (int)Math.min(job[1],maxDeadline);
            int time = (int)job[0];
            long profit = job[2];
            //倒叙枚举
            for(int day=deadline;day>=time;day--){
                dp[day] = Math.max(dp[day],dp[day-time]+profit);
            }
        }

        long answer = 0;
        for(long value:dp){
            answer = Math.max(answer,value);
        }

        return  answer;
    }
}
