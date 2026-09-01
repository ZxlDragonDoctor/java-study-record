package ACW;

import java.util.Arrays;
import java.util.Scanner;

public class Main_15 {
    //ac.火柴排队 离散化，映射，求归并求逆序对
    static int N = 100010;
    static int n;
    static int[] a = new int[N];
    static int[] b = new int[N];
    static int[] c = new int[N];//存映射后的数组
    static int[] p = new int[N]; //存离散化过程中的数组
    static int mod = 99999997;

    public static int binaryFind(int x) {
        int l = 1, r = n;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (p[mid] >= x) r = mid;
            else l = mid + 1;
        }
        return r;
    }

    public static void work(int[] a) {
        for (int i = 1; i <= n; i++) {
            p[i] = a[i];
        }
        Arrays.sort(p,1,n+1);//升序
        //！！！！！！！！fromIndex<=a数组<toIndex "大部分排序都是前开后闭"
        //二分查找下标
        for (int i = 1; i <= n; i++) {
            a[i] = binaryFind(a[i]);
        }
    }

    public static int mersage(int[] b, int l, int r) {
        while (l >= r) {
            return 0;
        }
        int mid = (l + r) >> 1;
        int res = (mersage(b, l, mid) + mersage(b, mid + 1, r)) % mod;
        int q = l, t = mid + 1, m = 0;
        while (q <= mid && t <= r) {
            if (b[q] < b[t]) {
                p[m++] = b[q++];
            } else {
                res = (res + mid - q + 1) % mod;
                p[m++] = b[t++];
            }
        }
        while (q <= mid) {
            p[m++] = b[q++];
        }
        while (t <= r) {
            p[m++] = b[t++];
        }
        for (int i = l, j = 0; j < m; i++, j++) {
            b[i] = p[j];//传回原数组
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            b[i] = sc.nextInt();
        }
        work(a);
        work(b);//离散化
        //映射，让a数组与他的下标映射，b数组查表得到映射后的数组
        for (int i = 1; i <= n; i++) {
            c[a[i]] = i;//映射下标
        }
        for (int i = 1; i <= n; i++) {
            b[i] = c[b[i]]; //查表的b数组
        }
        //求逆序对数 这里用归并排序
        int res = mersage(b, 1, n);
        System.out.println(res);
    }
}
