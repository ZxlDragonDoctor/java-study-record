package Dp;


// 字符匹配算法 和dp的思想是一样的
// kmp 时间复杂度 O(m+n) , BF 时间复杂度为O(m*n)
public class KMP {
    public static int[] resultNext(String s){
        int[] next = new int[s.length()];
        next[0] = 0;
        int i=1;
        int prefix = 0; //公共前后缀长度
        while (i< next.length){
            if(s.charAt(prefix)==s.charAt(i)){
                prefix++;
                next[i] = prefix;
                i++;
            }else if(prefix==0){
                next[i] = 0;
                i++;
            }else {
                prefix = next[prefix-1];
            }
        }
        return next;
    }
    //优化kmp
    public static int[] resultNextValue(String s, int[] next){
        for(int i=0;i<next.length;i++){
            if(s.charAt(i)==s.charAt(next[i])){
                next[i]=next[next[i]];   //将next数组优化为nextValue数组
            }
        }
        return  next;
    }
    public static int kmp(String s, String t) {
        int[] next = resultNext(t);
        int i = 0, j = 0;
        while (j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else if(j>0){
                j = next[j-1];
            }else { //第一个匹配字符就不匹配
                i++;
            }
            if (j == t.length()) {
                return i - j ; //返回字串首字符下标
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "ABBACCBCCCCC";
        String t = "ACC";
        System.out.println(kmp(s,t));
    }
}
