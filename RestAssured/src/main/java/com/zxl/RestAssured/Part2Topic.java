package com.zxl.RestAssured;




import java.util.ArrayList;


/**
 * 题目： 链表逆序
 * 答题要求：
 *     1. 要求实现对链表进行逆序的方法。
 *     2. 使用 Java 实现。
 *     3. 要求必须使用以下模版（不使用模版，自动判零分）。
 *     4. 除代码实现区域外，其它任何代码不可编辑改动，否则零分。
 * 题目要求：
 *     - 链表创建、添加节点、显示链表等功能方法无需编写，模板中已实现，只需实现链表逆序方法。
 *     - 链表通过自身 head 属性获取到链表的头结点指针
 *     - 链表的元素初始顺序是无序的
 *     - 将链表中的元素顺序进行逆序
 *     - 示例
 *         初始顺序：
 *         head :  2 -> 5 -> 3 -> 1 -> 4
 *         逆序后顺序：
 *         head :  4 -> 1 -> 3 -> 5 -> 2
 */
public class Part2Topic {
    class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    class CustomLinkedList {
        ListNode head;
        ListNode tail;
        ListNode current;
        ListNode follow;

        // Constructor for empty Link
        CustomLinkedList() {
            this.head = null;
            this.tail = null;
            this.current = null;
            this.follow = null;
        }

        // Add a new node to the list
        void addNode(ListNode node) {
            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }
            this.tail = node;
        }

        // Display the list
        String show() {
            if (this.head == null) {
                System.out.println("链表中没有节点");
                return "";
            }
            this.current = this.head;
            StringBuilder result = new StringBuilder();
            while (this.current != null) {
                if (this.current.next != null) {
                    System.out.print(this.current.data + " -> ");
                    result.append(this.current.data).append(" -> ");
                } else {
                    System.out.println(this.current.data);
                    result.append(this.current.data);
                }
                this.current = this.current.next;
            }
            return result.toString();
        }

        // Reverse the list
        void reverse() {
            if(this.head==null || this.head.next==null || this.head==tail){
                return;
            }
            ArrayList<Object> objects = new ArrayList<>();
            //在此处编写代码
            ListNode p = this.head;
            objects.add(p.data);
            while (p.next!=null){
                p = p.next;
                objects.add(p.data);
            }
            Object[] array = objects.toArray();
            ListNode q = this.head;
            for(int i=array.length-1;i>=0;i--){
                q.data = (int)array[i];
                q = q.next;
            }
        }
    }
}
