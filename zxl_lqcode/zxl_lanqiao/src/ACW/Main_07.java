package ACW;

public class Main_07 {
//    public static boolean checked(int num){
//        String n1 = num +"";
//        char[] s = n1.toCharArray();
//        int sum1 = 0;
//        for(int i=0;i<s.length;i++){
//            int mid = s[i] -'0';
//            sum1 += mid;
//        }
//        if(num%sum1!=0){
//            return false;
//        }
//        String n2 = Integer.toBinaryString(num);
//        char[] b = n2.toCharArray();
//        int sum2 = 0;
//        for (int i = 0; i < b.length; i++) {
//            int mid = b[i] - '0';
//            sum2 += mid;
//        }
//        if(num%sum2!=0){
//            return false;
//        }
//        String n3 = Integer.toOctalString(num);
//        char[] Oc = n3.toCharArray();
//        int sum3 = 0;
//        for (int i = 0; i < Oc.length; i++) {
//            int mid = Oc[i] - '0';
//            sum3 += mid;
//        }
//        if(num%sum3!=0){
//            return false;
//        }
//        String n4 = Integer.toHexString(num);
//        char[] H = n3.toCharArray();
//        int sum4 = 0;
//        for (int i = 0; i < H.length; i++) {
//            int mid = H[i] - '0';
//            sum4 += mid;
//        }
//        if(num%sum4!=0){
//            return false;
//        }
//        return true;
//    }
//
//
//    public static void main(String[] args) {
//        int n = 0;
//        for (int i = 1; ; i++) {
//            if (checked(i)) {
//                n++;
//            }
//            if(n==2023){
//                System.out.println(i);
//                break;
//            }
//        }
//    }
        public static void main(String[] args){
            int count = 0;
            for(int i=1; ;i++){
                if(conve(i,2)&&conve(i,10)&&conve(i,8)&&conve(i,16)){
                    count++;
                }
                if(count==2023){
                    System.out.println(i);
                    break;
                }
            }
        }
        public static boolean conve(int num,int n){
            int ans = 0,res = num;
            while(res>0){
                ans += res % n;
                res = res / n;
            }
            return (num%ans==0)?true:false;
        }


}
