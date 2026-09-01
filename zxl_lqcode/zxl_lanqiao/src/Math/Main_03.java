package Math;

public class Main_03 {
    //矩阵运算
    public static int[][] multi(int[][] a,int[][] b){
        int[][] c = new int[2][2];
        for(int i=0;i<2;i++){
           for(int j=0;j<2;j++){
               for(int k=0;k<2;k++ ){
                   c[i][j] = (c[i][j]+a[i][k]*b[k][j]);
               }
           }
        }
        return c;
    }
}
