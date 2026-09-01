package letcode;

public class Main_01 {
    public static void main(String[] args) {

    }

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int Max = 110;
        int[] dp = new int[Max];
//        1.首元素不取，尾元素取
        int len = nums.length;
        for (int i = 3; i <= len - 2; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[len-1];
    }
}
