package ACW;

import java.util.Scanner;

public class Main_13 {
    //ac.牛的学术圈 二分
    static int N=100010;
    static int[] s = new int[N];
    public static boolean checked(int mid,int L,int n){
        int a=0,b=0;
        for(int i=1;i<=n;i++){
            if(s[i]>=mid) {a++;}
            if(s[i]==mid-1) {b++;}
        }
        return (Math.min(b,L)+a)>=mid;
    }
    public static void main(String[] args) {
        int n,L;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        L = sc.nextInt();
        for(int i=1;i<=n;i++){
            s[i]=sc.nextInt();
        }
        int l=0,r=n;
        int mid =0;
        while (l<r){
            mid = (l+r+1)/2;
            if(checked(mid,L,n)) l = mid;
            else r = mid-1;
        }
        System.out.println(r);

    }
}
