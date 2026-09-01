package Dp;

public class Solution_1 {
    public int maxSubArray(int[] nums) {
//        int len = nums.length;
//        int[] dp = new int[len];
//        int maxnum = nums[0];//防止只有一个元素
//        for(int i=0;i<len;i++){
//            if(maxnum<nums[i]){
//                maxnum = nums[i];
//            }
//            dp[0] = nums[i];
//            for(int j=1;j<len-i;j++){
//                dp[j] = dp[j-1] + nums[i+j];
//                if(dp[j]>maxnum){
//                    maxnum = dp[j];
//                }
//            }
//        }
//        return maxnum;
        int max = nums[0]; int dp = 0;
        for(int i=0;i<nums.length;i++){
            dp = Math.max(dp+nums[i],nums[i]);
            max = Math.max(max,dp);
        }
        return max;


    }

    public static void main(String[] args) {
        int nums[] = {-1};
        Solution_1 solution1 = new Solution_1();
        System.out.println(solution1.maxSubArray(nums));
    }
}
