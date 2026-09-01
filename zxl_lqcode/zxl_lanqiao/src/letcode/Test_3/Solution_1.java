package letcode.Test_3;

import java.util.Scanner;
//正则表达式
@SuppressWarnings({"all"})
public class Solution_1 {
    public static boolean isMatch(String s,String p){
        char[] ptr = p.toCharArray();
        char[] str = s.toCharArray();
        int q = 0;//指向str的指针
        int last = -1,behind = -1;//指向ptr的指针
        char mid ;
        int count = -1;
        int index = 0;
        for(int i=0;i<ptr.length;i++){
            if(ptr[i]=='*'){
                count = 1;
            }
            //主要代码区
            if(ptr[i]=='*'){
                //处理"a***b"类似情况
                index = i;
                while (ptr[index]=='*'){
                    index--;
                }
                mid = ptr[index];//取出*前的字符
                last = behind;  behind = index;
                int cal = behind-last;
                //如果mid前还有字符，则与str进行比较
                if(cal>2||(cal==2&&last==-1)){
                    if(last==-1){
                        for(int j=last+1;j<behind;j++){
                            if(ptr[j]!=str[q++]){
                                return false;
                            }
                        }
                    }else {
                        for (int j = last + 2; j < behind; j++) {
                            if (ptr[j] != str[q++]) {
                                return false;
                            }
                        }
                    }
//                    q++;//指向下一个字符
                    if(q>=str.length){
                        if(ptr[ptr.length-1]!='*'&&ptr[ptr.length-1]!='.'){
                            return false;
                        }
                        return true;
                    }
                    //处理.*情况
                    if(mid=='.'&&(index+1)==ptr.length-1){
                        return true;
                    }
                    if(mid==str[q]||mid=='.') {
                        if(mid=='.'){//处理末尾.*c类似情况
                            if(str[str.length-1]!=ptr[ptr.length-1]){
                                if(ptr[ptr.length-1]=='*'){
                                    return false;
                                }
                                if(ptr[ptr.length-1]=='.'){
                                    return true;
                                }
                                //既不是*也不要是.
                                return false;
                            }
                            return true;
                        }
                        //mid==str[q]
                        for (int j = q; j < str.length; j++) {
                            if(j==str.length-1){
                                return true;
                            }
                            if (str[j] != str[j + 1]) {
                                q = j + 1;
                                break;
                            }

                        }
                    }
                }else {//*号间间隔一个字符
                    //处理.*情况
                    if(mid=='.'&&(index+1)==ptr.length-1){
                        return true;
                    }
                    if(mid==str[q]||mid=='.') {
                        if(mid=='.'){//处理末尾.*c类似情况
                            if(str[str.length-1]!=ptr[ptr.length-1]){
                                if(ptr[ptr.length-1]=='*'){
                                    return false;
                                }
                                if(ptr[ptr.length-1]=='.'){
                                    return true;
                                }
                                //既不是*也不要是.
                                return false;
                            }
                            return true;
                        }
                        //mid==str[q]
                        for (int j = q; j < str.length; j++) {
                            if(j==str.length-1){
                                return true;
                            }
                            if (str[j] != str[j + 1]) {
                                q = j + 1;
                                break;
                            }

                        }
                    }
                }
            }
        }
        if(count==-1){
            if(str.length!=ptr.length){
                return false;
            }else {
                for (int i = 0; i < str.length; i++) {
                    if (str[i] != ptr[i]&&ptr[i]!='.') {
                        return false;
                    }
                }
            }
            return true;
        }
        //对末尾进行处理（简化版）
        if((index+1)!=ptr.length-1){
            int len1 = str.length-q;//要包含q所指向的值
            int len2 = p.length()-1-(index+1);
            if(len1!=len2){//长度不同直接返回false
                return false;
            }
            int in = str.length-1;
            for(int j=ptr.length-1;j>=index+2;j--){
                while (ptr[j]!=str[in--]&&ptr[j]!='.'){
                    return false;
                }
            }
            return true;
        }else if(q==str.length-1){
            return true;
        }
        return false;
    }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String s = scanner.next();
            String p = scanner.next();
            System.out.println(isMatch(s,p));
        }

}
