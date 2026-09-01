package zxl.darws;

public class Exercise {
    public static void main(String[] args) {
        String a ="hello";
        String b ="hello";
        System.out.println(a.equals(b));
        P p = P.valueOf("MO");
        System.out.println(p);
    }
}
enum P{
    MO(1,"sb"),MP(2,"qw");//private static final -->使用静态方法
                                   // valueOf(String name)获取枚举常量
    private int i;
    private String j;

    P(int i, String j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public String toString() {
        return "P{" +
                "i=" + i +
                ", j='" + j + '\'' +
                '}';
    }
}
