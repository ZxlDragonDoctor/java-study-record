package zxlTank;

import Tools.AePlayWave;
import sun.awt.image.ToolkitImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;
import java.util.Vector;

@SuppressWarnings({"all"})
public class MyPanel extends JPanel implements KeyListener, Runnable {
    private MyHero tank;//我方tank
    private Vector<MyAgainst> eneytank = new Vector();//敌人坦克集合
    private Vector<Bomb> bombs = new Vector<>();//炸弹集合
    private Vector<Node> nodes = null;
    private int eneytankSize = 3;
    private Image image1;
    private Image image2;
    private Image image3;//定义三张图片

    public MyPanel() {
        Record.setEneytank(eneytank);
        System.out.println("继续上局游戏：0");
        System.out.println("开始新游戏：1");
        Scanner scanner = new Scanner(System.in);
        char key = scanner.next().charAt(0);
        switch (key){
            case '0':
                Record.read();
                tank = Record.getHero();
                nodes = Record.getNodes();
                tank.setSpeed(5);
                if(tank!=null){
                    for (int i = 0; i < nodes.size(); i++) {
                        Node node = nodes.get(i);
                        MyAgainst against = new MyAgainst(node.getX(),node.getY());
                        against.setDirectory(node.getDirectory());
                        eneytank.add(against);
                        new Thread(against).start();
                    }

                }else {
                    System.out.println("无上局游戏数据");
                }
                break;
            case '1':
                this.tank = new MyHero(40, 40);
                Record.setHero(tank);
                tank.setSpeed(5);
                for (int i = 0; i < eneytankSize; i++) {
                    MyAgainst against = new MyAgainst(100 * (i + 1), 120);
                    against.setDirectory(2);
                    new Thread(against).start();
                    eneytank.add(against);
                }
                break;
            default:
                System.out.println("你的输入有误");
                break;
        }
        //初始化图片
        image1 = Toolkit.getDefaultToolkit().getImage("out/bomb_1.png");
        image2 = Toolkit.getDefaultToolkit().getImage("out/bomb_2.png");
        image3 = Toolkit.getDefaultToolkit().getImage("out/bomb_3.png");
       new AePlayWave("src\\111.wav").start();//播放音乐
    }
    public void drawrecord(Graphics g){//画记录
        g.setColor(Color.BLACK);
        Font font = new Font("宋体",Font.BOLD,25);
        g.setFont(font);
        g.drawString("你的坦克击杀数",1200,30);
        drawTank(1200,50,g,0,1);
        g.setColor(Color.BLACK);
        g.drawString(Record.getKillNum()+"",1300,80);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);//画游戏区域
        if (tank.isLive) {
            drawTank(tank.getX(), tank.getY(), g, tank.getDirectory(), 0);//画我方坦克
        }
        //画敌方坦克
        for (int i = 0; i < eneytank.size(); i++) {
            MyAgainst against = eneytank.get(i);
            if (against.isLive) {
                drawTank(against.getX(), against.getY(), g, against.getDirectory(), 1);
            } else {
                eneytank.remove(against);
            }
            //画敌方子弹
            for (int j = 0; j < against.bullets.size(); j++) {
                Bullet bullet = against.bullets.get(j);
                if (bullet != null && bullet.isLive != false) {
                    g.setColor(Color.red);
                    g.draw3DRect(bullet.getX(), bullet.getY(), 1, 1, false);
                } else {
                    against.bullets.remove(bullet);
                }
            }
        }
        //画我方子弹
        for (int i = 0; i < tank.bullets.size(); i++) {
            Bullet bullet = tank.bullets.get(i);
            if (bullet != null && bullet.isLive != false) {
                g.setColor(Color.cyan);
                g.draw3DRect(bullet.getX(), bullet.getY(), 1, 1, false);
            } else {
                tank.bullets.remove(bullet);
            }
        }
        //画炸弹
        for (int i = 0; i < bombs.size(); i++) {
            System.out.println("启动");
            Bomb bomb = bombs.get(i);
            if (bomb.life > 6) {
                g.drawImage(image1, bomb.x, bomb.y, 60, 60, this);
            } else if (bomb.life > 3) {
                g.drawImage(image2, bomb.x, bomb.y, 60, 60, this);
            } else if (bomb.life > 0) {
                g.drawImage(image3, bomb.x, bomb.y, 60, 60, this);
            }
            bomb.lifeDown();
            if (bomb.life == 0) {
                bombs.remove(bomb);
            }

        }
        drawrecord(g);

    }


    //绘制tank
    public void drawTank(int x, int y, Graphics g, int directory, int type) {
        //确定tank类型
        switch (type) {
            case 0:
                g.setColor(Color.cyan);
                break;
            case 1:
                g.setColor(Color.blue);
                break;
            default:
                break;
        }
        //确定tank方向
        switch (directory) {
            case 0://向上的方向
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y, x + 20, y + 30);
                break;
            case 1://向右的方向
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x + 60, y + 20);
                break;
            case 2://向下的方向
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 60, x + 20, y + 30);
                break;
            case 3://向左的方向
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x, y + 20);
                break;
            default:
                break;
        }
    }

    //判断是否击中
    public void  hitMyhero() {
        for (int i = 0; i < eneytank.size(); i++) {
            MyAgainst against = eneytank.get(i);
            for (int j = 0; j < against.bullets.size(); j++) {
                Bullet bullet = against.bullets.get(j);
                hitJudge(bullet, tank);
            }
        }
    }
    public void hitAgainst(){
        for (int i = 0; i < eneytank.size(); i++) {
            MyAgainst against = eneytank.get(i);
            for (int j = 0; j < tank.bullets.size(); j++) {
                Bullet bullet = tank.bullets.get(j);
                hitJudge(bullet, against);
            }
        }
    }

    public void hitJudge(Bullet bullet, Tank tank) {
        switch (tank.getDirectory()) {
            case 0:
            case 2:
                if (bullet != null && bullet.getX() > tank.getX() && (bullet.getX() < tank.getX() + 40) &&
                        bullet.getY() > tank.getY() && bullet.getY() < (tank.getY() + 60)) {
                    bullet.isLive = false;
                    tank.isLive = false;
                    //击杀数增加
                    //判断是否是敌方坦克集合而不是我方坦克
                    if(tank instanceof  MyAgainst){
                        Record.addKillNum();
                    }
                    Bomb bomb = new Bomb(tank.getX(), tank.getY());
                    bombs.add(bomb);//添加炸弹
                }
                break;
            case 1:
            case 3:
                if (bullet != null && bullet.getX() > tank.getX() && (bullet.getX() < tank.getX() + 60) &&
                        bullet.getY() > tank.getY() && bullet.getY() < (tank.getY() + 40)) {
                    bullet.isLive = false;
                    tank.isLive = false;
                    //击杀数增加
                    //判断是否是敌方坦克集合而不是我方坦克
                    if(tank instanceof  MyAgainst){
                        Record.addKillNum();
                    }
                    Bomb bomb = new Bomb(tank.getX(), tank.getY());
                    bombs.add(bomb);//添加炸弹
                }
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            tank.setDirectory(0);
            if (tank.getY() > 0) {
                tank.move_UP();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            tank.setDirectory(1);
            if (tank.getX() + 60 < 1000) {
                tank.move_RINGHT();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            tank.setDirectory(2);
            if (tank.getY() + 60 < 750) {
                tank.move_DOWN();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            tank.setDirectory(3);
            if (tank.getX() > 0) {
                tank.move_LEFT();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_J) {
            tank.shot();
        }
        this.repaint();
    }


    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            hitAgainst();
            hitMyhero();
            this.repaint();
        }
    }
}

