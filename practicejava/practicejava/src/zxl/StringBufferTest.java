package zxl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//public class StringBufferTest {
////    小数点前每三位间隔一个","号
//    public static void main(String[] args) {
//        String price  = "122323123434.43423";
//        StringBuffer sb = new StringBuffer(price);
////       int i = sb.lastIndexOf(".");
////        sb = sb.insert(i - 3,",");
//        for(int i = sb.lastIndexOf(".") - 3;i > 0;i -= 3 ){
//            sb = sb.insert(i ,",");
//        }
//        System.out.println(sb);
//
//    }
//
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BufferedReader_  {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String text = bufferedReader.readLine();
            System.out.println(text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
