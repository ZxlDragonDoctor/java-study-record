package apijava;

import java.util.*;


public class Exp01 {
    //L1-003 个位数统计
    // hash集合遍历，字符排序
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s =  sc.next();
        char[] ch = s.toCharArray();
        Map<String,Integer> map = new HashMap();
        for(int i=0;i<ch.length;i++){
            map.merge(ch[i]+"",1,Integer::sum);
        }
        String str = "";
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            str = str+entry.getKey();
        }
        char[] chs = str.toCharArray();
        Arrays.sort(ch);
        for(int i=0;i<chs.length;i++){
            System.out.println(chs[i]+":"+map.get(chs[i]+""));
        }
    }
}
