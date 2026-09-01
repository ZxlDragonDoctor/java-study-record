package chaoxintest.test;

import chaoxintest.animal.Dog;

public class Test {
//    定义一个名为test的包，在其中定义一个Test类。
//    在Test类中实例化一个Dog对象，设置该对象的name=“diudiu”，之后再获取name的值并输出。
public static void main(String[] args) {
    Dog dog = new Dog("diudiu");
    System.out.println(dog.getName());
 }
}
