package 神州信息;

import java.util.Scanner;

// 求累加正方形的周长
// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class SquarerPerimeter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextInt();

       long sum = 4 * n;
        System.out.println(sum);
    }
}