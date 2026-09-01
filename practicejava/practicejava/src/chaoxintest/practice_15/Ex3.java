package chaoxintest.practice_15;

import java.io.*;
@SuppressWarnings({"all"})
public class Ex3 {
    public static void main(String[] args) {
//        3、编写程序实现复制文件的功能（CopyFile），
//        将文件d:\\A.txt的内容复制输出到新文件d:\\B.txt中。（要求处理相关异常）。
        String srcpath = "D:\\A.txt";
        String destpath = "D:\\B.txt";
        BufferedWriter bw = null;
        BufferedReader br = null;
        try {
            FileInputStream fin = new FileInputStream(srcpath);
            FileOutputStream fou = new FileOutputStream(destpath);
            br = new BufferedReader(new InputStreamReader(fin,"UTF-8"));
            bw = new BufferedWriter(new OutputStreamWriter(fou,"UTF-8"));
            String str = "";
            while((str = br.readLine())!=null){
                bw.write(str);
            }
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
}
