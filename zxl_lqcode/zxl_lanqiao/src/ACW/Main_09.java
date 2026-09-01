package ACW;

public class Main_09 {
    public static long fact(int n){
        long res = 1;
        while (n>0){
            res *= n;
            n--;
        }
        return res;
    }
    public static void main(String[] args) {
        long N = (long)1e9;
        long res = 1;
        long sum =0;
        for(int i=1;i<=400;i++){
            res += res * i % N;
            sum += res;
            sum %= N;
            System.out.println(sum);
        }



    }
}
