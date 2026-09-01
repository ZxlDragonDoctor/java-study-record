package 算法设计课程答案.Test_9;

import java.util.*;

public class Main {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int N, S;
                N = sc.nextInt();
                S = sc.nextInt();
                int[] a = new int[N]; // 库存量
                int[] b = new int[N]; // 总价格
                for (int i = 0; i < N; i++) {
                        a[i] = sc.nextInt();
                }
                for (int i = 0; i < N; i++) {
                        b[i] = sc.nextInt();
                }
                Double[] arr = new Double[N]; // 单价
                Map<Double, Integer> map = new HashMap<>();
                for (int i = 0; i < N; i++) {
                        arr[i] = 1.0 * b[i] / a[i];
                        map.put(arr[i], i); // 保存映射关系
                }
                // 使用 Double.compare 进行倒序排序
                Arrays.sort(arr, (o1, o2) -> Double.compare(o2, o1));

                double ans = 0;
                for (int i = 0; i < N; i++) {
                        if (S == 0) {
                                break;
                        }
                        int j = map.get(arr[i]); // 取出对应下标
                        double pricePerUnit = arr[i]; // 单价
                        int stock = a[j]; // 库存
                        if (S <= stock) {
                                ans += pricePerUnit * S; // 购买 S 个单位
                                S = 0; // 直接卖完
                        } else {
                                ans += b[j]; // 购买全部库存
                                S -= stock;
                        }
                }
                System.out.printf("%.2f", ans);
        }
}
