package zxl.lanqiao;
//java2022B×é
import java.util.Scanner;

public class Testdraw {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char[] chars = new char[26];
        int[] count = new int[26];
        for(int i=0;i< 26;i++){
            char a = (char)('A' + i);
            chars[i] = a;
        }
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < chars.length; j++) {
                if(str.charAt(i)==chars[j]){
                    count[j]++;
                }
            }
        }
        int MAX = count[0];
        for(int i=0;i<count.length;i++){
            if(count[i]>MAX) {
                MAX = count[i];
            }
        }
        for(int i=0;i<count.length;i++){
            if(MAX==count[i]) {
                System.out.print(chars[i]);
            }
        }

    }
}
