package apijava;

import java.util.*;


public class Matrix {
    // 7-23 矩阵A乘以B
    // 矩阵相乘
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] a = new int[2];
        a[0] = sc.nextInt();
        a[1] = sc.nextInt();
        int[][] A = new int[a[0]][a[1]];
        for(int i=0;i<a[0];i++){
            for(int j=0;j<a[1];j++){
                A[i][j] = sc.nextInt();
            }
         }
        int[] b = new int[2];
        b[0] = sc.nextInt();
        b[1] = sc.nextInt();
        if(a[1]!=b[0]){
            System.out.printf("Error: %d != %d",a[1],a[0]);
            return;
        }
        System.out.println(a[0]+" "+b[1]);
        int[][] B = new int[b[0]][b[1]];
        for(int i=0;i<b[0];i++){
            for(int j=0;j<b[1];j++){
                B[i][j] = sc.nextInt();
            }
        }
        int[][] ans = new int[a[0]][b[1]];
        for(int i=0;i<a[0];i++){
            for(int j=0;j<b[1];j++){
                for(int k=0;k<b[0];k++){
                    ans[i][j] += A[i][k]*B[k][j];
              }
            }
        }
        for(int i=0;i<a[0];i++){
            for(int j=0;j<b[1];j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }
}