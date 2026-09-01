package chaoxintest.practice_9;

public class Test {
//    构造 String 类型的二维数组 s，二维数组存的元素是字符串（行值+”,”+列值，如，s[0][0] =“0,0”）。
//
//    数组第一维长度是 3，第二维长度分别是 2，3，4；最后，将数组中的每个元素打印出来。
public static void main(String[] args) {
    String[][] strings = new String[3][];
//    String s ;
//    for(int i =0;i<2;i++){
////        strings[0][i] = "0,i";
//        s = i + "";
//        strings[0][i] = "0," + s;//空指针异常是因为定义时不知道第二维长度
//    }
//    for (int i = 0; i < 3; i++) {
//        s = i + "";
//        strings[1][i]  = "1," + i;
//    }
//    for (int i = 0; i < 4; i++) {
//        s = i + "";
//        strings[2][i] = "2" + i;
//    }
    for(int i = 0;i<strings.length;i++){
        strings[i] = new String[i+2];
    }//初始化二位数组不同长度
    for (int i = 0; i < strings.length; i++) {
        for (int j = 0; j < strings[i].length; j++) {
            strings[i][j] = i + "," + j;//赋值并输出
            System.out.print(strings[i][j] + "\t");
        }
        System.out.println();
    }
}

}
