package 算法设计课程答案.Test_10;

public class BatchScheduling {
    static int n;                // 作业数量
    static int[] t1, t2;          // 各作业在机器1和机器2上的处理时间
    static boolean[] visited;     // 作业是否已被调度
    static int[] order;           // 当前排列顺序
    static int bestF = Integer.MAX_VALUE;  // 当前最优总完成时间
    static int[] bestOrder;       // 最优调度顺序

    public static void main(String[] args) {
        // 示例数据
        t1 = new int[]{2, 1, 4};  // 机器1加工时间
        t2 = new int[]{3, 2, 1};  // 机器2加工时间
        n = t1.length;

        visited = new boolean[n];
        order = new int[n];
        bestOrder = new int[n];

        dfs(0, 0, 0, 0);

        System.out.println("最优完成时间和: " + bestF);
        System.out.print("最优作业顺序: ");
        for (int idx : bestOrder) {
            System.out.print("J" + (idx + 1) + " ");
        }
    }

    // depth: 当前调度到第几个作业
    // time1: 当前机器1完成的时间
    // time2: 当前机器2完成的时间
    // sumF: 当前总完成时间和
    static void dfs(int depth, int time1, int time2, int sumF) {
        if (depth == n) {
            if (sumF < bestF) {
                bestF = sumF;
                System.arraycopy(order, 0, bestOrder, 0, n);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                order[depth] = i;

                int nextTime1 = time1 + t1[i];
                int nextTime2 = Math.max(time2, nextTime1) + t2[i];
                int nextSumF = sumF + nextTime2;

                // 剪枝：如果当前已超过最优，就不用继续递归
                if (nextSumF < bestF) {
                    dfs(depth + 1, nextTime1, nextTime2, nextSumF);
                }

                visited[i] = false; // 回溯
            }
        }
    }
}
