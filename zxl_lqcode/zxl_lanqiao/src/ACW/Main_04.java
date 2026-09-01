package ACW;



import java.io.*;

public class Main_04 {
    //Ac.借教室 二分+差分+前缀和
    static int n,m;
    static final int Max = 1000010;
    static int[] r = new int[Max];
    static int[] d = new int[Max];
    static int[] s = new int[Max];
    static int[] t = new int[Max];
    static long[] ttl = new long[Max];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        System.out.println(n + "//" + m);
        String[] spilt_ = br.readLine().split(" ");
        for(int i=1;i<=n;i++){
            r[i] = Integer.parseInt(spilt_[i-1]);
        }
        for(int i=1;i<=m;i++){
            String[] spilt = br.readLine().split(" ");
            d[i] = Integer.parseInt(spilt[0]);
            s[i] = Integer.parseInt(spilt[1]);
            t[i] = Integer.parseInt(spilt[2]);
        }
        int L = 1,R = m ;
        int mid = 0;
        while (L < R){//二分
            mid = (L+R)/2;
            if(checked(mid)){//前mid个订单不满足
                R = mid ;
            }else {//前mid个订单满足
                L = mid + 1;
            }
        }
        if(!checked(R)){
            System.out.println(0);
        }else {
            System.out.println("\n" + -1 + "\n" + R);
        }
    }
    public static boolean  checked(int mid){
        for(int i=1;i<=n;i++)  {
            ttl[i] = r[i] - r[i-1];//初始化
        }
        for(int i=1;i<=mid;i++){
            ttl[s[i]] -= d[i];
            ttl[t[i]+1] += d[i];//差分
        }
        long s = 0;
        for(int i=1;i<=n;i++){
            s += ttl[i];//前缀和
            if(s<0){
                return true;
            }
        }
        return false;
    }
}
//心得：
//使用Scanner类读，会超时，用IO流会节省很多时间
//二分的临界问题，及L，R的开始位置，以及反回的数值都很需要仔细考量
