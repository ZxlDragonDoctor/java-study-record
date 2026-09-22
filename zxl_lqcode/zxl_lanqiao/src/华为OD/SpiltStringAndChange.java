package 华为OD;

import java.util.ArrayList;
import java.util.List;

// 末世分配资源包：nums 切成 k 段连续子数组，最小化最大段和
// 回溯 + 分割；适合小数据（n 约 ≤20）
public class SpiltStringAndChange {

    static int k = 0;
    static int[] nums;
    static List<Integer> misum = new ArrayList<>();
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        nums = new int[]{4, 3, 6, 7, 9};
        k = 2;
        dfs(1, -1, 0);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    /** cur: 当前填第几段(1-based); preIndex: 上一段结束下标; startIndex: 本段起始下标 */
    static void dfs(int cur, int preIndex, int startIndex) {
        // 剩余元素不够再分出 (k-cur+1) 段
        if (nums.length - startIndex < k - cur + 1) {
            return;
        }

        if (cur == k) {
            int sum = 0;
            for (int i = startIndex; i < nums.length; i++) {
                sum += nums[i];
            }
            misum.add(sum);
            int max = Integer.MIN_VALUE;
            for (int num : misum) {
                max = Math.max(num, max);
            }
            ans = Math.min(ans, max);
            misum.remove(misum.size() - 1); // 回溯清理
            return;
        }

        // 本段结束下标 i：后面还要放 (k-cur) 段，至少各留 1 个
        int lastEnd = nums.length - (k - cur) - 1;
        for (int i = startIndex; i <= lastEnd; i++) {
            int sum = 0;
            for (int j = preIndex + 1; j <= i; j++) {
                sum += nums[j];
            }
            misum.add(sum);
            dfs(cur + 1, i, i + 1); // 关键：preIndex 传 i，不是 startIndex
            misum.remove(misum.size() - 1);
        }
    }
}