package chaoxintest.practice_13;

import java.util.Scanner;

public class AP {
    public static void main(String[] args) {
//        4.输入m 行 n 列矩阵a中的元素，分别求出各行元素之和, 并存入一维数组row中, 再输出row。
//        例如：
//        输入：6  3
//        1  -8
//        3  12
//        输出：
//        sum of row 0 is 9
//        sum of row 1 is -7
//        sum of row 2 is 15
        Scanner scanner = new Scanner(System.in);
        int m,n;
        System.out.println("输入行数和列数");
        m = scanner.nextInt();
        n = scanner.nextInt();
        int[][] ints = new int[m][n];
        int[] row = new int[m];
        int count = 0;
        System.out.println("请输入");
        for(int i=0;i<ints.length;i++){
            int sum = 0;
            for (int j = 0; j < ints[i].length; j++) {
                ints[i][j] = scanner.nextInt();
                sum += ints[i][j];
            }
            row[count++] = sum;
        }
        for (int i = 0; i < row.length; i++) {
            System.out.println("sum of " + i + " is " + row[i]);
        }


    }
}
