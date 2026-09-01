package 得物笔试;

import java.io.File;
import java.io.InputStream;

public class Test3 {
    public static void main(String[] args) {
        TestStatic2 testStatic = new TestStatic2();
        testStatic.setA(1);
        int a = testStatic.a;
        Integer aa = 1;
        Integer bb = 2;
        System.out.println(1+2+"ww"+aa+bb);
    }

}
class TestStatic1{
    int a = 0;
}
class TestStatic2 extends TestStatic1{
    public void setA(int a){
        this.a = a;
    }
}

