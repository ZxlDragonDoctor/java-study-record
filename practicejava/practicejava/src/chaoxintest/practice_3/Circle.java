package chaoxintest.practice_3;

import java.util.Scanner;

public class Circle {
    private double ridous;

    public void setRidous(double ridous) {
        this.ridous = ridous;
    }

    public void  calarea(){
        System.out.println("圆的面积是" + 3.14 * Math.pow(ridous,2));
    }

    public static void main(String[] args) {
        System.out.println("请输入圆的半径：");
        Scanner scanner = new Scanner(System.in);
        Circle circle = new Circle();
        circle.setRidous(scanner.nextDouble());
        circle.calarea();
    }
}
