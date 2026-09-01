package ACW;

import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class Main_11{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        int[] s = new int[8];
        for(int i=0;i<8;i++){
            s[i] = scan.nextInt();
        }
        int x = Math.min(s[2],s[6])-Math.max(s[0],s[4]);
        int y = Math.min(s[3],s[7])-Math.max(s[1],s[5]);
        int area = (s[2]-s[0])*(s[3]-s[1]) + (s[6]-s[4])*(s[7]-s[5]);
        int ans = 0;
        if(x>0&&y>0){
            ans = x * y;
        }
        System.out.println(area-ans);
        scan.close();
    }
}
//二矩形重叠公式
//(min(x2,x4)-max(x1,x3))*(min(y2,y4)-max(y1,y3))