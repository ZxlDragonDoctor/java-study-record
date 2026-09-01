package ACW;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main_19 {
    //ac.区间合并 模板题
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Parse> parses = new ArrayList<>();
        int l =0,r=0 ;
        for(int i=0;i<n;i++){
            l = sc.nextInt(); r = sc.nextInt();
            parses.add(new Parse(l,r));
        }
        //按照l端点进行排序
        Collections.sort(parses);//升序
        Parse mid = parses.get(0);
        int res1= mid.second- mid.first;
        int res2 = 0;
        for(int i=1;i<n;i++){
            Parse x = parses.get(i);
            if(x.first<= mid.second){
                int first = mid.first;
                int second = Math.max(mid.second,x.second);
                res1 = Math.max(second-first,res1);
                mid = new Parse(first,second);
            }else {
                res2 = Math.max(x.first-mid.second,res2);
                mid = x;
            }
        }
        res1 = Math.max(mid.second- mid.first,res1);//最后一个没比较
        System.out.println(res1+" "+res2);
    }
}
class Parse implements Comparable<Parse>{
    int first;
    int second;
    public Parse(int l,int r){
        this.first = l;
        this.second = r;
    }

    @Override
    public int compareTo(Parse o) {
        return this.first - o.first;
    }

}
