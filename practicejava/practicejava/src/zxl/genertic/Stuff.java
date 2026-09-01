package zxl.genertic;

import java.util.ArrayList;
import java.util.Comparator;

@SuppressWarnings({"all"})
public class Stuff {
    private String name;
    private Mydata birthday;

    public Stuff(String name, Mydata birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public Mydata getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "Stuff{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Stuff("bom",new Mydata(2003,12,22)));
        arrayList.add(new Stuff("bom",new Mydata(2003,11,22)));
        arrayList.add(new Stuff("bom",new Mydata(2003,12,21)));
        arrayList.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Stuff stu1 = (Stuff) o1;
                Stuff stu2 = (Stuff) o2;
                 int i;
                 if((i=(stu1.getName().compareTo(stu2.getName())))!=0){
                     return i;
                 }
                 return stu1.getBirthday().compareTo(stu2.getBirthday());
//                 int y = stu1.getBirthday().getYear() -  stu2.getBirthday().getYear();
//                 int m = stu1.getBirthday().getMonth() - stu2.getBirthday().getMonth();
//                 int d = stu1.getBirthday().getDay() - stu2.getBirthday().getDay();
//                 if(y!=0){
//                     return y;
//                 }
//                 if(m!=0){
//                     return m;
//                 }
//                 return d;

            }
        });
        for (Object o : arrayList) {
            Stuff stu = (Stuff) o;
            System.out.println(stu);
        }


    }
}
class Mydata implements Comparable<Mydata> {
    private int year;
    private int month;
    private int day;
    @Override
    public int compareTo(Mydata o) {
        int y = year -  o.getYear();
        int m = month - o.getMonth();
        int d = day- o.getDay();
        if(y!=0){
            return y;
        }
        if(m!=0){
            return m;
        }
        return d;
    }

    public Mydata(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "Mydata{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}
