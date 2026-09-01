package Math;

public class Main_6 {
    //扩展欧几里得
   static int x,y;
    public static int exGcd(int a,int b){//当a,b互质则gcd=1故扩展欧几里得后的x就是a模b的逆元
        if(b==0){
            x = 1;
            y = 0;
            return a;
        }
        int g = exGcd(b,a%b);
        int tmp = x;
        x = y;
        y = tmp - (a/b)*y;
        return g;
    }

    public static void main(String[] args) {
        System.out.println(exGcd(3,5)+"x:"+x+"y:"+y);
    }

}
