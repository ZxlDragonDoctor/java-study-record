package 华为OD;


// 单词搜索记数 类似岛屿问题
public class DfsAndBacktcacing {
    static String target = "";
    static char[]  arr;
    static  int ans = 0;

    static boolean[][]  visted;
    public static void main(String[] args) {
        char[][] g = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        target  = "ABCCED";
//        char[][] g = new char[][]{
//                {'A','A'}
//        };
//        target = "A";
        arr = target.toCharArray();
        visted = new boolean[g.length][g[0].length];

        for(int i=0;i<g.length;i++){
            for(int j=0;j<g[0].length;j++){
                if(g[i][j]==arr[0] && !visted[i][j]){
                    dfs(g,0,i,j);
                }
            }
        }
        System.out.println(ans);
    }

    static  int[] x = {0,1,0,-1};  // 右下左上
    static  int[] y = {1,0,-1,0};

    // 单词搜索计数
    public  static void dfs(char[][] g,int index,int row,int col){
        // 返回条件
        if(index==arr.length-1 && g[row][col] == arr[index]){
             ans++;
             return;
        }
        if(g[row][col] == arr[index] ){
            visted[row][col] = true;
             // 右下左上
             for(int k=0;k<4;k++){
                 int newRow = row + x[k];
                 int newCol = col + y[k];
                 if(newRow>=0 && newRow<g.length && newCol>=0 && newCol<g[0].length && !visted[newRow][newCol]){
                     dfs(g,index+1,newRow,newCol);
                 }
            }
             visted[row][col] = false;
        }
    }
}
