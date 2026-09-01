package chaoxintest.practice_9;

public class Student implements Comparable<Student> {

    int height=0;

    String name;

    Student(String n,int h) {

        name=n;

        height = h;



    }

    public int compareTo(Student b) { // 两个Student对象相等当且仅当二者的height值相等

        return (this.height-b.height);

    }

}

