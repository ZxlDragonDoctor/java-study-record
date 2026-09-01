package ACW;

import java.util.Scanner;

public class Main_12 {
    //ac.牛的学士圈 双指针
    static int N = 100010;
    static  int[] s  = new int[N];

    public static void main(String[] args) {
        int n,l;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        l = sc.nextInt();
        for(int i=1;i<=n;i++){
            s[i] = sc.nextInt();
        }
        for(int i=1;i<=n-1;i++){
            int tmp=0;
            for(int j=1;j<=n-1-(i-1);j++){
                tmp=s[j];
                if(s[j]<s[j+1]){
                    s[j]=s[j+1];
                    s[j+1]=tmp;
                }
            }
        }//冒泡超时，建议快排，希尔排序
        int res=0;
        for(int i=1,j=n;i<=n;i++){
            while (j>0&&s[j]<i){
                j--;
            }
            if(s[i]>=i-1&&(i-j)<=l){
                res = i;
            }
        }
        System.out.println(res);
    }
}
