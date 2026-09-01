package 得物笔试;


//在遥远的国度有一位国王，在他手下有一支战无不胜的军队，但是他觉得这还不够，
// 他决定继续通过训练提升军队的实力。军队中共有 n 名战士，其中第 i 位的战斗力为 aᵢ。
// 在第 j 次训练中，国王会先找出战斗力最低的战士，假设他的战斗力为 x，则国王会同时训练所有战斗力为 x 的战士，
// 将他们的战斗力都提升 bⱼ（从 x 变为 x + bⱼ）。这样的训练一共会进行 m 次。同时，为了时刻了解军队的情况，
// 国王请你帮他计算一下，在每次训练后所有战士的战斗力之和为多少。

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] powerCounts = new int[200005];
        long totalPower = 0L;
        int minPower = 200005;

        for (int i = 0; i < n; i++) {
            int power = sc.nextInt();
            powerCounts[power]++;
            totalPower += power;
            if (power < minPower) {
                minPower = power;
            }
        }

        for (int i = 0; i < m; i++) {
            int b = sc.nextInt();

            while (minPower < powerCounts.length && powerCounts[minPower] == 0) {
                minPower++;
            }

            if (minPower >= powerCounts.length) {
                System.out.print(totalPower);
                if (i < m - 1) System.out.print(" ");
                continue;
            }

            int numSoldiers = powerCounts[minPower];
            int newPower = minPower + b;

            if (newPower < powerCounts.length) {
                powerCounts[newPower] += numSoldiers;
            }
            powerCounts[minPower] = 0;
            totalPower += (long) numSoldiers * b;

            if (newPower < minPower) {
                minPower = newPower;
            }

            System.out.print(totalPower);
            if (i < m - 1) System.out.print(" ");
        }
        System.out.println();
        sc.close();
    }
}
