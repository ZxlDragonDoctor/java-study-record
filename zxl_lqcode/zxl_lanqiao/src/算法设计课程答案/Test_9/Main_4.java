package 算法设计课程答案.Test_9;

public class Main_4 {
    public static void main(String[] args) {
        int average = 2520/6; //平均数
        int[] p = new int[7]; //1~7 个人 ,每个人原来的数量
        p[1] = average / 2 * 8 / 7;
        int sum = 0;
        sum += p[1];
        System.out.println(p[1]);
        for(int i=2;i<=6;i++){
            if(i==2){
                p[i] = average * (9-i)/(8-i) - average / 14;
                sum+=p[i];
                continue;
            }
            p[i] = average * (9-i)/(8-i) - average / (9-i);
            System.out.println(p[i]);
            sum+=p[i];
        }
        System.out.println(sum);
    }
}
