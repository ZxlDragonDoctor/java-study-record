package chaoxintest.practice_4;

public class Compare {

    //    3.定义一个Compare类，在其中以重载的方式定义两个静态方法（同名），
//    分别实现求两个整数和三个整数中的最大数，并输出。（请参考教材3.3节静态多态性）
    public static int sum(int num1, int num2) {
        return num1 > num2 ? num1 : num2;
    }

    public static int sum(int num1, int num2, int num3) {
        return sum(num1, num2) > sum(num2, num3) ? sum(num1, num2) : sum(num2, num3);
    }

    public static void main(String[] args) {
        int num = Compare.sum(34, 56);
        System.out.println(num);
        num = Compare.sum(32, 54, 31);
        System.out.println(num);
    }
}
