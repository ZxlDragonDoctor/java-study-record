package Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/**
 * 质数相关基本算法
 *   //质数也叫素数 1既不是素数也不是合数
 */
public class Main_01 {
    public static void main(String[] args) {
        except(10);
    }
    /**
     * 埃氏筛
     * 合数：质数的整数倍都是合数 (即不是质数)
     * @param n
     */
    public static void aiFilter(int n){
        boolean[] ans = new boolean[n+1];
        Arrays.fill(ans,true);  // 设置刚开始全是素数
        for(int i=2;i<Math.sqrt(n);i++){
            if(isPrime(i)){
                for(int j=i*i ;j<=n; j+=i){
                    ans[j] = false;  //标记i的整数倍(除了i)以外所有数为非素数
                }
            }
        }
        for(int i=2;i<=n;i++){
            if(ans[i]){
                System.out.println(i+"是素数");
            }
        }
    }
    public static void testAiFilter(int n){
        boolean[] booleans = new boolean[n + 1];
        Arrays.fill(booleans,true);
        for(int i=2;i*i<n;i++){
            if(isPrime(i)){
                for(int j=i*i;j<=n;j++){
                    booleans[j] = false;
                }
            }
        }
        for(int i=2;i<=n;i++){
            if(booleans[i]){
                System.out.println(i+"是素数");
            }
        }
    }
    /**
     * 欧拉筛(线性筛)
     * 整数分解定理：任何合数都有他的最小质因数
     * 合数：质数的整数倍都是合数
     * @param n
     */
    public static void  lineFilter(int n){
        boolean[] ans = new boolean[n + 1];
        Arrays.fill(ans,true);  // 设置刚开始全是素数
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=2;i<=n;i++){   // 为什么遍历到n,因为每一次循环没有把关于i的所有合数都筛掉
            if(isPrime(i)) res.add(i); // 如果是质数(即未被前面的质素筛筛掉)
            for(int j=0;j<res.size()&& i*res.get(j)<=n ;j++){
                ans[i* res.get(j)] = false;
                if(i%res.get(j)==0) {
                    break;   //如果i能倍res.get(j)整数,说明i*res[j+1]及其后面的数都被更小的质因数筛掉了。
                            // 这里解释一下： 当 i*t(某一个整数)=res.get(j),
                             //  则当res.get(j)增大时,就可能存在比i小的质数乘上某一个整数等于这个数,而这个数已经被前面的质素筛筛掉了
                }
            }
        }
        System.out.println("质数是:"+res);
    }
    public static void testLineFilter(int n){
        boolean[] ans = new boolean[n + 1];
        Arrays.fill(ans,true);
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=2;i<n;i++){
            if(isPrime(i)) res.add(i);
            for(int j=0;j<res.size()&&j*res.get(j)<=n;j++){
                if(i%res.get(j)==0){
                    break;
                }
            }
        }
        System.out.println("质数是:"+res);
    }

    /**
     * 试除法，判断是否是质数(素数)
     * @param n
     * @return
     */
    public static Boolean isPrime(int n){
        if(n<2){  // 1不是素数
            return false;
        }
        for(int i=2;i<= Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    //质素筛(埃氏筛简洁写法)
    public static void except(int n){
        boolean[] stl = new boolean[n+1];
        int[] ans = new int[n];
        int cnt=0;
        for(int i=2;i<=n;i++){
            if(!stl[i]){
                ans[cnt++] = i;
                for(int j=i;j<=n;j+=i){
                    stl[j] = true;
                }
            }

        }
        for(int i=0;i<cnt;i++){
            System.out.println(ans[i]);//输出质素集合
        }
    }
    public static void testSum(int x){
        for(int i=2;i<=x/i;i++){
            if(x%i==0){
                int s = 0;
                while (x%i==0){
                    x = x/i;
                    s++;
                }
                System.out.println("质素："+i+"指数："+ s );
            }
        }
        if(x>1){
            System.out.println("质素："+x+"指数："+ 1 );
        }
    }
    //分解质因数
    public static void sum(int x){
        for(int i=2;i<=x/i;i++){
            if(x%i==0){
                int s = 0;
                while (x%i==0){
                    x = x / i;
                    s++;
                }
                System.out.println("质素："+i+"指数："+ s );

            }

        }
        if(x>1){
            System.out.println("质素："+x+"指数："+ 1 );
        }
    }

}
