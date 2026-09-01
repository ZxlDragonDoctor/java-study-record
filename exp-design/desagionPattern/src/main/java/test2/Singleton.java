package test2;

/**
 * 单例模式
 * 饿汉式
 */
public class Singleton {
    // 类加载时不创建实例
    //volatile 静止指令重排bug
    private static volatile Singleton instance;

    // 私有构造函数，防止外部实例化
    private Singleton() {}

    // 提供全局访问点，使用双重检查锁定机制保证线程安全
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance1);
    }
}
