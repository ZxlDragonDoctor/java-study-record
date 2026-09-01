package ACW;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_20_t {
    //ac。有序分数 暴力
    static int N = 170;
    static ArrayList<Pare> d = new ArrayList<>();
    public static int gcd(int a,int b){
        if(b==0) return 0;
        if(a%b==0){
            return b;
        }else {
            return gcd(b,a%b);//辗转相除法 递归写法
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                if(gcd(i,j)==1){
                    d.add(new Pare(j,i));
                }
            }
        }
//        d.sort(new Comparator<Pare>() {
//            @Override
//            public int compare(Pare o1, Pare o2) {
//                return o1.a * o2.b - o2.a * o1.b;
//            }
//        });
        d.sort((Pare o1,Pare o2)-> {
            return o1.a * o2.b - o2.a * o1.b;
        });//匿名内部类更简洁的写法
        //(Pare o1, Pare o2) -> { ... }：这是一个Lambda表达式，它定义了比较两个 Pare 对象的方式。
        // Lambda表达式的一般形式是 (parameters) -> { body }，其中 parameters 是方法的参数，body 是方法体。
        System.out.println(0+"/"+1);
        for(int i=0;i<d.size();i++){
            System.out.println(d.get(i).a+"/"+d.get(i).b);
        }
        System.out.println(1+"/"+1);
    }
}
class Pare{
    int a;
    int b;
    public Pare(int a,int b){
        this.a=a;
        this.b=b;
    }
}
