package zxlTank;

import java.util.ArrayList;
import java.util.Vector;

public class MyHero extends Tank{
    public Bullet bullet;
    public Vector<Bullet> bullets = new Vector<>();
//    public boolean isLive = true;

    public MyHero(int x, int y) {
        super(x, y);
    }
    //射击
    public  void shot(){
        if (bullets.size() == 5) {
            return;
        }
       int choice = getDirectory();
       switch (choice){
           case 0:
                bullet = new Bullet(getX()+20, getY(), 0);
               break;
           case 1:
                bullet = new Bullet(getX()+60, getY()+20, 1);
                break;
           case 2:
                bullet = new Bullet(getX()+20, getY()+60,2);
                break;
           case 3:
                bullet = new Bullet(getX(), getY()+20, 3);
                break;
       }
       bullets.add(bullet);
       new Thread(bullet).start();
    }
}
