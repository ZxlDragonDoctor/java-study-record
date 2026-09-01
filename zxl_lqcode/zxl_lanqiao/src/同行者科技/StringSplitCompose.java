package 同行者科技;



import java.util.ArrayList;


public class StringSplitCompose {
    //1) 字符串拆分成数组，如”ab&&2”通过”&&”做分隔符，分割得到字符串数组[“ab”,”2”]
    public static String[] question1(String arr) {
        ArrayList<String> res = new ArrayList<>();
        int i = 0;
        int j = -1;
        while (i < arr.length()) {
            if (arr.charAt(i) == '&' && arr.charAt(i + 1) == '&') {
                StringBuilder temp = new StringBuilder();
                for (int k = j + 1; k < i; k++) {
                    temp.append(arr.charAt(k));
                }
                res.add(temp.toString());
                j = i + 1;
                i = i + 2;
            }
            i++;
        }
        res.add(arr.substring(j + 1));
        return res.toArray(new String[0]);
    }

    //2) 实现字符串组合，如[“ab”,”2”]通过”&&”分隔符，组合成字符串”ab&&2”
    public static String question2(String arr[]) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < arr.length - 1; i++) {
            res.append(arr[i] + "&&");
        }
        res.append(arr[arr.length - 1]);
        return res.toString();
    }
}
