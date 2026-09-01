// ////////////////////////////////////////////////////////
// 
// J_Teacher.java
// 
// 开发者: 雍俊海
// ////////////////////////////////////////////////////////
// 简介:
//     职工与教师之间的继承性例程。
// ////////////////////////////////////////////////////////
// Copyright:
//
// Using this example, please explicitly refer to the book:
//     Jun-Hai Yong. Textbook for Programming in Java. 
//     Beijing: Tsinghua University Press, 2007.
// The example should be used legally, beneficially and
// without any harm to anybody. Please note that the
// author and the publisher make no warranty of any kind
// on the examples provided.
// Citation examples:
// The program is an example in (or based on, or modified from)
//     Jun-Hai Yong. Textbook for Programming in Java. 
//     Beijing: Tsinghua University Press, 2007.
//
// Some other books by Jun-Hai Yong are:
//      [1] Jun-Hai Yong. Programming in Java. 
//          Beijing: Tsinghua University Press, 2004.
//      [2] Jun-Hai Yong. Exercises for Programming in Java.
//          Beijing: Tsinghua University Press, 2006.
//
// 版权:
// 使用本例子，请注明引用:
//     雍俊海. Java 程序设计教程. 北京: 清华大学出版社, 2007.
// 请合法使用例程，其用途应当合法有益而且不应对任何人造成任何
// 伤害或损失。同时请注意教材作者及出版社没有对例程做出任何承
// 诺与保证。
// 具体引用的方法及例子如下:
// 本程序是下面教材的一个例程(或本程序基于下面教材的例程修改)
//     雍俊海. Java 程序设计教程. 北京: 清华大学出版社, 2007.
//
// 雍俊海还编写过如下的教材和教参:
//      [1] 雍俊海. Java 程序设计. 北京: 清华大学出版社, 2004.
//      [2] 雍俊海. Java程序设计习题集(含参考答案). 
//          北京: 清华大学出版社, 2006.
//
// ////////////////////////////////////////////////////////
class J_Employee
{
    public int m_workYear; // 工作的年限

    public J_Employee( )
    {
        m_workYear = 3;
    } // J_Employee构造方法结束
    public void mb_printInfo()
{
  System.out.println("该职工的工作年限为"+m_workYear);
}


} // 类J_Employee结束

public class J_Teacher extends J_Employee  //继承父类的所有非私有成员
{
    public int m_classHour; // 授课的课时

    public J_Teacher( )
    {
        //super();//隐式的、自动的调用父类的无参构造
        m_classHour = 96;
    } // J_Teacher构造方法结束

    public void mb_printInfo( )//方法的重写/覆盖
    {
        System.out.println("该教师的工作年限为" + m_workYear);
        System.out.println("该教师授课的课时为" + m_classHour);
    } // 方法mb_printInfo结束

    public static void main(String args[ ])
    {
       J_Teacher tom = new J_Teacher( );
        tom.mb_printInfo( );
        
       
    } // 方法main结束
} // 类J_Teacher结束
//构造“Doctor”类，继承“Employee”类 ，
//        （1）增加“工作时间”属性
//
//        （2）具有和“Teacher”类类似的重载构造方法
//
//        （3）重写“Employee”类的mb_printInfo()方法，增加职称信息
//
//        （4）如何编写main方法，测试动态多态性的发生？（选做）
class Doctor extends J_Employee {
    private double worktime;

    public Doctor() {
        this.worktime = 15.0;
    }
    public Doctor(double worktime){
        this.worktime = worktime;
    }

    @Override
    public void mb_printInfo() {
        System.out.println("该医生的工作年限为" + m_workYear + "年");
        System.out.println("该医生工作的时间为" + worktime + "小时");
    }

    public static void main(String[] args) {
        J_Employee doctor = new Doctor();
        doctor.mb_printInfo();
    }


}