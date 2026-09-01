package chaoxintest.computer.bag;

import java.util.SortedMap;

public class Number {
//    4. 编写Java程序，模拟简单的计算器。定义名为Number的类，该类打包到computer.bag包中，
//    设计该类能够被所有类都能访问。其中有两个整型数据成员n1和n2，应声明为私有。编写构造方法，赋予n1和n2初始值，
//    再为该类定义加（addition）、减（subtration）、乘（multiplication）、除（division）等公有成员方法，
//    分别对两个成员变量执行加、减、乘、除的运算。
//    在另一个包test.bag包中编写测试类TestNumber，该类在main方法中创建
//    Number类的对象，调用各个方法，并显示计算结果。
    private int n1;
    private int n2;

    public Number(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    public void addition(){
        System.out.println("加法结果：" + (n1+n2));
    }
    public void subtration(){
        System.out.println("减法结果:" +(n1 - n2));
    }
    public void multiplication(){
        System.out.println("乘法结果："+ (n1 * n2));
    }
    public void division(){
        System.out.println("除法结果：" + (n1/(n2 * 1.0)));
    }

}
