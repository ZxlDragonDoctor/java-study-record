package chaoxintest.practice_13;

public class ArrPrint {
    public static void main(String[] args) {
//        2.定义一个数组int [][]a，初始化元素为
//    {{1,2},{3,4,5},{6,7,8,9}}，按数组的行和列输出每个元素。
        int[][] a ={{1,2},{3,4,5},{6,7,8,9}};
        for (int i=0;i<a.length;i++){
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
