package chaoxintest.practice_9;

import java.util.Scanner;

public class Judge {
    public static void main(String[] args) {
//        编写一个程序，判断一个字符串是否是回文串（palindrome），
//        如果一个字符串从前往后，以及从后往前是一个样的，那么它就是一个回文。
//        例如， level, noon，dad。
        System.out.println("请输入一段字符");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String str_= "";//指向常量池，但没放值-----与str =null直接不指向池 区分
        for (int i =str.length()-1;i>=0;i--){
            str_ += str.charAt(i);
        }
        if(str.compareTo(str_)==0){
            System.out.println("该字符是回文");
        }
        else{
            System.out.println("该字符不是回文");
        }
    }
}
