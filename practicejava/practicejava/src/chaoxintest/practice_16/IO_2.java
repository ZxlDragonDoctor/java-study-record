package chaoxintest.practice_16;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class IO_2 {
    public static final String srcpath = "D:\\test_1.txt";

    public static void main(String[] args) {
        BufferedReader br  =null;
        FileReader fr = null;
        try {
            fr = new FileReader(srcpath);
            br = new BufferedReader(fr);
            String str = "";
            while ((str = br.readLine())!=null){
                System.out.println(str);
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
}
