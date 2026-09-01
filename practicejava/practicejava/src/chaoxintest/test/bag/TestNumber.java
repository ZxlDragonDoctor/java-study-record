package chaoxintest.test.bag;
import chaoxintest.computer.bag.Number;
public class TestNumber {
    //    在另一个包test.bag包中编写测试类TestNumber，该类在main方法中创建
//    Number类的对象，调用各个方法，并显示计算结果。
    public static void main(String[] args) {
        Number number = new Number(12,5);
        number.addition();
        number.subtration();
        number.multiplication();
        number.division();
    }
}
