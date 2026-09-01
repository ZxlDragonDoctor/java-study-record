package zxlTank;

import java.util.Random;
import java.util.Vector;
@SuppressWarnings({"all"})
public class MyAgainst extends Tank implements Runnable{
    public Bullet bullet;
    public Vector<Bullet> bullets = new Vector<>();
//    public boolean isLive = true;
    public Vector<MyAgainst> eneytank = new Vector<>();//

    public Vector<MyAgainst> getEneytank() {
        return eneytank;
    }

    public void setEneytank(Vector<MyAgainst> eneytank) {
        this.eneytank = eneytank;
    }

    public MyAgainst(int x, int y){
        super(x,y);
    }
    public  void shot(){
        if(bullets.size()==5){
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
    //判断tank是否相重
    public boolean isTouchEneyTank(){//判断是否相重
            int  x = this.getX();
            int  y = this.getY();
            switch (getDirectory()) {
                case 0:
                    for(int i=0;i<eneytank.size();i++) {
                        MyAgainst against = eneytank.get(i);
                       if(against != this){
                           //判断上下
                           if(against.getDirectory()==0||against.getDirectory()==2) {
                               //左上角点的坐标
                               if (x >= against.getX() && x <=against.getX() + 40
                                       && y >=against.getY() && y <= against.getY() + 60) {
                                   return true;
                               }
                               //右上角点的坐标
                               if (x+40>= against.getX() && x+40 <=against.getX() + 40
                                       && y >=against.getY() && y <= against.getY() + 60) {
                                   return true;
                               }
                           }
                           //判断左右
                           if(against.getDirectory()==1||against.getDirectory()==3) {
                               if (x >= against.getX() && x <= against.getX() + 60
                                       && y >= against.getY() && y <= against.getY() + 40) {
                                   return true;
                               }
                               if (x+40 >= against.getX() && x+40 <= against.getX() + 60
                                       && y >= against.getY() && y <= against.getY() + 40) {
                                   return true;
                               }

                           }
                       }
                    }
                    break;
                case 1:
                    for(int i=0;i<eneytank.size();i++) {
                        MyAgainst against = eneytank.get(i);
                        if(against != this){
                            //判断上下
                            if(against.getDirectory()==0||against.getDirectory()==2) {
                                //右上角点的坐标
                                if (x+60 >= against.getX() && x+60 <=against.getX() + 40
                                        && y >=against.getY() && y <= against.getY() + 60) {
                                    return true;
                                }
                                //右下角点的坐标
                                if (x+60>= against.getX() && x+60 <=against.getX() + 40
                                        && y+40>=against.getY() && y +40<= against.getY() + 60) {
                                    return true;
                                }
                            }
                            //判断左右
                            if(against.getDirectory()==1||against.getDirectory()==3) {
                                if (x +60>= against.getX() && x+60 <= against.getX() + 60
                                        && y >= against.getY() && y <= against.getY() + 40) {
                                    return true;
                                }
                                if (x+60 >= against.getX() && x+60 <= against.getX() + 60
                                        && y+60 >= against.getY() && y+60 <= against.getY() + 40) {
                                    return true;
                                }

                            }
                        }
                    }
                break;
                case 2:
                    for(int i=0;i<eneytank.size();i++) {
                        MyAgainst against = eneytank.get(i);
                        if(against != this){
                            //判断上下
                            if(against.getDirectory()==0||against.getDirectory()==2) {
                                //左下角点的坐标
                                if (x >= against.getX() && x <=against.getX() + 40
                                        && y+60 >=against.getY() && y+60 <= against.getY() + 60) {
                                    return true;
                                }
                                //右下角点的坐标
                                if (x+40>= against.getX() && x+40 <=against.getX() + 40
                                        && y+60 >=against.getY() && y+60 <= against.getY() + 60) {
                                    return true;
                                }
                            }
                            //判断左右
                            if(against.getDirectory()==1||against.getDirectory()==3) {
                                if (x >= against.getX() && x <= against.getX() + 60
                                        && y+60 >= against.getY() && y+60 <= against.getY() + 40) {
                                    return true;
                                }
                                if (x+40 >= against.getX() && x+40 <= against.getX() + 60
                                        && y+60 >= against.getY() && y+60 <= against.getY() + 40) {
                                    return true;
                                }

                            }
                        }
                    }
                break;
                case 3:
                    for(int i=0;i<eneytank.size();i++) {
                        MyAgainst against = eneytank.get(i);
                        if(against != this){
                            //判断上下
                            if(against.getDirectory()==0||against.getDirectory()==2) {
                                //左上角点的坐标
                                if (x >= against.getX() && x <=against.getX() + 40
                                        && y >=against.getY() && y <= against.getY() + 60) {
                                    return true;
                                }
                                //左下角点的坐标
                                if (x>= against.getX() && x <=against.getX() + 40
                                        && y+40 >=against.getY() && y+40 <= against.getY() + 60) {
                                    return true;
                                }
                            }
                            //判断左右
                            if(against.getDirectory()==1||against.getDirectory()==3) {
                                if (x >= against.getX() && x <= against.getX() + 60
                                        && y >= against.getY() && y <= against.getY() + 40) {
                                    return true;
                                }
                                if (x >= against.getX() && x <= against.getX() + 60
                                        && y+40 >= against.getY() && y+40 <= against.getY() + 40) {
                                    return true;
                                }

                            }
                        }
                    }
                break;
            }
        return false;
    }
//    public boolean isTouchEneyTank_(int cx,MyAgainst against){
//        int x = this.getX();
//        int y = this.getY();
//        //判断上下
//        if(against.getDirectory()==0||against.getDirectory()==2) {
//            //左上角点的坐标
//            if (x >= against.getX() && x <=against.getX() + 40
//                    && y >=against.getY() && y <= against.getY() + 60) {
//                return true;
//            }
//            //右上角点的坐标
//            if (cx>= against.getX() && cx <=against.getX() + 40
//                    && y >=against.getY() && y <= against.getY() + 60) {
//                return true;
//            }
//        }
//        //判断左右
//        if(against.getDirectory()==1||against.getDirectory()==3) {
//            if (x >= against.getX() && x <= against.getX() + 60
//                    && y >= against.getY() && y <= against.getY() + 40) {
//                return true;
//            }
//            if (cx >= against.getX() && cx <= against.getX() + 60
//                    && y >= against.getY() && y <= against.getY() + 40) {
//                return true;
//            }
//
//        }
//        return false;
//    }

    @Override
    public void run()  {
        setSpeed(5);
        while(isLive){
            try {
                Thread.sleep(500);
                shot();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            switch (getDirectory()){
                case 0:
                    for (int i = 0; i < 20; i++) {
                        if(getY()>0&&!(isTouchEneyTank())){
                            move_UP();
                        }
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                           throw new RuntimeException(e);
                        }
                    }
                    break;
                case 1:
                    for (int i = 0; i < 20; i++) {
                        if(getX()+60<1000&&!(isTouchEneyTank())){
                            move_RINGHT();
                        }
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < 20; i++) {
                        if(getY()+60<750&&!(isTouchEneyTank())){
                            move_DOWN();
                        }
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < 20; i++) {
                        if(getX()>0&&!(isTouchEneyTank())){
                            move_LEFT();
                        }
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
            }
            setDirectory((int)(Math.random()*4));//随机移动
        }
    }
}
