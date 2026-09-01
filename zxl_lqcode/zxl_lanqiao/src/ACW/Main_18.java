package ACW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_18 {
    //ac.日期问题 前缀和的思想
    static int[] months = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    public static int is_leapyear(int year){
        if((year%4==0&&year%100!=0)||year%400==0){
            return 1;
        }else {
            return 0;
        }
    }
    public static int sum_day(int year,int month,int day){
        int res = 0;
        for(int i=1;i<year;i++){//前y-1年
            res += 365 + is_leapyear(i);
        }
        for(int i=1;i<month;i++){//前m-1月
            res += sum_month(i,year);
        }
        res += day;
        return res;
    }
    public static int sum_month(int month,int year){
        if(month==2){
            return 28 + is_leapyear(year);
        }else {
            return months[month];
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf  = new BufferedReader(new InputStreamReader(System.in));
        String str1 = "";
        String str2 = "";
        while ((str1=bf.readLine())!=null&&(str2=bf.readLine())!=null){
            char[] a = str1.toCharArray();
            String str_year = new String(a,0,4);
            int year1 = Integer.parseInt(str_year);
            String str_month = new String(a,4,2);
            int month1 = Integer.parseInt(str_month);
            String str_day = new String(a,6,2);
            int day1 = Integer.parseInt(str_day);
            char[] b = str2.toCharArray();
            String str_year1 = new String(b,0,4);
            int year2 = Integer.parseInt(str_year1);
            String str_month1 = new String(b,4,2);
            int month2 = Integer.parseInt(str_month1);
            String str_day1 = new String(b,6,2);
            int day2 = Integer.parseInt(str_day1);
            int ans = Math.abs(sum_day(year1,month1,day1)-sum_day(year2,month2,day2))+1;
            System.out.println(ans);
        }

    }
}
