package ACW;

import java.util.ArrayList;
import java.util.Arrays;

public class Main_test {
    public static void main(String[] args) {
        char[]  a = {'1','2','3'};
        System.out.println(new String(a,0,3));
        System.out.println(Arrays.toString(a));
//        System.out.println(Arrays.deepToString(a));//java: 不兼容的类型: char[]无法转换为java.lang.Object[]
        int[][] b = {{1,2,3},{1,2,3}};
//        System.out.println(new String(b,0,3));
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.deepToString(b));//java: 不兼容的类型: int[]无法转换为java.lang.Object[]

        //数组转字符串
        // 一维数组就用Arrays.toString();
        //多维数组就用Arrays.deepToString();
        ArrayList<Object> srr = new ArrayList<>();
        srr.add(new Test());
        Test t = (Test)srr.get(0);
         t.vlue++;
        System.out.println(((Test) srr.get(0)).vlue);
        String s = "";
        char[] str = s.toCharArray();
    }
    static class Test{
        int index;
        int vlue;
    }
}

