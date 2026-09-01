package chaoxintest.practice_6;

public class Person {
//    2、定义一个人类（Person），
//    在该类中定义有两个私有的（private）属性：姓名（name）和年龄（age）。
//    定义构造方法，用来初始化数据成员。再定义显示（display）方法，
//    将姓名和年龄打印出来。对分别name和age分别定义公共的get和set方法。
//    在Test类中定义main方法，创建一个人类对象，然后将信息显示；
//    通过set方法修改对象的值后，再用get方法获取并输出这个对象的值。
    private String name;
    private int age ;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void display(){
        System.out.println("姓名：" + name);
        System.out.println("年龄："+ age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
class Test{
    public static void main(String[] args) {
        Person person = new Person("jack", 23);
        System.out.println(person);
        person.setName("tom");
        person.setAge(26);
        System.out.println(person);
    }
}
