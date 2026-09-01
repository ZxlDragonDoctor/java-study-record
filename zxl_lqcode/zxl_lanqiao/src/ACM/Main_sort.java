package ACM;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main_sort {
    // 百度之星，补给
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,s;
        n = sc.nextInt();
        s = sc.nextInt();
        int[] arr = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[i] = a+ b;
            map.put(arr[i],a);
        }
        Arrays.sort(arr);
        long sum = 0;
        int count = 0;
        for(int i=0;i<n;i++){
            sum += arr[i];
            if(sum<s){
                count++;
                continue;
            }else if(sum>s){
                sum -= map.get(arr[i])/2;
                if(sum<=s){
                    count++;
                    break;
                }
            }else {
                count++;
                break;
            }
        }
        System.out.println(count);
    }
}
