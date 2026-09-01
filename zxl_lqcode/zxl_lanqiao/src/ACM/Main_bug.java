package ACM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main_bug {
    //icpc西部程序设计赛 bug星球
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = 10010;
        HashMap<Integer, ArrayList<Integer>> times = new HashMap<>();
        for(int i=1;i<=N;i++){
            times.put(i,new ArrayList<>());//定义时间轴
        }
        int n = sc.nextInt();
        while (n-->0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            ArrayList<Integer> list = times.get(b);
            list.add(a);
            times.put(b,list);   //初始化时间轴
        }
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            int max = 0;
            for(int j=i;j<=N;j++){
                ArrayList<Integer> list = times.get(j);
                if(list.isEmpty()) {
                    continue;
                }
                for(int k=0;k< list.size();k++){
                    max = Math.max(max, list.get(k));
                }
            }
            sum += max;
        }
        System.out.println(sum);
    }
}
