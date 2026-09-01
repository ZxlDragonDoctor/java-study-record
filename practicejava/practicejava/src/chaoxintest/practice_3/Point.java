package chaoxintest.practice_3;

import java.util.Scanner;

public class Point {
    private double x;
    private double y;
    private double z;

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }
    public void caldistance(){
        System.out.println("该坐标距离原点距离为：" + Math.sqrt(x*x + y*y + z*z));
    }
}
class TestPoint{
    public static void main(String[] args) {
        Point point = new Point();
        System.out.println("请依次输入坐标x,y,z");
        Scanner scanner = new Scanner(System.in);
        point.setX(scanner.nextDouble());
        point.setY(scanner.nextDouble());
        point.setZ(scanner.nextDouble());
        point.caldistance();
    }
}
