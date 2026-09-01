package chaoxintest.practice_13;

public class Date {
//    3.定义一个Date类，包含三个int型成员变量year，month，day，
//    定义以这三个成员变量赋值为参数的构造方法。定义一个长度为30的Date数组days[]，
//    以2016年10月的30天为值初始化数组，
//    最后顺序输出数组中的每个元素，如“day[1] = 2016年10月1日   days[2]=……”。
   private int year;
   private int month;
   private int day;

        public Date(int year, int month, int day) {
                this.year = year;
                this.month = month;
                this.day = day;
        }

        @Override
        public String toString() {
                return "day[" + day +"]" + "= 2016年10月" + day + "日";
        }

        public static void main(String[] args) {
                Date[] days = new Date[30];
                for(int i=0;i<30;i++){
                        days[i] = new Date(2016,10,i+1);
                }
                for (int i = 0; i < days.length; i++) {
                        System.out.println(days[i]);
                }
        }
}
