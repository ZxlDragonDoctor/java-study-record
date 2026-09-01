package test.singlePattern;

import java.util.*;

public class Multiton {
    private static Map<String, Multiton> instances = new HashMap<>();
    private static final int MAX_INSTANCES = 3; // 限制最多实例数
    private String value;

    // 私有化构造函数，防止外部直接创建实例
    private Multiton(String value) {
        this.value = value;
    }

    // 获取实例的方法
    public static Multiton getInstance(String key) {
        //如果实例已存在，则直接返回该实例
        if (instances.containsKey(key)) {
            return instances.get(key);
        }
        // 如果实例未满，则创建新的实例
        if (instances.size() < MAX_INSTANCES) {
            Multiton instance = new Multiton(key);
            instances.put(key, instance);
            return instance;
        }
        // 1. 达到最大实例数时复用已有实例，当达到最大实例数时，每次调用，就只使用了一个相同的实例
        // return new ArrayList<>(instances.values()).get(0);
        // 2. 达到最大实例数时复用已有实例,随机返回摸个某个实例
        List<Multiton> multitons = new ArrayList<>(instances.values());
        return multitons.get(new Random(System.nanoTime()).nextInt(multitons.size()));
    }


    // 获取实例值
    public String getValue() {
        return value;
    }

    // 获取所有实例（用于调试）
    public static Map<String, Multiton> getInstances() {
        return instances;
    }

    public static void main(String[] args) {
        // 测试代码
        Multiton a = Multiton.getInstance("A");
        Multiton b = Multiton.getInstance("B");
        Multiton c = Multiton.getInstance("C");
        Multiton d = Multiton.getInstance(null); // 复用已有实例


        System.out.println(a.getValue()); // 输出 A
        System.out.println(b.getValue()); // 输出 B
        System.out.println(c.getValue()); // 输出 C
        System.out.println(d.getValue()); // 随机返回一个实例
        System.out.println(d.getValue());//
        System.out.println(d.getValue());//
        System.out.println(d.getValue());//

        // 输出实例集合
        System.out.println(Multiton.getInstances().keySet()); // 应该只输出 A, B, C
    }
}
