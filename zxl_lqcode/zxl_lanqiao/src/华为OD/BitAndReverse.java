package 华为OD;


import java.math.BigInteger;

//大整数位序反转
// 二进制 + 大整数处理
// BigInteger: 1. 构造函数：BigInteger(String val)
// 2. 转换为二进制字符串：toString(2)
// 3. 二进制字符串转 BigInteger：new BigInteger(String val, int radix)
public class BitAndReverse {
    public static void main(String[] args) {
        String test = new String("2313231232321313213");
        BigInteger bigInteger = new BigInteger(test);
        String string = bigInteger.toString(2);
        String ans = new StringBuilder(string).reverse().toString();
        BigInteger result = new BigInteger(ans,2);
        String string1 = result.toString();
        System.out.println(string1);
    }
}
