package 算法设计课程答案.Test_6;

import java.util.Arrays;

public class Main_5 {
    public static void main(String[] args) {
        int[] a = {2,4,1,7,12,3};
        quickSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
    // 快排
    public static void quickSort(int[] t,int l,int r){
        if(l>=r){
            return;
        }
        int oril = l;
        int orir = r;
        int baic = t[l];
        while (l<r){
            while (t[r]>=baic&&l<r){
                r--;
            }
            t[l] = t[r];
            while (t[l]<=baic&&l<r){
                l++;
            }
            t[r] = t[l];
        }
        t[l] = baic;
        quickSort(t,oril,l-1);
        quickSort(t,l+1,orir);

    }
}
