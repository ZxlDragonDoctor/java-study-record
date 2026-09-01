package 算法设计课程答案.Test_9;

public class Main_2 {
    public static void main(String[] args) {
        int[] b = new int[9];//1~8 刚到站的人数
        b[8] = 6;
        for(int i=8;i>=1;i--){
            b[i-1] = (b[i]-(8-i+1)) * 2;
        }
        for (int i = 1; i <=8 ; i++) {
            System.out.println(b[i]);
        }
        //因为第一站人数不变，所以刚到第二站的人数就是发车人数
        System.out.println("发车人数是"+b[2]);
    }

}
