package Math;

public class Main_04 {
    //欧拉函数 费马定理 扩展欧几里得
    public static int oula(int n,int mod){
        int res = n;
        for(int i=2;i<n/i;i++){
            if(n%i==0){
                while (n%i==0){
                    n = n/i;
                }
                res = (res / i*(i-1))%mod;
            }
            if(n>1){
                res = (res/i*(i-1))%mod;
            }
        }
        return res;
    }
}
