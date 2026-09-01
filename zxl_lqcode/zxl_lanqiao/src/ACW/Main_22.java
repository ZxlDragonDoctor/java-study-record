package ACW;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main_22 {
    //ac.奶牛选美 dfs
    static int MAX = 55;
    static Arr[] arrs = new Arr[2];
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int N,M;
    public static void dfs(char[][] g,Arr arr,int a,int b) {
        arr.push(a,b);
        g[a][b] = '.';
        for(int i=0;i<4;i++) {
             int x = a+dx[i]; int y = b + dy[i];
            if(x<N&&x>=0&&y<M&&y>=0&&g[x][y]=='X') {
                dfs(g, arr, x, y);
            }
        }
    }
    public static void initArr(){
        arrs[0] = new Arr();
        arrs[1] = new Arr();
    }
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        char[][] g = new char[N][M];
        String str = "";

        int count =0;
        for(int i=0;i<N;i++){
            str = scanner.next();
            for(int j=0;j<M;j++){
                g[count][j] = str.charAt(j);
            }
            count++;
        }
        initArr();
        int index =0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(g[i][j]=='X') {
                    dfs(g, arrs[index++], i, j);
                }
            }
        }
        int ans = 100;
        for(Pare1 arr1:arrs[0].loc) {
            for(Pare1 arr2:arrs[1].loc) {
                int dis = Math.abs(arr1.x-arr2.x) + Math.abs(arr1.y-arr2.y);
                ans = Math.min(ans,dis);
            }
        }
        System.out.println(ans-1);
    }

}
class Arr{
    ArrayList<Pare1> loc = new ArrayList<>();
    public  void push(int x,int y) {
        loc.add(new Pare1(x, y));
    }
}
class Pare1{
    int x;
    int y;
    public Pare1(int x,int y) {
        this.x = x;
        this.y = y;
    }
}
