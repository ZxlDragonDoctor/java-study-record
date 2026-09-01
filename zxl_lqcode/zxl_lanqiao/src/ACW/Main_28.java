package ACW;

import java.util.HashMap;
import java.util.Scanner;

public class Main_28 {
    //病毒溯源 TLE
    static int MAX = 10010;
    static boolean[] std = new boolean[MAX];
    static int[] path = new int[MAX];
    static int idx = 0;
    public static int height(HashMap<Integer,int[]> map,int v){
        int[] arr = map.get(v);
        if(arr.length==0){
            return 1;
        }
        int ans = 0;
        for(int i=0;i<arr.length;i++){
            ans = Math.max(ans,height(map,arr[i]));
        }
        return ans+1;
    }

    public static int dfs(HashMap<Integer,int[]> map,int v){
        int[] arr = map.get(v);
        if(arr.length==0){
            return 1;
        }
        int ans = 0;
        int mid = 0;
        for(int i=0;i<arr.length;i++){
            int res = height(map,arr[i]);
            if(ans>res){
                continue;
            }else if(ans<res){
                ans = res;
                mid = arr[i];
            }else {
                 mid= Math.min(mid, arr[i]);
            }
        }
        path[idx++] = mid;
        dfs(map,mid);
        return ans+1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        HashMap<Integer, int[]> map = new HashMap<>();
        for(int i=0;i<N;i++){
            int k = sc.nextInt();
            int[] mid = new int[k];
            while(k-->0){
                mid[k] = sc.nextInt();
                std[mid[k]] = true;
            }
            map.put(i,mid);
        }
        int root = 0;
        for(int i=0;i<N;i++){
            if(!std[i]){
                root = i;
                break;
            }
        }
        path[idx++] = root;
        int ans = dfs(map,root);
        System.out.println(ans);
        for(int i=0;i<idx;i++){
            System.out.print(path[i]+" ");
        }
    }
}
