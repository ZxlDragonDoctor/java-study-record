package essential;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 分段锁实现
 * @param <K>
 * @param <V>
 */
public class SegmentedLockHashTable<K, V> {

    private static final int SEGMENT_COUNT = 16; // 分段数量
    private final Node<K, V>[][] table;
    private final ReentrantLock[] locks;

    public SegmentedLockHashTable(int capacity) {
        table = new Node[SEGMENT_COUNT][];
        locks = new ReentrantLock[SEGMENT_COUNT];
        for (int i = 0; i < SEGMENT_COUNT; i++) {
            table[i] = new Node[capacity / SEGMENT_COUNT];
            locks[i] = new ReentrantLock();
        }
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % SEGMENT_COUNT;
    }

    public void put(K key, V value) {
        int segmentIndex = hash(key);
        locks[segmentIndex].lock();
        try {
            Node<K, V>[] segment = table[segmentIndex];
            for (int i = 0; i < segment.length; i++) {
                if (segment[i] == null || segment[i].key.equals(key)) {
                    segment[i] = new Node<>(key, value);
                    break;
                }
            }
        } finally {
            locks[segmentIndex].unlock();
        }
    }

    public V get(K key) {
        int segmentIndex = hash(key);
        locks[segmentIndex].lock();
        try {
            Node<K, V>[] segment = table[segmentIndex];
            for (Node<K, V> node : segment) {
                if (node != null && node.key.equals(key)) {
                    return node.value;
                }
            }
            return null;
        } finally {
            locks[segmentIndex].unlock();
        }
    }

    private static class Node<K, V> {
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}