package chaoxintest.practice_16;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class IO_1 {
    public static final String srcpath = "D:\\test.txt";
    public static void main(String[] args) {

            FileInputStream fin = null;
            try {
            fin = new FileInputStream(srcpath);
            int value;
            while ((value = fin.read())!=-1){
                System.out.print((char)value);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
                try {
                    if(fin!=null){
                        fin.close();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

    }
}
