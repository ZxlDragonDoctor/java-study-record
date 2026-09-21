package 华为OD;


//抗洪救灾 类似岛屿问题 dfs
public class DfsAndIsland {
    static int limH = 0;
    static int ans = 0;
    static int m = 0;
    static int n = 0;

    static  boolean[][] visted;
    public static void main(String[] args) {
        limH = 3;
        m = 5;
        n = 5;
        int[][] g = new int[][]{
                {2,2,2,2,2},
                {2,9,9,9,2},
                {2,2,2,2,2},
                {2,9,2,9,2},
                {2,9,2,9,2}
        };
        visted = new boolean[m][n];
        ans = 0;
        //
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                 if(g[i][j]>limH && !visted[i][j]){
                     dfs(g,i,j);
                     ans++;
                 }
            }
        }
        System.out.println(ans);

    }

    //右下左上  8连通
    static int[] x = new int[]{0,1,1,1,0,-1,-1,-1};
    static int[] y = new int[]{1,1,0,-1,-1,-1,0,1};

    public static void dfs(int[][] g,int row,int col){
        // 处理边界
        if(row<0 || row>=m || col<0 || col>=n || visted[row][col]){
            return;
        }
        if(g[row][col] > limH){
            visted[row][col] = true;
             for(int k=0;k<8;k++){
                 int newRow = row + x[k];
                 int newCol = col + y[k];
                 dfs(g,newRow,newCol);
             }
        }


    }
}
