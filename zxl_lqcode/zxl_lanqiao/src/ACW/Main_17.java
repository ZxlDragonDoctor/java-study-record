package ACW;

import java.io.*;
public class Main_17 {
    //ac.孤独的照片 贡献法
    static int N = 500010;
    static char[] c = new char[N];
    static int[] l = new int[N];
    static int[] r = new int[N];

    public static void main(String[] args) throws IOException {
        int n = 0;
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        n = Integer.parseInt(str);
        str = bf.readLine();
        c = str.toCharArray();
        int sh = 0, sg = 0;
        for (int i = 0; i < n; i++) {//便利左边
            if (c[i] == 'G') {
                l[i] = sh;
                sh = 0;
                sg++;
            } else {
                l[i] = sg;
                sg = 0;
                sh++;
            }
        }
        sh = 0;
        sg = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (c[i] == 'G') {
                r[i] = sh;
                sh = 0;
                sg++;
            } else {
                r[i] = sg;
                sg = 0;
                sh++;
            }
        }
        long res = 0;
        for(int i=0;i<n;i++){
            res += (long)l[i]*r[i] + Math.max(0,l[i]-1) + Math.max(0,r[i]-1);
        }
        System.out.println(res);
    }
    //在C或C++等编程语言中，表达式 `(long)l[i]*r[i]` 和 `(long)(l[i]*r[i])` 在算术操作上有细微的差别，这主要涉及到类型转换和运算符优先级。
    //
    //1. `(long)l[i]*r[i]`：
    //   - 这里，首先会对 `l[i]` 进行类型转换，将其强制转换为 `long` 类型，然后再与 `r[i]` 相乘。
    //   - 如果 `l[i]` 和 `r[i]` 原本不是 `long` 类型，那么这个转换可能会导致数据精度的损失（例如，如果它们原本是 `float` 或 `int`）。
    //   - 结果是两个 `long` 类型的值相乘，其结果也是一个 `long` 类型。
    //
    //2. `(long)(l[i]*r[i])`：
    //   - 这个表达式首先计算 `l[i]*r[i]`，即先进行乘法运算。
    //   - 然后，将乘法的结果整个转换为 `long` 类型。
    //   - 如果 `l[i]` 和 `r[i]` 原本的数据类型乘积超出了它们原始类型的范围，那么在转换之前可能已经发生了溢出（如果它们是 `int` 类型）或者精度损失（如果它们是 `float` 或 `double` 类型）。
    //   - 最后，将这个乘积的结果转换为 `long` 类型。
    //
    //主要的区别在于：
    //
    //- 在第一个表达式中，类型转换应用到了操作数 `l[i]` 上，而在第二个表达式中，类型转换是在乘法结果上应用的。
    //- 如果 `l[i]` 和 `r[i]` 的类型乘积在原始类型范围内不会溢出，但转换为 `long` 类型后可能导致溢出，那么第一个表达式可能不会立即报告错误，因为它是在乘法之前转换的，而第二个表达式可能会在转换时报告溢出错误（在编译时如果编译器有相关的警告）。
    //
    //在实践中，如果 `l[i]` 和 `r[i]` 的类型相同，且乘积可能会超出原始类型的范围，通常更倾向于使用第二个表达式，因为它可能更容易捕获潜在的溢出错误，并通过使用适当的数据类型避免数据损失。如果类型转换是出于其他目的（例如，为了确保在乘法之前操作数是 `long` 类型），则可能选择第一个表达式。
}
