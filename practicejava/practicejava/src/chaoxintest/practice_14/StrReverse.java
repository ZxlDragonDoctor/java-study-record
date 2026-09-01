package chaoxintest.practice_14;

public class StrReverse {
    public static void main(String[] args) {
//        4. 创建一个 stringbuffer 对象，添加字符串"abcd","efgh","adef","1234"到
//        对象中，测试对象大小和容量的变化及元素的遍历，删除指定第 5 个位置的字符，
//        插入一个字符'a'到第 3 个位置，对串进行反转操作。
        StringBuffer buf = new StringBuffer();
        buf.append("abcd");
        buf.append("efgh");
        buf.append("adef");
        buf.append("1234");
        System.out.println(buf);
        System.out.println("元素长度" + buf.length());
        System.out.println("容量大小" + buf.capacity());
        buf.delete(5,6);
        System.out.println("删除后");
        System.out.println("元素长度" + buf.length());
        System.out.println("容量大小" + buf.capacity());
        buf.insert(3,'a');
        System.out.println("添加后");
        System.out.println("元素长度" + buf.length());
        System.out.println("容量大小" + buf.capacity());
        buf.reverse();
        System.out.println("翻转后");
        System.out.println("元素长度" + buf.length());
        System.out.println("容量大小" + buf.capacity());
        System.out.println(buf);

    }

}
