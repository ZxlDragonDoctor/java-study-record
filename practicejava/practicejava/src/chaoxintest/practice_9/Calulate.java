package chaoxintest.practice_9;

import java.util.Scanner;

public class Calulate {
//    输入 m 行 n 列矩阵 a 中的元素，分别求出各行元素之和, 并存入一维数组row 中, 再输出 row。
//
//    输入：
//
//            6 3
//
//            1 -8
//
//            3 12
//
//    输出：
//
//    sum of row 0 is 9
//
//    sum of row 1 is -7
//
//    sum of row 2 is 15
public static void main(String[] args) {
    int m,n;//行数，列数；
    Scanner scanner = new Scanner(System.in);
    System.out.println("分别输入行数和列数");
    m = scanner.nextInt();
    n = scanner.nextInt();
    int[][] ints = new int[m][n];
    System.out.println("输入数据");
    int[] row = new int[m];
    int count = 0;
    for(int i  = 0;i < ints.length;i++){
        int sum = 0;
        for(int j=0;j < ints[i].length;j++){
            ints[i][j]  = scanner.nextInt();
            sum += ints[i][j];
        }
        row[count++] = sum;
    }
    for (int i = 0; i < m; i++) {
        System.out.println("sum of row " + i +" is "+ row[i] );
    }
}
}
