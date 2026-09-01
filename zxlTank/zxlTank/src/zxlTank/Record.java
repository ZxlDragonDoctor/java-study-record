package zxlTank;

import java.io.*;
import java.util.Vector;
@SuppressWarnings({"all"})
//该类用于文件出力
public class Record {
    private static String path = "src\\myrecord.txt";
    private static BufferedWriter bw = null;
    private static BufferedReader br = null;
    private static Vector<MyAgainst> eneytank = new Vector<>();
    private static Vector<Node> nodes = new Vector<>();
    private static MyHero hero = null;

    public static MyHero getHero() {
        return hero;
    }

    public static void setHero(MyHero hero) {
        Record.hero = hero;
    }

    private static int killNum = 0;

    public static Vector<Node> getNodes() {
        return nodes;
    }

    public static void setNodes(Vector<Node> nodes) {
        Record.nodes = nodes;
    }

    public static void setEneytank(Vector<MyAgainst> tank){
        eneytank = tank;//无法从静态变量中获取this
    }
    public static int getKillNum() {
        return killNum;
    }

    public static void setKillNum(int killNum) {
        Record.killNum = killNum;
    }

    public static void addKillNum(){
        killNum++;
    }

    //读取数据
    public static void read(){
        try {
            br = new BufferedReader(new FileReader(path));
            String len = "";
            //先读入击杀数
            Record.setKillNum(Integer.parseInt(br.readLine()));
            System.out.println(Record.killNum);
            //读入我方坐标
            len = br.readLine();
            String[] dtr = len.split(" ");
            hero = new MyHero(Integer.parseInt(dtr[0]),Integer.parseInt(dtr[1]));
            hero.setDirectory(Integer.parseInt(dtr[2]));
            //读入坦克集合坐标
            while((len=br.readLine())!=null){
                 String[] btr = len.split(" ");
                if(dtr.length==3){
                    Node node = new Node(Integer.parseInt(btr[0]),Integer.parseInt(btr[1]),Integer.parseInt(btr[2]));
                    nodes.add(node);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    //记录数据
    public static void  write(){
        String str = "";
        try {
            bw = new BufferedWriter(new FileWriter(path));
            bw.write(killNum+"\n");//写入击杀数
            bw.write(hero.getX()+ " " + hero.getY() +" " +  hero.getDirectory() +"\n");//写入我方坐标
            for (int i = 0; i < eneytank.size(); i++) {
                MyAgainst against = eneytank.get(i);
                str = against.getX() + " " + against.getY() +" "+ against.getDirectory() +  "\n";
                System.out.println(str);
                bw.write(str);//写入坦克集合坐标
                System.out.println("写入一个");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(bw!=null){
                try {
                    bw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
//保存坦克坐标
class Node{
    private int x;
    private int y;
    private int directory;

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

    public Node(int x, int y, int directory) {
        this.x = x;
        this.y = y;
        this.directory = directory;
    }
}
