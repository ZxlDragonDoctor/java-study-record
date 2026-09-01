package zxl.darws;

import java.io.*;
//ÎÄ±¾¿½±´
public class FileTest {
    public static void main(String[] args) {
      String srcpath = "D:\\ok.txt";
      String destpath = "D:\\ok_1.txt";
      FileInputStream src = null;
      FileOutputStream dest = null;
      byte[] bytes = new byte[1024];
      int len = 0;
        try {
            src = new FileInputStream(srcpath);
            dest = new FileOutputStream(destpath);
            while((len = src.read(bytes))!= -1){
                dest.write(bytes,0,len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(src!=null){
                    src.close();
                }
                if(dest!=null){
                    dest.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        }
    }
