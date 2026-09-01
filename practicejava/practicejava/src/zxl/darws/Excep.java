package zxl.darws;

public class Excep {
    public static void main(String[] args) {
        int a =10;
        try {
            memthod();
            a = 100;
        } catch (Exception e) {
            a = 20;
            System.out.println("“Ï≥£–≈œ¢£∫" + e);
        }finally {
             a = 30;
        }
        System.out.println(a);
    }
    public static void memthod() throws Exception{
        throw new Exception();
    }
}
