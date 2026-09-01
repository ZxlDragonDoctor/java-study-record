package ACW;

import java.util.ArrayList;
import java.util.Arrays;

public class Main_23 {
    //letcode 八皇后 回溯
    static int N = 8;
    static int[][] attack = new int[N][N];
    static char[][] queen = new char[N][N];
    static ArrayList<String> ans = new ArrayList<>();//答案
    static int[] dx = {0,1,1,1,0,-1,-1,-1};
    static int[] dy = {1,1,0,-1,-1,-1,0,1};
    public static void dfsTree(int k) {//第k行
        if(k==N) {
            ans.add(Arrays.deepToString(queen));
            //Arrays.deepToString(queen)是Java中的一个方法，用于将多维数组转换为字符串表示形式。它可以将数组的内容以字符串的形式输出，包括多维数组的元素。
            //一维数组会报错
            //具体来说，如果queen是一个多维数组，使用Arrays.deepToString(queen)会返回一个表示该数组内容的字符串。如果queen是一个一维数组，它将返回一个包含数组元素的字符串。如果queen是一个多维数组，它将递归地将每个维度的元素转换为字符串，并使用逗号分隔。
            //
            //例如，如果queen是一个二维数组，使用Arrays.deepToString(queen)将返回一个表示该二维数组内容的字符串。
            return;
        }
        for(int i=0;i<N;i++) {//遍历所有列
            if(attack[k][i]==0) {
                int[][] tmp = new int[N][N];//临时保存数组
                tmp = copyAttack(attack);//保存当前状态，方便以后回溯状态
                queen[k][i] = 'Q';
                updata(attack, k, i);//更新皇后攻击范围
                dfsTree(k+1);
                attack = copyAttack(tmp);
                queen[k][i] = '.';
            }
        }
    }
    public static void updata(int[][] attack,int x,int y) {
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                int nx = x + i*dx[j];
                int ny = y + i*dy[j];
                if(nx>=0&&nx<N&&ny>=0&&ny<N&&attack[nx][ny]==0) {
                    attack[nx][ny] = 1;
                }
            }
        }
    }
    //深拷贝
    public static int[][] copyAttack(int[][] src) {
        int[][] tmp = new int[N][N];
        for(int i=0;i<tmp.length;i++) {
            System.arraycopy(src[i], 0, tmp[i], 0, tmp[i].length);
        }
        return tmp;
    }
    public static void main(String[] args) {
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                attack[i][j] = 0;
                queen[i][j] = '.';
            }
        }
        dfsTree(0);
        for(String str:ans) {
            System.out.println(str);
        }
        System.out.println(ans.size());
    }

}
