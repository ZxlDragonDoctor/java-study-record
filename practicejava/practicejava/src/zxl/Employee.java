package zxl;
abstract class Employee {
    private String name ;
    private int id ;
    private double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    abstract void work();
}
class CommonEmployee extends Employee{

    public void work(){
        System.out.println("普通员工\t" + getName() + "正在工作");
    }

    public CommonEmployee(String name, int id, double salary) {
        super(name, id, salary);
    }
}
class Manager extends Employee{
    private double bonus;
    public void work(){
        System.out.println("经理\t" +getName() + "正在工作");
    }

    public Manager(String name, int id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }
}
class Test{
    public static void main(String[] args) {
        new CommonEmployee("王曾",123,2000).work();
        new Manager("吴凯",233,3000,2000).work();




    }
}
