package chaoxintest.practice_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings({"all"})
public class sort_ {
//    1.输入n个整数，按升序次序输出这些数。
//    例如：输入：4 10 8 12  输出：4  8  10  12
        public static void main(String[] args) {
            ArrayList arrayList = new ArrayList();
            String str;
            BufferedReader br = null;
            try {
                br = new BufferedReader(new InputStreamReader(System.in));
                str = br.readLine();
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    if (br != null) {
                        br.close();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
//            System.out.println(str);
            //注意第一个字符不能是空字符，不然会报错NumberFormatException
            String[] arr = str.split(" ");
//            for (int i = 0; i < arr.length; i++) {
//                System.out.print(arr[i]+"\t");
//            }
            int[] ints = new int[arr.length];
            for(int i=0;i< arr.length;i++){
                ints[i] = Integer.parseInt(arr[i]);
            }
            Arrays.sort(ints);
            for(int i=0;i<ints.length;i++){
                System.out.print(ints[i]+"\t");
            }

        }
}
