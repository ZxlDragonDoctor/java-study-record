package chaoxintest.practice_15;

import java.io.*;
import java.nio.Buffer;
@SuppressWarnings({"all"})
public class Ex1 {
    public static void main(String[] args) {
//        1、将一个文件数据(datain.txt)数据读入内存，把其中的小写字母转换成大写字母，
//        其它字符不变，并显示到控制台并写入到文件(dataout.txt)中。
//        例：datain.txt 数据为：abcdeADCC1234
//        dataout.txt数据为：ABCDEADCC1234
        String srcpath = "D:\\datain.txt ";
        String destpath = "D:\\dataout.txt";
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(srcpath));
            String str = br.readLine();
            String newstr =str.toUpperCase();
            System.out.println(newstr);
            bw = new BufferedWriter(new FileWriter(destpath));
            bw.write(newstr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (br != null){
                    br.close();
                }
                if (bw != null) {
                    bw.close();
                }
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        }

    }
}
