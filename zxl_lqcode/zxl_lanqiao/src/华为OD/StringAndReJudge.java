package 华为OD;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//字符串回文判
public class StringAndReJudge {
    public static void main(String[] args) {
        String str = "abca";
        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<str.length();i++){
            StringBuilder stringBuilder = new StringBuilder(str);
            stringBuilder.deleteCharAt(i);
            if(isPalindrome(stringBuilder)){
                ans.add(i);
            }
        }

        System.out.println(Arrays.toString(ans.toArray()));

    }

    // 判断是否是回文字串
    public static boolean isPalindrome(StringBuilder stringBuilder){
        int l = 0;
        int r = stringBuilder.length()-1;
        while(l<r){
            if(stringBuilder.charAt(l) != stringBuilder.charAt(r)){
                return  false;
            }
            l++;
            r--;
        }
        return  true;
    }
}
