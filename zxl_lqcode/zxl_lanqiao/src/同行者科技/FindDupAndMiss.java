package 同行者科技;

import java.util.Scanner;

public class FindDupAndMiss {
    //1000个整数，数值的范围是[0,999]，有且只有2个相同的数，请编写程序找出来
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 1000;
        int[] arr = new int[n];
        int xorAll = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            xorAll ^= arr[i];
        }
        int xorOnce = 0;
        for (int i = 0; i < 1000; i++) xorOnce ^= i;
        int diff = xorAll ^ xorOnce;

        int mask = diff & -diff;
        int group = 0;
        for (int v : arr) if ((v & mask) != 0) group ^= v;
        for (int i = 0; i < 1000; i++) if ((i & mask) != 0) group ^= i;

        int a = group;
        int b = diff ^ a;

        int cntA = 0, cntB = 0;
        for (int v : arr) {
            if (v == a) cntA++;
            if (v == b) cntB++;
        }
        int dup = cntA == 2 ? a : b;
        int miss = dup == a ? b : a;

        System.out.println(dup + " " + miss);
    }
}