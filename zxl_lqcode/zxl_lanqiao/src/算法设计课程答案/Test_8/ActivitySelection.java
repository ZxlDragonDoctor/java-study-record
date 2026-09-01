package 算法设计课程答案.Test_8;

import java.util.*;

class Activity {
    int startTime;
    int finishTime;
    
    Activity(int startTime, int finishTime) {
        this.startTime = startTime;
        this.finishTime = finishTime;
    }
}

public class ActivitySelection {
    
    // 比较活动的结束时间，用于排序
    public static class ActivityComparator implements Comparator<Activity> {
        @Override
        public int compare(Activity a1, Activity a2) {
            return Integer.compare(a1.finishTime, a2.finishTime);
        }
    }

    // 贪心算法来选择最大相容活动子集
    public static List<Activity> selectActivities(List<Activity> activities) {
        // 按活动的结束时间排序
        Collections.sort(activities, new ActivityComparator());
        
        List<Activity> selectedActivities = new ArrayList<>();
        int lastFinishTime = -1;  // 记录上一个选中的活动的结束时间
        
        for (Activity activity : activities) {
            // 如果当前活动的开始时间大于等于上一个活动的结束时间，则可以选择该活动
            if (activity.startTime >= lastFinishTime) {
                selectedActivities.add(activity);
                lastFinishTime = activity.finishTime;
            }
        }
        
        return selectedActivities;
    }

    public static void main(String[] args) {
        // 示例活动集合
        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity(1, 4));
        activities.add(new Activity(3, 5));
        activities.add(new Activity(0, 6));
        activities.add(new Activity(5, 7));
        activities.add(new Activity(8, 9));
        activities.add(new Activity(5, 9));
        
        // 选择活动
        List<Activity> selectedActivities = selectActivities(activities);
        
        // 输出选中的活动
        System.out.println("最大相容活动子集：");
        for (Activity activity : selectedActivities) {
            System.out.println("活动：" + activity.startTime + " -> " + activity.finishTime);
        }
    }
}
