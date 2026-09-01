package chaoxintest.practice_15;

import java.io.*;
import java.util.Scanner;
@SuppressWarnings({"all"})
public class Ex4 {
    public static void main(String[] args) {
//        4、编写程序。请在控制台上输入任意两个数，计算它们的和，并同时输出到控制台和文件file.txt中。
        Scanner scanner = new Scanner(System.in);
        int n1;
        int n2;
        n1 = scanner.nextInt();
        n2 = scanner.nextInt();
        int sum = n1 + n2;
        System.out.println(sum);
        String str = "D:\\file.txt";
        BufferedWriter bw = null;
        try {
           bw = new BufferedWriter(new FileWriter(str));
            bw.write(sum+"");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(bw!=null){
                    bw.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
