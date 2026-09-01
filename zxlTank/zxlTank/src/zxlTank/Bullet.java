package zxlTank;

public class Bullet implements Runnable {
    private int x;
    private int y;
    private int directory;
    private int speed = 3;
    public boolean isLive = true;



    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirectory() {
        return directory;
    }

    public void setDirectory(int directory) {
        this.directory = directory;
    }

    public Bullet(int x, int y, int directory) {
        this.x = x;
        this.y = y;
        this.directory = directory;
    }

    @Override
    public void run() {
       while(isLive){
           try {
               Thread.sleep(50);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
           switch (directory){
               case 0:
                   y -= speed;
                   break;
               case 1:
                   x += speed;
                   break;
               case 2:
                   y += speed;
                   break;
               case 3:
                   x -= speed;
                   break;
               default:
                   break;
           }
           if(!(x>=0&&x<=1000&&y>=0&&y<=750)){
               isLive = false;
           }

       }

    }
}
