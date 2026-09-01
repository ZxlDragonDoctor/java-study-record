package chaoxintest.practice_15;

import java.io.*;
import java.util.Scanner;
@SuppressWarnings({"all"})
public class Ex2 {
    public static void main(String[] args) {
//        2、编写一个程序：要求通过命令行参数输入5个学生的成绩（0~100）的整数，
//        并将这5个数保存到文件“data.txt”中。
//        然后，在从文件“data.txt”中读出这5个成绩，计算平均值，
//        并在控制台窗口输出。要求：加入相应的异常处理。
        byte[] grade = new byte[5];
        Scanner scanner = new Scanner(System.in);
        System.out.println("依次输入五个学生成绩（0~100）");
        for(int i=0;i<5;i++){
            grade[i] = scanner.nextByte();
        }
        String destpath = "D:\\data.txt";
//        FileInputStream fin = null;
//        FileOutputStream fou = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
             br =new BufferedReader(new FileReader(destpath));
             bw = new BufferedWriter(new FileWriter(destpath));
            for(int i=0;i<grade.length;i++){
               bw.write(grade[i]+"");//每次读入一个字节
            }
            String newstr ="";
            int count = 0;
            while ((newstr=br.readLine())!=null){
                byte n = Byte.parseByte(newstr);
                grade[count++] = n;
            }
            double result = average(grade);
            System.out.println(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (bw != null) {
                    bw.close();
                }
            }catch (IOException e){
                System.out.println("异常发生");
            }
        }

    }
    public static double average(byte[] m){
        double sum = 0;
        for(int i=0;i<m.length;i++){
            sum += m[i];
        }
        return sum/m.length;
    }
}
