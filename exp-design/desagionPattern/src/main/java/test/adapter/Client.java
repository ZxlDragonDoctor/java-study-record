package test.adapter;

// 动物的接口
interface Animal {
    void makeSound();
    void catchMouse();
}

// 猫类
class Cat {
    public void catchMouse() {
        System.out.println("catches a mouse");
    }
}

// 狗类
class Dog  {

    public void makeSound() {
        System.out.println("make a Woof");
    }

}

// 猫适配器（让猫学狗叫）
class CatAdapter extends Cat implements Animal {
    private Dog dog; // 适配狗的接口

    public CatAdapter(Dog dog) {
        this.dog = dog;
    }

    @Override
    public void makeSound() {
        dog.makeSound();  // 让猫调用狗的叫声
    }
    @Override
    public void catchMouse() {
        super.catchMouse();
    }

}

// 狗适配器（让狗学猫抓老鼠）
class DogAdapter extends Dog implements Animal{
    private Cat cat; // 适配猫的接口

    public DogAdapter(Cat cat) {
        this.cat = cat;
    }

    @Override
    public void makeSound() {
        super.makeSound();
    }

    @Override
    public void catchMouse() {
        cat.catchMouse();  // 让狗调用猫抓老鼠的行为
    }
}

public class Client {
    public static void main(String[] args) {
        // 创建猫和狗实例
        Cat cat = new Cat();
        Dog dog = new Dog();

        // 让猫学狗叫
        Animal catAdapter = new CatAdapter(dog);
        System.out.println("test.adapter.Cat learning to bark:");
        catAdapter.makeSound();  // 输出 Woof

        // 让狗学猫抓老鼠
        Animal dogAdapter = new DogAdapter(cat);
        System.out.println("\ntest.adapter.Dog learning to catch mouse:");
        dogAdapter.catchMouse();  // 输出 test.adapter.Cat catches a mouse
    }
}
