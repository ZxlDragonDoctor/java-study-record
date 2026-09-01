package chaoxintest.practice_9;

import java.util.*;

public class FindStudent {

    public static void main(String args[]) {

        List<Student> list = new LinkedList<Student>();

        list.add(new Student("张三",188));

        list.add(new Student("李四",178));

        list.add(new Student("周五",198));

        Iterator<Student> iter=list.iterator();

        System.out.println("排序前,链表中的数据");

        //补充代码，使用迭代器iter遍历链表，输出学生姓名和身高。
        while (iter.hasNext()) {
            Student next =  iter.next();
            System.out.println("姓名:" + next.name + "\t身高:" + next.height);
        }

        Collections.sort(list);

        System.out.println("排序后,链表中的数据");

        //补充代码，使用下标遍历链表，输出学生姓名和身高。
        for(int i =0;i<list.size();i++){
            Student stu = list.get(i);
            System.out.println("姓名:" + stu.name + "\t身高:" + stu.height);
        }

        Student zhaoLin = new Student("zhao xiao lin",178);

        int index = Collections.binarySearch(list,zhaoLin,null);

        if(index>=0) {

            System.out.println(zhaoLin.name+"和链表中"+list.get(index).name+"身高相同");

        }

    }

}