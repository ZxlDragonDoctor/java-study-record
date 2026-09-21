package 华为OD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//仓库查询
public class SearchSort {
    public static void main(String[] args) {
        int A = 7;
        int B = 4;
        int[] arrA = new int[]{
            9,7,2,8,14,1,8
        };
        int[] arrB = new int[]{
                1,2,6,6
        };

        List<Integer> ans = new ArrayList<>();
        //
        for(int i=0;i<arrB.length;i++){
            int[] windos = new int[arrB[i]];
            int index = 0;
            for(int j=0;j<arrB[i];j++){
                  windos[index++] = arrA[j];
            }
            Arrays.sort(windos);
            ans.add(windos[i]);
        }
        
        System.out.println(Arrays.toString(ans.toArray()));

    }
}
