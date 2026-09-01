package chaoxintest.practice_12;

public interface Shape {
//    2、编写一个计算图形面积和周长的程序，程序能够计算并输出正方形和圆形的面积和周长。
//    以面向对象的程序设计方法编写程序，应当至少包括3个类，正方形类，圆形类和测试类（主控程序类）。
//    为了考虑程序的未来扩展，
//    要求先定义这几种图形共同的父接口Shape（Shape表示图形），在Shape中定义计算面积和周长的方法。
     public void area();
     public void circle();
}
class Square implements Shape{
     private double x;
     private double y;

     public Square(double x, double y) {
          this.x = x;
          this.y = y;
     }

     public void area(){
         System.out.println("面积为" + x*y);
    }
    public void circle(){
         System.out.println("周长为" + 2*(x+y));
    }
}
class Round implements Shape{
     private double r;

     public Round(double r) {
          this.r = r;
     }

     public void area(){
          System.out.println("面积为" + Math.PI * r * r);
     }
     public void circle(){
          System.out.println("周长为" + 2 * Math.PI * r);
     }
}
class Test_{
     public static void main(String[] args) {
          Shape shape;
          shape = new Square(2,3);
          shape.area();
          shape.circle();
          shape = new Round(3.4);
          shape.area();
          shape.circle();
     }

}

