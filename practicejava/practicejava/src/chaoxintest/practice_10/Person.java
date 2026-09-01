package chaoxintest.practice_10;

public class Person {
//    2. 构造一个人(Person)类作为父类，要求包含年龄(age)和姓名(name)两个成员域。
//    构造学生子类(Student)继承该父类，大学生子类中包含学号（studentID）
//    成员域和输出信息的成员方法printinfo()；
//    在主方法中实例化一个Student对象，调用方法输出信息。
    protected int age;
    protected String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

}
class Student extends Person{
    String studentID;

    public Student(int age, String name, String studentID) {
        super(age, name);
        this.studentID = studentID;
    }

    public void printinfo(){
        System.out.println("姓名:" + name +"\t年纪:" + age + "\t学号:" + studentID);
    }

    public static void main(String[] args) {
        Student student = new Student(23, "李华", "20220339");
        student.printinfo();

    }

}

