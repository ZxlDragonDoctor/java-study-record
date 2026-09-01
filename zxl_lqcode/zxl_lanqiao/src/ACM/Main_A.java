package ACM;

import java.util.Scanner;

public class Main_A {
    public static void main(String[] args) {
        int k =0 ;
        float n = 0;
        float PA=0,PB=0;
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<100010;i++) {
            k = sc.nextInt();
            n = k + 1;
            float mid1=0,mid2=0;
            while (n!=0){
                PA += (1-mid2)*(1/n);
                mid1 = (1-mid2)*(1/n);
                n--;
                if(n==0){
                    break;}
                PB += (1-mid1)*(1/n);
                mid2 = (1-mid1)*(1/n);
                n--;
            }
            if(PA>PB){
                System.out.println(1);
            }else if(PA<PB){
                System.out.println(2);
            }else {
                System.out.println(0);
            }
            PA = 0;
            PB = 0;
            n = 0;
            mid1 = 0;
            mid2 = 0;
        }
    }
}
