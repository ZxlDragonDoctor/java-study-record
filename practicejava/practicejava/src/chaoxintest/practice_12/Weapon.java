package chaoxintest.practice_12;

public class Weapon {
//    1、编写一个武器类Weapon：
//    包含成员变量造价(cost);定义接口Movable：
//    包含方法move();定义接口Attacker:包含方法attack();
//    定义一个坦克类（Tank）继承Weapon类，并且实现Movable和Attacker接口。
//    在主方法中实例化一个坦克对象，分别调用move()和attack()方法。
    private double cost;

}
interface Movable{
     public void move();
}
interface Attacker{
     public void attack();
}
class Tank extends Weapon implements Movable,Attacker{
    public void move(){
        System.out.println("坦克移动了");
    }
    public void attack(){
        System.out.println("坦克发起了攻击");
    }

    public static void main(String[] args) {
        Tank tank = new Tank();
        tank.move();
        tank.attack();
    }
}