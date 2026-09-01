import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class Main_300 {
    public static boolean ans1(char[] str) {
        int length = str.length - 1;
        for (int i = 0; i < (length / 2 - 1); i++) {
            if (str[i] > str[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean ans2(char[] str) {
        int f = 0, t = str.length - 1;
        while (f <= t) {
            if (str[f] != str[t]) {
                return false;
            }
            f++;
            t--;
        }
        return true;
    }

    public static void main(String[] args) {
        int res = 0;
        for (long i = 2022; i <= 2022222022; i++) {
            String s = i + "";
            char[] str = s.toCharArray();
            if (ans1(str) && ans2(str)) {
                res++;
            }

            //在此输入您的代码...
        }
        System.out.println(res);
    }
}
        