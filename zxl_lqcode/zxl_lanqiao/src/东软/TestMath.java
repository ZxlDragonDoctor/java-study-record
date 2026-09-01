package 东软;

public class TestMath {
    static int i;
    public static void main(String[] args) {
        TestMath testMath = new TestMath();
        testMath.test();
    }
    public static void test(){
        int a = 1;
        int b = 2;
//        System.out.println(i);
        System.out.println(1+2+"aa"+a+b); //3aa12
        System.out.println(0.1+0.2 == 0.2); // false
    }
    protected TestMath(){

    }
}
