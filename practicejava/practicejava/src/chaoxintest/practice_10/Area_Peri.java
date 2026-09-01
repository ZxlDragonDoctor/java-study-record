package chaoxintest.practice_10;

public abstract class Area_Peri {
//    4．编写程序计算圆的面积和周长。要求：定义一个Area_Peri抽象类，
//    有两个抽象成员方法getArea()和getPerimeter()，分别表示“计算面积”和“计算周长”；
//    定义一个Circle类，继承Area_Peri，
//    实现相应的抽象方法。在主方法中实例化一个Circle对象，调用方法获得它的面积和周长。
    abstract void getArea();
    abstract void getPerimeter();
}
class Circle extends Area_Peri{
    private double r;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    void getArea() {
        System.out.println("面积为:" + (3.14*r*r));
    }

    @Override
    void getPerimeter() {
        System.out.println("周长为:" + (3.14*2*r));
    }

    public static void main(String[] args) {
        Circle circle = new Circle(2.4);
        circle.getArea();
        circle.getPerimeter();
    }
}