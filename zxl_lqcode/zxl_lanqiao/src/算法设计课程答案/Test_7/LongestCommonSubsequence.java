package 算法设计课程答案.Test_7;

// 最长公共子序列
public class LongestCommonSubsequence {
    // 返回LCS的长度，并构造方向表用于回溯LCS本身
    public static String lcs(String X, String Y) {
        int m = X.length();
        int n = Y.length();
        int[][] c = new int[m + 1][n + 1];
        char[][] b = new char[m + 1][n + 1]; // 记录方向：'↖', '↑', '←'

        // 动态规划填表
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    b[i][j] = '↖'; // 来自左上，字符相同
                } else if (c[i - 1][j] >= c[i][j - 1]) {
                    c[i][j] = c[i - 1][j];
                    b[i][j] = '↑'; // 来自上方
                } else {
                    c[i][j] = c[i][j - 1];
                    b[i][j] = '←'; // 来自左方
                }
            }
        }

        // 回溯构造LCS字符串
        StringBuilder lcsStr = new StringBuilder();
        constructLCS(b, X, m, n, lcsStr);

        System.out.println("最长公共子序列长度: " + c[m][n]);
        return lcsStr.reverse().toString(); // 因为是从后往前回溯的
    }

    // 回溯函数（递归），将LCS字符加入lcsStr中
    private static void constructLCS(char[][] b, String X, int i, int j, StringBuilder lcsStr) {
        if (i == 0 || j == 0) return;

        if (b[i][j] == '↖') {
            constructLCS(b, X, i - 1, j - 1, lcsStr);
            lcsStr.append(X.charAt(i - 1)); // 加入匹配字符
        } else if (b[i][j] == '↑') {
            constructLCS(b, X, i - 1, j, lcsStr);
        } else {
            constructLCS(b, X, i, j - 1, lcsStr);
        }
    }

    // 主函数测试
    public static void main(String[] args) {
        String X = "ABCBDAB";
        String Y = "BDCABA";
        String lcs = lcs(X, Y);
        System.out.println("最长公共子序列: " + lcs);
    }
}
