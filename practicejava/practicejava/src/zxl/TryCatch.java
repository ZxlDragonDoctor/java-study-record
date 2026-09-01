package zxl;

import java.util.Scanner;

public class TryCatch {

//    public static int method(){
//         Scanner scanner = new Scanner(System.in);
//         int n = 0;
//         try{
//            System.out.println("请输入一个整数");
//            n = scanner.nextInt();
//            return 0;
//        }catch (Exception e){
//            System.out.println("该数不是整数，请重新输入");
//            method();
//        }
//         return 0;
//    }
//
//    public static void main(String[] args) {
//        method();
//    }
    public static void  method(){
        String str = "";
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请输入一个整数");
            try {
                str = scanner.next();
                int n  = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.println("该数不是整数");
            }
        }
    }

    public static void main(String[] args) {
        method();
    }
}
