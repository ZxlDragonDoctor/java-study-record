package zxl.hashmap;

import java.util.*;

@SuppressWarnings({"all"})
public class EntrySet {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put(1, new Employee("wang", 29990));
        map.put(2, new Employee("zxl", 12000));
        map.put(3, new Employee("wukai", 30000));

        //强调for循环遍历
        Set entryset = map.entrySet();//返回一个Set集合
        for (Object obj : entryset) {
            Map.Entry m = (Map.Entry) obj;
//            System.out.println("id:"m.getKey()+ "__"+m.getValue());
            Employee e = (Employee) m.getValue();
            if (e.getSalary() > 18000) {
                System.out.println(e);
            }

        }
        //迭代器遍历
        Iterator iterator = entryset.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            Map.Entry m = (Map.Entry) next;
//            System.out.println("id:"m.getKey()+ "__"+m.getValue());
            Employee e = (Employee) m.getValue();
            if (e.getSalary() > 18000) {
                System.out.println(e);
            }
        }
        //对key遍历
        Set set = map.keySet();
        for (Object o : set) {
            int o1 = (int) o;
            System.out.println(o1);
        }
        //对value遍历
        Collection values = map.values();
        for (Object o : values) {
            Employee employee = (Employee) o;
            System.out.println(employee);
        }


    }
}
class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

