package zxlTank;

public class Bomb {
    public int x;
    public int y;
    public boolean isLive = true;
    public int life = 9;//生命周期

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void lifeDown(){
        if(life>0){
            life--;
        }else{
            isLive = false;
        }
    }
}
