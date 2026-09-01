package test2;

/**
 * 单例模式
 * 饱汉式
 */
public class Singleton1 {
    private static Singleton1 instance = new Singleton1();
    public  static Singleton1 getInstance(){
        return instance;
    }
    private Singleton1(){}

}
