package Sort;

public class Sort_4 {
    public static void main(String[] args) {

    }
    public class Search {
        // 二分查找
        public int binarySearch(int[] nums, int target) {
            // 中间是你要实现的代码
            int l = 0;
            int h = nums.length - 1;
            while (l <= h) {
                int mid = l + (h - l) / 2;
                if (target == nums[mid]) {
                    return mid;
                } else if (target > nums[mid]) {
                    l = mid + 1;
                } else if (target < nums[mid]) {
                    h = mid - 1;
                }
            }
            return -1; // 如果未找到目标值，返回-1
        }
    }
}
