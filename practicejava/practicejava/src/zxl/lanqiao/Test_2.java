package zxl.lanqiao;

import java.util.Scanner;

public class Test_2 {
    //    小蓝老师教的编程课有 N 名学生，编号依次是 1 . . . N。第 i 号学生这学期刷题的数量是 Ai。
//
//    对于每一名学生，请你计算他至少还要再刷多少道题，
//    才能使得全班刷题比他多的学生数不超过刷题比他少的学生数。
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N;
        N = scanner.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < A.length; i++) {
            A[i] = scanner.nextInt();
        }
        int[] modify = new int[A.length];
        int[] countNum = new int[N];
        for (int i = 0; i < A.length; i++) {
            System.out.print(addNum(A, i, 0) + " ");
        }
    }

    public static int addNum(int[] modify, int index, int num) {
        int node = modify[index];
        int countBig = 0, countSmall = 0;
        int[] modify_ = new int[modify.length];
        for (int j = 0; j < modify.length; j++) {
            modify_[j] = modify[j];
        }
        for (int i = 0; i < modify_.length; i++) {
            if (modify_[i] > node) {
                countBig++;
            } else if (modify[i] < node) {
                countSmall++;
            }
        }
        if (countSmall < countBig) {
            num++;
            modify_[index]++;
            return addNum(modify_, index, num);
        }
        return num;

    }
}
