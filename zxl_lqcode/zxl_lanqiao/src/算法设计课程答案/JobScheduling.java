package 算法设计课程答案;

import java.util.*;

public class JobScheduling {
    static class Job {
        int id;
        int t1, t2;

        Job(int id, int t1, int t2) {
            this.id = id;
            this.t1 = t1;
            this.t2 = t2;
        }
    }

    static class Node implements Comparable<Node> {
        List<Job> schedule;  // 当前调度顺序
        boolean[] used;      // 标记作业是否已使用
        int level;           // 安排了多少作业
        int f;               // 当前完成时间和
        int bound;           // 当前结点的下界（估计值）

        Node(List<Job> schedule, boolean[] used, int level, int f, int bound) {
            this.schedule = new ArrayList<>(schedule);
            this.used = used.clone();
            this.level = level;
            this.f = f;
            this.bound = bound;
        }

        public int compareTo(Node other) {
            return Integer.compare(this.bound, other.bound);
        }
    }

    static int calculateF(List<Job> schedule) {
        int t1 = 0, t2 = 0, sum = 0;
        for (Job job : schedule) {
            t1 += job.t1;
            t2 = Math.max(t2, t1) + job.t2;
            sum += t2;
        }
        return sum;
    }

    static int lowerBound(List<Job> schedule, boolean[] used, List<Job> jobs) {
        // 简单估计：当前已排定部分的f，加上剩下作业的最小t2总和
        int f = calculateF(schedule);
        int minExtra = 0;
        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                minExtra += jobs.get(i).t2;
            }
        }
        return f + minExtra;
    }

    public static void solve(List<Job> jobs) {
        int n = jobs.size();
        PriorityQueue<Node> pq = new PriorityQueue<>();

        boolean[] used = new boolean[n];
        pq.add(new Node(new ArrayList<>(), used, 0, 0, 0));

        int minF = Integer.MAX_VALUE;
        List<Job> bestSchedule = null;

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (node.level == n) {
                if (node.f < minF) {
                    minF = node.f;
                    bestSchedule = node.schedule;
                }
                continue;
            }

            for (int i = 0; i < n; i++) {
                if (!node.used[i]) {
                    List<Job> newSchedule = new ArrayList<>(node.schedule);
                    newSchedule.add(jobs.get(i));

                    boolean[] newUsed = node.used.clone();
                    newUsed[i] = true;

                    int newF = calculateF(newSchedule);
                    int newBound = lowerBound(newSchedule, newUsed, jobs);

                    if (newBound < minF) {
                        pq.add(new Node(newSchedule, newUsed, node.level + 1, newF, newBound));
                    }
                }
            }
        }

        System.out.println("最小完成时间和: " + minF);
        System.out.print("最优调度顺序: ");
        for (Job job : bestSchedule) {
            System.out.print("J" + job.id + " ");
        }
    }

    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
            new Job(1, 2, 3),
            new Job(2, 1, 4),
            new Job(3, 3, 2)
        );

        solve(jobs);
    }
}
