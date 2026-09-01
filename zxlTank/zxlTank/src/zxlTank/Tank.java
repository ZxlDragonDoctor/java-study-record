package zxlTank;

/**
 * tank父类
 */
public class Tank {
    private int x;
    private int y;
    private int directory;//方向
    private int speed;//控制速度
    public boolean isLive = true;
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void move_UP(){
        y -= speed;
    }
    public void move_RINGHT(){
        x += speed;
    }public void move_DOWN(){
        y += speed;
    }public void move_LEFT(){
        x -= speed;
    }
    public int getDirectory() {
        return directory;
    }

    public void setDirectory(int directory) {
        this.directory = directory;
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

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
}
