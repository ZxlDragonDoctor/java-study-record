package chaoxintest.practice_14;

public class ToString {
    public static void main(String[] args) {
       // 2. 给定一个字符串“aWdefEhiACpqrstBDwxyz”，要求输出字符串的大写字母和小写字母的个数。
        String str = "aWdefEhiACpqrstBDwxyz";
        char[] chstr = str.toCharArray();
        String Lstr = str.toLowerCase();//同理转成大写字母同理
        char[] chLstr = Lstr.toCharArray();
        int lowcount=0;
        for (int i = 0; i <Lstr.length(); i++) {
            if(chstr[i]==chLstr[i]){
                lowcount ++;
            }
        }
        System.out.println("小写字母个数" + lowcount);
        System.out.println("大写字母个数" + (str.length()-lowcount));

    }
}
