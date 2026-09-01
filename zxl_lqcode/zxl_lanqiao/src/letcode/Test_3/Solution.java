package letcode.Test_3;

//import java.util.Scanner;

import java.util.Scanner;


class Solution {
    public static boolean isMatch(String s, String p) {
        int count = -1;
        char[] str = p.toCharArray();
        char mid ;
        //指针q,指向s下一个同字符
        int q = 0;
        for(int i=0;i<str.length;i++) {
             if(str[i]=='.'||str[i]=='*') {
                 count = 1;
             }
             //处理字符
             if(str[i]=='*') {
                 int index = i;
                while (str[index]=='*'){
                    index--;
                }
                 mid = str[index];
                //如果mid为'.'
                if(mid=='.'){
                    for(int j=0;j<s.length();j++){
                        if(j==s.length()-1){
                            return true;
                        }
                        if(s.charAt(j)!=str[j+1]){
                            q = j + 1;
                            break;
                        }
                    }
                }
                //
                if(s.charAt(q)!=mid){
                    continue;
                }else {
                    for(int j=q;j<s.length();j++){
                        if(s.charAt(j)!=mid){
                            q = j;
                            break;//q指向下一个不同字符
                        }else if(j==s.length()-1){
                            return true;
                        }
                    }
                }
             }
        }
        if(count==-1) {
            if(s.length()!=str.length){
                return false;
            }
             for(int i=0;i<s.length();i++) {
                 if(s.charAt(i)!=str[i]) {
                     return false;
                 }
                 return true;
           }
         }
        //判断字符符合
       return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String p = scanner.next();
        System.out.println(isMatch(s,p));
    }
}

