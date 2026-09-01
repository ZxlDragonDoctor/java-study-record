package Sort;

public class Sort_2 {
    //归并排序 nlonn;
    //归并排序可以实现求逆序对数
    static int N;//记录逆序对数
    public static int[] nixu(int l, int r, int[] nums) {
        if (l == r) {
            return new int[]{nums[l]};
        }
        int mid = (l + r) / 2;
        int[] leftnums = nixu(l, mid, nums);
        int[] rigthnums = nixu(mid + 1, r, nums);
        int[] newNums = new int[leftnums.length + rigthnums.length];
        int q = 0, p = 0, m = 0;
        while (q < leftnums.length && p < rigthnums.length) {
            if(leftnums[q]>rigthnums[p]){
                newNums[m++] = rigthnums[p++];
                N += (mid-q+1);//因为左右部分都是有序的，则当左边下标为q的数大于右边某个数，
                // 意味着q到mid的值都大于右边的这个数
            }else {
                newNums[m++] = leftnums[q++];
            }
        }
        while (q < leftnums.length) {
            newNums[m++] = leftnums[q++];
        }
        while (p < rigthnums.length) {
            newNums[m++] = rigthnums[p++];
        }
        return newNums;
    }

    public static int[] mergeSort(int l, int r, int[] nums) {
        if (l == r) {
            return new int[]{nums[l]};
        }
        int mid = (l + r) / 2;
        int[] leftnums = mergeSort(l, mid, nums);
        int[] rigthnums = mergeSort(mid + 1, r, nums);
        int[] newNums = new int[leftnums.length + rigthnums.length];
        int q = 0, p = 0, m = 0;
        while (q < leftnums.length && p < rigthnums.length) {
            newNums[m++] = leftnums[q] < rigthnums[p] ? leftnums[q++] : rigthnums[p++];
        }
        while (q < leftnums.length) {
            newNums[m++] = leftnums[q++];
        }
        while (p < rigthnums.length) {
            newNums[m++] = rigthnums[p++];
        }
        return newNums;
    }

    public static void main(String[] args) {
        int nums[] = {1, 31, 23, 123, 1, 2, 3, 7};
        nums = nixu(0, nums.length - 1, nums);
        for (int i : nums) {
            System.out.println(i);
        }
        System.out.println("逆序对数：" + N);
    }
}
