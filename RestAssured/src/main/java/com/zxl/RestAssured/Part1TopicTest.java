package com.zxl.RestAssured;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * 测试循环滚动数组
 */
public class Part1TopicTest {
    public static Stream<Object[]> testData() {
        return Stream.of(
                new Object[]{new Integer[]{1, 2, 3, 4, 5, 6, 7}, 4, new Integer[]{5, 6, 7, 1, 2, 3, 4}},
                new Object[]{new Integer[]{1, 2, 3, 4, 5, 6, 7}, 3, new Integer[]{4, 5, 6, 7, 1, 2, 3}},
                new Object[]{new Integer[]{1, 2, 3, 4, 5}, 3, new Integer[]{4, 5, 1, 2, 3}},
                new Object[]{new Integer[]{1, 2}, 2, new Integer[]{1, 2}},
                new Object[]{new Integer[]{1}, 4, new Integer[]{1}},
                new Object[]{new String[]{"hello", "Python", "MySQL", "Flask"}, 3, new String[]{"Flask", "hello", "Python", "MySQL"}}
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void testCyclicRolling(Object[] nums, int k, Object[] expected) {
        Part1Topic.cyclicRolling(nums, k);
        System.out.println("期望结果"+Arrays.toString(expected));
        System.out.println("实际结果"+Arrays.toString(nums));
        assertArrayEquals(expected, nums);
    }
}
