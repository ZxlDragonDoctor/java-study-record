package zxl;

public class Shout {
    public static void main(String[] args) {

    }
}
//匿名局部内部类坐实参
interface Bell{
    void ring();
}
class Cellphone {
//   public void ring(){
//        System.out.println("你的闹钟响了");
//    }
    public static void ring(Bell a){
        a.ring();
    }
    public static void main(String[] args) {
        Cellphone.ring(new Bell(){
            public void ring(){
                System.out.println("你的闹钟响了");
            }

        });
    }
}

