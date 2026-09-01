package test.iteratorPattern;

import java.util.*;

// Student类
class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "test.iteratorPattern.Student{name='" + name + "', age=" + age + "}";
    }
}

// Class类
class Class {
    private List<Student> students;

    public Class() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    // 返回自定义的学生迭代器
    public StudentIterator iterator() {
        return new StudentIterator(students);
    }
}

// 自定义 test.iteratorPattern.StudentIterator 迭代器
class StudentIterator implements Iterator<Student> {
    private List<Student> students;
    private int currentIndex = 0;

    // 构造器传入学生列表
    public StudentIterator(List<Student> students) {
        this.students = students;
        // 按年龄降序排序
        this.students.sort((s1, s2) -> Integer.compare(s2.getAge(), s1.getAge()));
    }

    @Override
    public boolean hasNext() {
        return currentIndex < students.size();
    }

    @Override
    public Student next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return students.get(currentIndex++);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Remove operation is not supported");
    }
}

// 主程序实现
public class SchoolSystem {
    public static void main(String[] args) {
        // 创建班级
        Class class1 = new Class();

        // 添加学生
        class1.addStudent(new Student("Alice", 20));
        class1.addStudent(new Student("Bob", 22));
        class1.addStudent(new Student("Charlie", 19));

        // 获取自定义的学生迭代器
        Iterator<Student> iterator = class1.iterator();

        // 使用迭代器按年龄降序遍历并输出学生信息
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
