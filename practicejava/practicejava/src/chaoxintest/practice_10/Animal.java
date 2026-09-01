package chaoxintest.practice_10;

public abstract class Animal {
//    3．定义一个Animal抽象类，其中有一个成员变量name（String），
//    还有一个抽象方法makeNoice()；定义Dog类继承Animal类，
//    并重写实现其中的抽象方法。实例化一个Dog对象，并调用它的makeNoice()方法。
    String name;
    abstract void makeNoice();
}
class Dog extends Animal{

    void makeNoice(){
        System.out.println("调用了重写了的makeNoice");
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.makeNoice();
    }
}
