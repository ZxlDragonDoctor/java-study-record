package chaoxintest.animal;

public class Dog {
//    3、定义名为animal的包，在包中定义一个Dog类，包含私有成员变量name，
//    并定义get和set方法。定义一个名为test的包，在其中定义一个Test类。
//    在Test类中实例化一个Dog对象，设置该对象的name=“diudiu”，之后再获取name的值并输出。
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
