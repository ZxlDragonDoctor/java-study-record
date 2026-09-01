package chaoxintest.practice_14;

public class Judege {
    public static boolean judge(String str){
        char[] chstr = str.toCharArray();
        int low = 0;
        int high = str.length()-1;
        while(low<=high){
            if(chstr[low]==chstr[high]){
                low++;
                high--;
            }else{
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
//        3. 写一个方法判断一个字符串是否对称。
        String str = "aba";
        System.out.println(judge(str));
    }
}
