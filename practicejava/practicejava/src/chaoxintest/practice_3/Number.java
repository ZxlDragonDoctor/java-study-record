package chaoxintest.practice_3;

import java.util.Scanner;

public class Number {

    private int n1;
    private int n2;

    public int getN1() {
        return n1;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public int getN2() {
        return n2;
    }

    public void setN2(int n2) {
        this.n2 = n2;
    }
    public void addition(){
        System.out.println("加法结果" + (n1 + n2));
    }
    public void subtration(){
        System.out.println("减法结果" + (n1-n2));
    }
    public void multiplication(){
        System.out.println("乘法结果" + (n1 * n2));
    }
    public void division(){
        System.out.println("除法结果" + (n1 / n2));
    }

    public static void main(String[] args) {
        Number number = new Number();
        System.out.println("请输入两个整数");
        Scanner scanner = new Scanner(System.in);
        number.setN1(scanner.nextInt());
        number.setN2(scanner.nextInt());
        number.addition();
        number.subtration();
        number.multiplication();
        number.division();
    }
}
