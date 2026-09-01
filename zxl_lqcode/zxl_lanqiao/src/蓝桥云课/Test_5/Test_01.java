package 蓝桥云课.Test_5;

import java.util.*;

public class Test_01 {
    // 	问题二：猜数字游戏。张三和李四进行猜数字游戏，张三拿着2-99之间不相同的两个数字的和，李四拿着这两个数的积。
//	张三说：我不知道这两个数字是多少，但我肯定你也不知道。
//这说明能组成这两个数的一对数不止一对
// 李四说：你这么说，我就知道这两个数是多少了。
//这说明能组成这个积的一对数在能组成和的数对中是唯一的
// 张三说：你这么说，我也知道了。
// 综上在能组成和的这几对数中有且只有一对数能组成这个积
// 请问：这两个数是多少。
    public static void main(String[] args) {
        int a, b;
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        desparate(a, b);
    }

    public static void desparate(int a, int b) {
        for (int i = 2; i < (a + 1) / 2; i++) {
            int m = a - i;
            if (i * m == b) {
                System.out.println("这俩个数是:"+i+"和"+m);
            }
        }
    }
}