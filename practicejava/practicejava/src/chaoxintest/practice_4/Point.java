package chaoxintest.practice_4;

public class Point {
//    （1）使用Eclipse编辑该代码，
//    （2）并给该代码每行添加注释，
//    （3）并总结该类代码定义中涉及的构造方法重载和方法重载的相关知识。
//    （3）编写一个测试类PointDemo，
//    在该类中创建两个Point类的实例对象，即坐标点（3,3）和（4,5），并计算这两个点间的距离。
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point(int x){
        this(x,x);
    }
    //当前点到原点的距离
    public double distance(){
        return this.distance(0,0);
    }
    //当前点到（x,y）点的距离
    public double distance(int x,int y){
        return Math.sqrt((this.x-x) * (this.x-x) + (this.y-y) * (this.y-y));
    }
    //计算到p点的距离
    public double distance(Point p){
        return this.distance(p.getX(),p.getY());
    }
}
class PointDemo{
    public static void main(String[] args) {
        Point point1 = new Point(3, 3);
        Point point2= new Point(4, 5);
        double distance = point1.distance(point2);
        System.out.println("两点间距离为" + distance);

    }
}
