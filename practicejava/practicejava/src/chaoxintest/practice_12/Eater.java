package chaoxintest.practice_12;

public interface Eater {
//    4、编写一个Eater接口，其中有一个eat()方法。
//    定义一个Dog类实现Eater接口，再定义一个Cat类实现Eater接口。
//    在主方法中分别实例化一个Dog对象和一个Cat对象，之后把它们全部转换为Eater类型，
//    分别调用它们的eat()方法。
    public void eat();
}
class Dog implements Eater{
    @Override
    public void eat() {
        System.out.println("狗吃骨头");
    }
}
class Cat implements Eater{
    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }
}
class Test{
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Eater eater;
        eater = (Eater) dog;
        eater.eat();
        eater = (Eater) cat;
        eater.eat();
    }
}
