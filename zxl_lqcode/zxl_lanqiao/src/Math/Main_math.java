package Math;

public class Main_math {
    //快速幂
    public static int fastPower(int a,int b,int mod){
        int res = 1 % b;//防止b=0的变态情况
        while (b>0){
            if((b&1)==1){//相当于b%2=1
                 res = res * a% mod;
            }
            b = b >> 1;
            a = a * a % mod;
        }
        return res;
    }
    public static int testFastPower(int a,int b,int mode){
         int res  = 1% b;
         while (b>0){
             if((b&1)==1){
                 res = res * a % mode;
             }
             b = b >> 1;
             a = a * a % mode;
         }
         return res;
    }
    public static void main(String[] args) {
        System.out.println(-2%2);
    }
}
