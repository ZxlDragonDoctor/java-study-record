package chaoxintest.practice_16;

import java.io.*;
import java.util.Random;

public class IO_3 {
    public static final String srcpath = "D:\\Exercise.dat";

    public static void main(String[] args) {
//        使用DataOutputStream中的writeInt(int)方法创建一个名为Exercise.dat的二进制数据文件，
//        将100个随机生成的整数写入这个文件，
//        然后再从文件中读取这些整数，并计算它们的总和。要求：加入相应的异常处理。
        DataInputStream din = null;
        DataOutputStream dou = null;
        try {
            int num;
            dou = new DataOutputStream(new FileOutputStream(srcpath));
            for (int i = 0; i < 100; i++) {
                num = (int) ((Math.random()) * 100 + 1);
                dou.writeInt(num);
            }
            if (dou != null) {
                dou.close();
            }
            din = new DataInputStream(new FileInputStream(srcpath));
            int sum = 0;
            for(int i=0;i<100;i++){
                sum += din.readInt();
            }
            if (din != null) {
                din.close();
            }
            System.out.println(sum);
        } catch (IOException e) {
            System.out.println("异常发生");
        }
    }
}