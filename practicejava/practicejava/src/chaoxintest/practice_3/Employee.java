package chaoxintest.practice_3;

public class Employee {
    private double age;
    private double workyears;
    private String name;

    public Employee(double age, double workyears, String name) {
        this.age = age;
        this.workyears = workyears;
        this.name = name;
    }

    @Override
    public String toString() {
        return "年龄：" + age +
                "工作年限：" + workyears +
                "姓名：" + name ;
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee(23,4,"王争");
        Employee employee2 = new Employee(40,20,"吴凯");
        System.out.println(employee1);
        System.out.println(employee2);
    }

}
