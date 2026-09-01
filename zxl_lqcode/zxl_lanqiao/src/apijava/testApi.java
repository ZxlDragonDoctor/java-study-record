package apijava;


import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;


public class testApi {

    public static void main(String[] args) throws IOException {
//        main0();
        //main1();
//        main3();
//        main6();
            main7();
    }
    public static void main0() throws IOException {
        // 扫描器
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        Long b = sc.nextLong();
        float c = sc.nextFloat();
        double d = sc.nextDouble();
        String s = sc.next();  //不会读取带空格的字符串
        String e = sc.nextLine(); // 读取带空格的字符串，直到遇到换行符，可以多写一次nextLine()解决跳行的问题
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(s);
        System.out.println(e);
        sc.close();
    }

    // 处理大数据输入
    public static void main1() throws IOException {
        // 读取一行
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        // 输出一行
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        writer.write(str);
        writer.flush();
    }
    //字符串操作
    public static void main2()  {
        //格式化输出，保留几位小数
        System.out.printf("%2.2f\n",1.3456);
        //字符串格式化
        String str = String.format("小数是%2.2f", 1.3456);
        System.out.println(str);

        String testStr = "hello world";

    }
    //桟，队列
    public static void main3() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        Integer pop2 = stack.pop();
        Integer pop1 = stack.pop();
        System.out.println(pop1);
        System.out.println(pop2);
        boolean isStackEmpty =stack.empty(); //是否为空桟
        System.out.println("桟是否为空: " + isStackEmpty);
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        Integer poll2 = queue.poll();
        Integer poll1 = queue.poll();
        boolean isQueueEmpty = queue.isEmpty(); // 是否为空
        System.out.println("队列是否为空: " + isQueueEmpty);
        System.out.println(poll1);
        System.out.println(poll2);
    }
    // 集合，列表
    public static void main4() {
        // 集合的三种遍历
        Map<String,Integer> map = new HashMap<>();
        map.put("a",1);
        map.put("b",2);
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        for(String key:map.keySet()){
            System.out.println(key);
        }
        for (Integer value:map.values()){
            System.out.println(value);
        }
        //插入空集合设置默认值
        map.getOrDefault("c", 1);//：查询键"c"的值，如果不存在则返回1，不会修改map。
        map.merge("c", 1, Integer::sum);//：如果键"c"不存在，则插入1；如果存在，则将1与现有值合并。
        map.computeIfAbsent("d", k -> 1);//：如果键"d"不存在，则插入1；如果存在，则返回现有值。
        map.computeIfPresent("d", (k, v) -> v + 1);//：如果键"d"存在，则将现有值加1；如果不存在，则不执行任何操作。
    }
    // collection，迭代器
    public static void main5() {
        // 迭代器
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        Iterator<Integer> iterator1 = set.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        Iterator<Integer> iterator2 = queue.iterator();
        while (iterator2.hasNext()){
            System.out.println(iterator2.next());
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        Iterator<Integer> iterator3 = stack.iterator();
        while (iterator3.hasNext()){
            System.out.println(iterator3.next());
        }
        // 列表反转
        Collections.reverse(list);
        String str = "hello world";
        // 字符反转
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.reverse();
        System.out.println(stringBuilder.toString());
        System.out.println(new String(stringBuilder));


    }
    public static void main6() {
        String str = "hello world";
        char a = 'a';
        //排序
        // 对列表排序
        List<Character> list = new ArrayList<>();
        list.add('a');
        list.add('b');
        Collections.sort(list);
        System.out.println(list);
        // 对单个字符排序
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        System.out.println(ch);
    }
    // 大整数，小数
    public static void main7() {
        BigInteger bigInteger = new BigInteger("23");
        BigInteger bigInteger1 = new BigInteger("12");
        BigInteger sum = bigInteger1.add(bigInteger);
        BigInteger subtract = bigInteger1.subtract(bigInteger);
        BigInteger multiply = bigInteger1.multiply(bigInteger);
        BigInteger divide = bigInteger1.divide(bigInteger);
        System.out.println(sum);
        System.out.println(subtract);
        System.out.println(multiply);
        System.out.println(divide);
        BigDecimal bigDecimal = new BigDecimal("23.123");
        BigDecimal bigDecimal1 = new BigDecimal("12.123");
        BigDecimal sum1 = bigDecimal1.add(bigDecimal);
        BigDecimal subtract1 = bigDecimal1.subtract(bigDecimal);
        BigDecimal multiply1 = bigDecimal1.multiply(bigDecimal);
        BigDecimal divide1 = bigDecimal1.divide(bigDecimal, BigDecimal.ROUND_HALF_UP);
        System.out.println(sum1);
        System.out.println(subtract1);
        System.out.println(multiply1);
        System.out.println(divide1);
        System.out.println(bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP));
        String s = bigInteger.toString();
        System.out.println(s);

    }
}
