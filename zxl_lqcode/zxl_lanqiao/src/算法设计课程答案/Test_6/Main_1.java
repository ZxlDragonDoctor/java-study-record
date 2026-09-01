package 算法设计课程答案.Test_6;

import java.util.Arrays;

public class Main_1 {
    public static void main(String[] args) {
        int[] a = {2,4,1,7,12,3};
        int[] ints = guiBin(a, 0, a.length - 1);
        System.out.println(Arrays.toString(ints));
    }
    public static int[] guiBin(int[] t, int l, int r) {

        // 边界条件处理
        if (l >= r) {
            return Arrays.copyOfRange(t, l, r + 1);
        }

        // 计算中间点
        int mid = (l + r) >> 1;

        // 递归拆分
        int[] left = guiBin(t, l, mid);
        int[] right = guiBin(t, mid + 1, r);

        // 合并两个有序数组
        return merge(left, right);
    }

    private static int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int p = 0, q = 0, i = 0;

        // 合并逻辑
        while (p < a.length && q < b.length) {
            if (a[p] <= b[q]) {
                c[i++] = a[p++];
            } else {
                c[i++] = b[q++];
            }
        }

        // 处理剩余元素
        while (p < a.length) {
            c[i++] = a[p++];
        }
        while (q < b.length) {
            c[i++] = b[q++];
        }

        return c;
    }

}
