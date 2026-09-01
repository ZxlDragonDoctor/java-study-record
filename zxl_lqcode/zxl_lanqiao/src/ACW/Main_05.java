package ACW;

import java.io.*;
public class Main_05{
    //Ac.壁画.前缀和
    static int n = 0;
    static int num = 0;
    static int N = 500010;
    static int[] s = new int[N];
    static char[] str = new char[N];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sr = br.readLine();
        num = Integer.parseInt(sr);
        for(int i=1;i<=num;i++){
            sr = br.readLine();
            n = Integer.parseInt(sr);
            sr = br.readLine();
            str = sr.toCharArray();
            for(int j=1;j<=n;j++){
                s[j] = s[j-1] + str[j-1] - '0'; //注意得到数字值
            }
            int res = 0,m = (n+1)/2;
            for(int k=m;k<=n;k++){
                res = Math.max(res,s[k]-s[k-m]);
            }
            System.out.println("Case #" + i + ": " + res);
        }


    }
}