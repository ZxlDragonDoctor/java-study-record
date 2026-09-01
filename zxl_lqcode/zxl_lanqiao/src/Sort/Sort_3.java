package Sort;

import java.util.Arrays;

public class Sort_3 {
    public static void main(String[] args) {
        int a[]={1,233,3,13,434,656,7,3,0};
        long start = System.currentTimeMillis();
        bubbleSort(a,true);
        long end =System.currentTimeMillis();
        System.out.println("时间为："+ (end-start));
        System.out.println(Arrays.toString(a));

    }
    //冒泡排序的优化
    public static void bubble(int[] a){
        int len = a.length;
        boolean loop = true;
        while(loop){
            int exit = 0;
            int k = exit;
            for(int j=len-1;j>k;j--){
                if(a[j]<a[j-1]){
                    int tmp=a[j];
                    a[j] = a[j-1];
                    a[j-1] = tmp;
                     exit = j;
                }
            }
            if(exit==k){
                loop = false;
            }
        }
    }
    public static void bubbleSort(int[] nums, boolean descending) {
            // 中间是你要实现的代码
            if(descending){
                int len = nums.length;
                boolean loop = true;
                while(loop){
                    int exit = 0;
                    int k = exit;
                    for(int j=len-1;j>k;j--){
                        if(nums[j]>nums[j-1]){
                            int tmp=nums[j];
                            nums[j] = nums[j-1];
                            nums[j-1] = tmp;
                            exit = j;
                        }
                    }
                    if(exit==k){
                        loop = false;
                    }
                }
            }else {
                int len = nums.length;
                boolean loop = true;
                while(loop){
                    int exit = 0;
                    int k = exit;
                    for(int j=len-1;j>k;j--){
                        if(nums[j]<nums[j-1]){
                            int tmp=nums[j];
                            nums[j] = nums[j-1];
                            nums[j-1] = tmp;
                            exit = j;
                        }
                    }
                    if(exit==k){
                        loop = false;
                    }
                }
            }
        }

}
