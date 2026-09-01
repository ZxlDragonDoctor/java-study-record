package chaoxintest.practice_14;

public class StringUtilTest {
    public static void main(String[] args) {
        String str ="abcdefghijklmnopqrstuvwxyz";
        //字符翻转
        //方法一
        char[] str_ = str.toCharArray();
        char[] newstr = new char[str_.length];
        for(int i=0;i<str_.length;i++){
            newstr[str_.length-1-i] = str_[i];
        }
        System.out.println(newstr);
        //方法二
        StringBuffer stringBuffer = new StringBuffer(str);
        stringBuffer.reverse();
        System.out.println(stringBuffer);

    }
}
