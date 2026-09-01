package com.zxl.RestAssured;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 测试链表逆序
 */
public class Part2TopicTest {
    private Part2Topic topic;

    @BeforeEach
    public void setup() {
        topic = new Part2Topic();
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    public void testReverse(int[] data, int[] expected) {
        Part2Topic.CustomLinkedList list = topic.new CustomLinkedList();
        for (int value : data) {
            list.addNode(topic.new ListNode(value));
        }

        list.reverse();

        Part2Topic.CustomLinkedList expectedList = topic.new CustomLinkedList();
        for (int value : expected) {
            expectedList.addNode(topic.new ListNode(value));
        }

        assertEquals(expectedList.show(), list.show());
    }

    static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1}),
                Arguments.of(new int[]{1, 2, 5, 6, 4, 8, 7, 3, 9}, new int[]{9, 3, 7, 8, 4, 6, 5, 2, 1}),
                Arguments.of(new int[]{4, 8, 5, 6, 1, 2, 7, 3, 9}, new int[]{9, 3, 7, 2, 1, 6, 5, 8, 4})
        );
    }
}
