package Math;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 约束相关基础算法
 */
public class Main_02 {
    //ac.约数
    static int N = 10010;
    static HashSet<Integer> ans = new HashSet<>();
    public static void number(int x){
        for(int i=1;i<=x/i;i++){
            if(x%i==0){
                ans.add(i);
                if(i!=x/i){
                    ans.add(x/i);//统计x的约数
                }
            }
        }
    }
    //约数个数
    public static int sum(int x,int mod){
        int[] p  = new int[x];
        for(int i=2;i<=x/i;i++){
            if(x%i==0){
                while (x%i==0){
                    x /= i;
                    p[i]++;
                }
            }
        }
        if(x>1) {
            p[x]++;
        }
        int res =1;
        for(int a:p){
            res = res*(a+1) % mod;
        }
        return res;
    }
    //约束和
    static HashMap<Integer,Integer> map = new HashMap<>();
    public static int multisum(int x,int mod){
        for(int i=2;i<=x/i;i++){
            if(x%i==0){
                while (x%i==0){
                    x /= i;
                    map.put(i, map.getOrDefault(i,0)+1);
                }
            }
        }
        if(x>1) {
            map.put(x,map.getOrDefault(x,0)+1);
        }
        int res =1;
        for(Map.Entry<Integer,Integer> m:map.entrySet()){//set集合
            int a = m.getKey();
            int b = m.getValue();
            int t = 1;
            while (b-->0){
                t = (t * a + 1)%mod;
            }
            res  = res * t;
        }
        return res;
    }
    //最大公约数
    //gcd(a,b)=gcd(a%b,b)直到模到余
    public static int gcd(int a,int b){
        return b!=0?gcd(b,a%b):a;//欧几里得
    }

}
