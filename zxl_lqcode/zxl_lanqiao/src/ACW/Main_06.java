package ACW;

class Main_06{
    //LeetCode.动态规划.打家劫舍
    static int Max = 110;
    static int[] dp = new int[Max];
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-2] + nums[i],dp[i-1]);
        }
        int res = 0;
        for(int i=0;i<nums.length;i++){
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}