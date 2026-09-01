package zxl.filetest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileTest_2 {
    public static void main(String[] args) {
        String str = "D:\\ok_3.txt";
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(str));
            bw.write("123");
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
