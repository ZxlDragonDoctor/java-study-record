package skipList;

import org.junit.Test;

// 跳表 redis中Zset的实现
public class SkipListTest {
    private final  double SKIPLIST_P = 0.5;
    private final int MAX_LEVEL = 16;
    // 该 randomLevel 方法会随机生成 1~MAX_LEVEL 之间的数，且 ：
//        1/2 的概率返回 1
//        1/4 的概率返回 2
//        1/8 的概率返回 3 以此类推

    /**
     * @Description: 跳表随机生成level
     * @return
     */
    private int randomLevel() {
        int level = 1;
        // 当 level < MAX_LEVEL，且随机数小于设定的晋升概率时，level + 1
        // 每一次有二分之一的概率level+1 ,独立事件的运算，相乘即可
        while (Math.random() < SKIPLIST_P && level < MAX_LEVEL)
            level += 1;
        return level;
    }

    @Test
    public void testRandomLevel() {
        for (int i = 0; i < 100; i++) {
            System.out.println(randomLevel());
        }

    }

}
