package ACW;

import java.io.*;
public class Main_02 {
    //Ac.差分 空调
    static int N = 100010;
    static int[] b = new int[N];
    public static void main(String[] args) throws IOException {
        int n = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        n = Integer.parseInt(str);

        String[] s = new String[n];
        s = br.readLine().split(" ");
        for(int i=1;i<=n;i++){
            b[i] = Integer.parseInt(s[i-1]);
        }
        s = br.readLine().split(" ");
        for(int i=1;i<=n;i++){
            b[i] -= Integer.parseInt(s[i-1]);
        }

        for(int i=n+1;i>=1;i--){//差分数组长度是n+1
            b[i] = b[i] - b[i-1];//因为差分数组用的原数组，故这里必须倒着更新值
        }
        int res = 0;
        for(int i=1;i<=n+1;i++){
            if(b[i]>0){
                res += b[i];
            }
        }
        System.out.println("\n" + res);

    }

}