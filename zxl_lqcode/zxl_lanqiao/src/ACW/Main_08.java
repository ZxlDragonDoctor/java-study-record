package ACW;
import java.util.*;

public class Main_08 {
    static int T = 0;
    static int Max = 1010;
    static int[] A = new int[Max];
    static Scanner sc = new Scanner(System.in);
    public static void is(){
        int length = 0;
        length = sc.nextInt();
        int L = 0;//记录偶数个数
        int R = 0;//记录奇数个数
        for(int i=0;i<length;i++){
            A[i] = sc.nextInt();
            if(A[i]%2==0){
                L++;
            }else {
                R++;
            }
        }
        if(R%2!=0){
            System.out.println(0);
        }else {
            System.out.println((int)Math.pow(2,L+R)%1000000007);
        }

     }
//    public static int constant(int n,int m){
//        int res = fact(n)/(fact(n-m)*fact(m));
//        return res;
//    }
//    public static int fact(int n){
//        int res = 1;
//        while (n>0){
//            res *= n;
//            n--;
//        }
//        return res;
//    }
    public static void main(String[] args) {
        T = sc.nextInt();
        for(int i=0;i<T;i++){
            is();
        }
    }
}
