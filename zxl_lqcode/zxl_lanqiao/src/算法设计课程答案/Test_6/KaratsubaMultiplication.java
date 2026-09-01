package 算法设计课程答案.Test_6;
import java.math.BigInteger;

public class KaratsubaMultiplication {

    public static BigInteger karatsuba(BigInteger x, BigInteger y) {
        // 基本情况：当数字足够小时，直接进行普通乘法
        int THRESHOLD = 10;
        if (x.bitLength() <= THRESHOLD || y.bitLength() <= THRESHOLD) {
            return x.multiply(y);
        }

        // 计算拆分长度
        int n = Math.max(x.bitLength(), y.bitLength());
        int half = n / 2;

        // 计算 10^half
        BigInteger tenPowerHalf = BigInteger.TEN.pow(half);

        // 拆分 x 和 y
        BigInteger a = x.divide(tenPowerHalf);
        BigInteger b = x.mod(tenPowerHalf);
        BigInteger c = y.divide(tenPowerHalf);
        BigInteger d = y.mod(tenPowerHalf);

        // 递归计算三个部分
        BigInteger ac = karatsuba(a, c);
        BigInteger bd = karatsuba(b, d);
        BigInteger adPlusBc = karatsuba(a.add(b), c.add(d)).subtract(ac).subtract(bd);

        // 组合结果
        return ac.multiply(tenPowerHalf.pow(2)).add(adPlusBc.multiply(tenPowerHalf)).add(bd);
    }

    public static void main(String[] args) {
        BigInteger x = new BigInteger("12345678");
        BigInteger y = new BigInteger("87654321");
        System.out.println("Result: " + karatsuba(x, y));
    }
}
