package ACW;

import java.util.Scanner;

public class Main_301 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int k = scanner.nextInt();
            int result = calculateWinner(k);
            System.out.println(result);
        }

        scanner.close();
    }

    public static int calculateWinner(int k) {
        int n = k + 1; // 总奖券数量
        double P1 = (double) k / n + (double) (n - k) / n * (double) (k - 1) / (n - 1);
        double P2 = (double) (n - k) / n * (double) k / (n - 1);

        if (P1 > P2) {
            return 1;
        } else if (P1 < P2) {
            return 2;
        } else {
            return 0;
        }
    }
}