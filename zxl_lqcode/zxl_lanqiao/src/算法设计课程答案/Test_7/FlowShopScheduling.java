package 算法设计课程答案.Test_7;

import java.util.*;


// 流水线
public class FlowShopScheduling {

    static class Job {
        int id;
        int m1Time;
        int m2Time;

        public Job(int id, int m1Time, int m2Time) {
            this.id = id;
            this.m1Time = m1Time;
            this.m2Time = m2Time;
        }
    }

    public static void main(String[] args) {
        // 示例作业：{M1时间, M2时间}
        Job[] jobs = {
            new Job(1, 2, 5),
            new Job(2, 6, 2),
            new Job(3, 4, 1),
            new Job(4, 8, 6),
            new Job(5, 5, 8),
            new Job(6, 9, 2)
        };

        List<Job> result = johnsonSchedule(jobs);

        System.out.print("最优作业顺序：");
        for (Job job : result) {
            System.out.print("作业" + job.id + " ");
        }
    }

    public static List<Job> johnsonSchedule(Job[] jobs) {
        List<Job> front = new ArrayList<>();
        List<Job> back = new ArrayList<>();

        for (Job job : jobs) {
            if (job.m1Time < job.m2Time) {
                front.add(job); // 加到前面
            } else {
                back.add(job); // 加到后面
            }
        }

        // 排序
        front.sort(Comparator.comparingInt(j -> j.m1Time)); // 按M1时间升序
        back.sort((j1, j2) -> Integer.compare(j2.m2Time, j1.m2Time)); // 按M2时间降序

        // 合并顺序
        List<Job> schedule = new ArrayList<>();
        schedule.addAll(front);
        schedule.addAll(back);

        return schedule;
    }
}
