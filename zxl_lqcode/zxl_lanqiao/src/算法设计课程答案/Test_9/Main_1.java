package 算法设计课程答案.Test_9;

public class Main_1 {
    public static void main(String[] args) {
        int sons; //儿子数
        int totalPrice = 0;
        for(int i=200;i>=1;i--){
            //枚举儿子数
            int[] p = new int[i+1]; //1~n时的财产
            p[i] = 0; //最后剩余财产一定是0
            boolean loop = true;
            for(int j=i;j>=1;j--){
                if(p[j]*10%9!=0){
                    loop = false;
                    break;
                }
                p[j-1] = p[j] * 10 / 9 + j;
                System.out.println(p[j-1]);
            }
            if(loop){
                System.out.println("儿子数="+i);
                System.out.println("财产数="+p[0]);
                break;
            }
        }
    }
}
