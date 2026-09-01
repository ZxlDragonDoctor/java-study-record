package 算法设计课程答案.Test_7;

// 算法设计(最优子结构)
public class MatrixChainMultiplication {
    // 计算矩阵链乘的最小乘法次数
    public static int matrixChainOrder(int[] p) {
        int n = p.length - 1; // 矩阵数量为 p.length - 1
        int[][] m = new int[n + 1][n + 1];

        // 初始化对角线为0，即 m[i][i] = 0
        for (int i = 1; i <= n; i++) {
            m[i][i] = 0;
        }

        // l 是链长度，从2到n
        for (int l = 2; l <= n; l++) {
            for (int i = 1; i <= n - l + 1; i++) {
                int j = i + l - 1;
                m[i][j] = Integer.MAX_VALUE;

                // 尝试所有断点 k
                for (int k = i; k < j; k++) {
                    int cost = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (cost < m[i][j]) {
                        m[i][j] = cost;
                    }
                }
            }
        }

        return m[1][n]; // 返回最优值
    }

    public static void main(String[] args) {
        // 示例：矩阵 A1 10x30, A2 30x5, A3 5x60
        int[] dimensions = {10, 30, 5, 60};
        int minCost = matrixChainOrder(dimensions);
        System.out.println("最少乘法次数: " + minCost);
    }
}
