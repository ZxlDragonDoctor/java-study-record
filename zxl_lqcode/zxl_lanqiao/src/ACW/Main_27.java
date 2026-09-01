package ACW;

import java.util.*;

public class Main_27 {
    //ac.奶酪
    static int N = 1010;
    static int[] s = new int[N];
    static int[] rank = new int[N];

    public static void init(int n) {
        for (int i = 0; i <= n; i++) {
            s[i] = i;
            rank[i] = 0;
        }
    }

    public static int find(int i) {
        if (s[i] != i) {
            s[i] = find(s[i]);
        }
        return s[i];
    }

    public static void union(int a, int b) {
        int h = find(a);
        int t = find(b);
        if (h == t) {
            return;
        }
        if (rank[h] < rank[t]) {
            s[h] = t;
        } else if (rank[h] > rank[t]) {
            s[t] = h;
        } else {
            s[t] = h;
            rank[t]++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n, h, r;
            n = sc.nextInt();
            h = sc.nextInt();
            r = sc.nextInt();
            init(n + 1);
            int[] x = new int[n + 1];
            int[] y = new int[n + 1];
            int[] z = new int[n + 1];

            for (int j = 1; j <= n; j++) {
                x[j] = sc.nextInt();
                y[j] = sc.nextInt();
                z[j] = sc.nextInt();
                if (Math.abs(z[j]) <= r) s[find(j)] = find(0);
                if (Math.abs(h - z[j]) <= r) s[find(j)] = find(n + 1);
            }
            for (int ii = 1; ii <= n; ii++) {
                for (int jj = 1; jj < ii; jj++) {
                    long dx = x[ii] - x[jj];
                    long dy = y[ii] - y[jj];
                    long dz = z[ii] - z[jj];
                    if (dx * dx + dy * dy + dz * dz <= (long) r * r * 4) {
                        s[find(ii)] = find(jj);
                    }
                }
            }
            if (find(0) == find(n + 1)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }

        }


    }
}
