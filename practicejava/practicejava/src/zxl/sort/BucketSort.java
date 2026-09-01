package zxl.sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@SuppressWarnings({"all"})
public class BucketSort {
    public void sort(int arr[]){
        int MAX = arr[0];
        int MIN = arr[0];
        for(int i = 0;i < arr.length;i++){
            if(arr[i] > MAX){
                MAX = arr[i];
            }
            else if(arr[i] < MIN){
                MIN = arr[i];
            }
        }//取出最大值，最小值
        int gap = (MAX - MIN)/(arr.length + 1);//间隔距离
        int bucketNum = (MAX - MIN)/(gap +1);//桶的数量
        ArrayList<ArrayList> bucket = new ArrayList<>(bucketNum);//一维
        for (int i = 0; i < bucketNum; i++) {
            bucket.add(new ArrayList<Integer>());//二维数组或者是建立链表
        }
        for(int i = 0;i < arr.length;i++){
            int num = (arr[i] - MIN)/ arr.length;//放入商相同的桶
            bucket.get(num).add(arr[i]);//放入桶
        }
        for(int i = 0;i < bucketNum;i++){
            Collections.sort(bucket.get(i));
        }
//        int[] result = new int[arr.length];
//        int count = 0;
//        for (int i = 0; i < bucketNum; i++) {
//            int j = 0;
//            while(bucket.get(i).get(j)!=null){
//                result[count++] = (int)bucket.get(i).get(j);
//                j++;
//            }
//            j = 0;
//        }
//        arr = result;
        System.out.println("分离后" + bucket.toString());
    }
}
class Test{
    public static void main(String[] args) {
        BucketSort bucketSort = new BucketSort();
//        int[] arr = new int[5];
        int[] arr = {29,25,3,49,9,37,21,43};
        bucketSort.sort(arr);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
    }
}
