package ACW;

import java.util.Scanner;

public class Main_01 {
    static int MAX = (int)Math.pow(10,5)+1;
    static int M;
    static int N;
    static int[] W = new int[MAX];//储存图片宽度
    static int[] H = new int[MAX];//储存图片高度

    static int[] t = new int[MAX];//这里t[i]代表，第i张图片处于某行第一个位置时，i~n-1张的图片高度
    //这里实际上就是剪枝的操作，这里是这道题的难点
    public static int solve(int w,int h,int i){
        while (i<N&&w<M){
            if(w+W[i]>M){
                h = (int)Math.max(h,Math.ceil(1.0*H[i]*(M-w)/W[i])) ;//缩放图片
            }else {
                h = Math.max(h,H[i]);
            }
            w = Math.min(w+W[i],M);
            i++;
        }
        return h+t[i];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        M = scanner.nextInt();
        N = scanner.nextInt();
        for(int i=0;i<N;i++){
            W[i] = scanner.nextInt();
            H[i] = scanner.nextInt();
        }
        //便利的得到t数组
        for(int i=N-1;i>=0;i--){
            t[i] = solve(0,0,i);//初始化t数组
        }
        int pre_h = 0;
        int w = 0;
        int h = 0;
        int res = t[0];//即一张图片都不删除的高度
        int tmp = 0;//中间量
        for(int i=0;i<N;i++){
            tmp = solve(w,h,i+1);
            res = Math.min(res, pre_h+tmp);
            if(w+W[i]>M){
                h = (int)Math.max(h,Math.ceil(1.0*H[i]*(M-w)/W[i])) ;//缩放图片
            }else {
                h = Math.max(h,H[i]);
            }
            w = Math.min(w+W[i],M);
            if(w==M){
                pre_h += h;
                w = 0;
                h = 0;
            }
        }
        System.out.println(res);

    }

}
