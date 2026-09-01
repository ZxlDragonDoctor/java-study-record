package 算法设计课程答案.Test_6;

import java.util.Arrays;

public class Main_2 {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9,10,13};
        int x = 4;
        int[] ints = binSearch(a, x);
        System.out.println(Arrays.toString(ints));

    }
    //二分，数组已排序
    public static int[] binSearch(int[] t,int x){
        int l = 0;
        int r = t.length-1;
        while (l<=r){
           int mid = (l+r)/2;
            if(t[mid]==x){
                int[] ans = new int[2];
                Arrays.fill(ans,mid);
                return ans;
            }
            if(t[mid]<x){
                l = mid+1;
            }else {
                r = mid-1;
            }
        }
        return new int[]{r,l};

    }

}
