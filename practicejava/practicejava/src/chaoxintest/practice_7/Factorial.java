package chaoxintest.practice_7;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(multi(20));
    }

    public static int multi(int n) {
        int sum = 0;
        int middle;
        int j;
        for (int i = n; i > 0; i--) {
            j = i;
            middle = i;
            while (j != 1) {
                middle = middle * (--j);
            }
            sum += middle;
        }
        return sum;

    }
}
