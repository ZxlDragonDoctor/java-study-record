package 腾讯云智;

import jdk.nashorn.internal.objects.NativeNumber;

import java.util.Scanner;
import java.util.Stack;

public class CompressString {
    // 解字符压缩  HG[3|B[2|CA]]F
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String srcStr = sc.nextLine();
        System.out.println(copyDeCompress(srcStr));
    }
    public static String decompress(String s) {
        Stack<Integer> repeatStack = new Stack<>();
        Stack<StringBuilder> prefixStack = new Stack<>();
        StringBuilder current = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch == '[') {
                // 遇到 '['，接下来解析重复次数
                i++; // 跳过 '['
                int num = 0;
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                // 此时 s.charAt(i) 应该是 '|'
                if (i < s.length() && s.charAt(i) == '|') {
                    i++; // 跳过 '|'
                }
                // 将当前已构建的字符串压栈（作为前缀）
                prefixStack.push(current);
                repeatStack.push(num);
                // 开始构建内层内容
                current = new StringBuilder();
            }
            else if (ch == ']') {
                // 遇到 ']'，将内层内容重复并拼接到前缀
                int repeat = repeatStack.pop();
                StringBuilder inner = current;
                current = prefixStack.pop();
                for (int j = 0; j < repeat; j++) {
                    current.append(inner);
                }
                i++;
            }
            else {
                // 普通字符直接追加
                current.append(ch);
                i++;
            }
        }
        return current.toString();
    }
    public  static  String copyDeCompress(String s){
        Stack<StringBuilder> preStr = new Stack<>();
        Stack<Integer> numsCount = new Stack<>();
        int nums = 0;
        StringBuilder cur = new StringBuilder();
        int i = 0;
        while(i<s.length()){
            char ch = s.charAt(i);
            if(ch == '['){
                i++;
                while(i<s.length() && Character.isDigit(s.charAt(i))){
                    nums = nums * 10 + (s.charAt(i)-'0');
                    i++;
                }
                if(i<s.length() && s.charAt(i)=='|'){
                    i++;
                }
                // 记录
                preStr.push(cur); // 【 前的前缀字符
                numsCount.push(nums); // [ 后的数字
                //  开启下一层
                nums = 0;
                cur = new StringBuilder();
            }else if(ch==']'){
                StringBuilder tmp = cur; //当前层需要解压的字符
                cur = preStr.pop(); //获取前缀字符
                Integer repeatCount = numsCount.pop();
                for(int j=0;j<repeatCount;j++){
                     cur.append(tmp);
                }
                i++;
            }else {
                cur.append(s.charAt(i));
                i++;
            }
        }
        return   cur.toString();
    }
}
