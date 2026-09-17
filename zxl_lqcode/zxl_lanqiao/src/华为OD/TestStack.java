package 华为OD;

import java.util.*;

public class TestStack {
    public static void main(String[] args) {
//        int[] arr = {4,3,1,2};
//        int res = stackPut(4,arr);
//        System.out.println(res);
        int[] arr = {1,-2,4,5};
        int res = multiDp(arr.length,arr);
        System.out.println(res);

    }

    //仓储货物有序出库  ，双栈，加比较目标值
    public static  int stackPut(int n,int[] nums){
        LinkedList<Integer> a = new LinkedList<>();
        LinkedList<Integer> b = new LinkedList<>();

        for(int i = 0;i<nums.length;i++){
            a.add(nums[i]);
        }

        Arrays.sort(nums);

        Set<Integer> inTemp = new HashSet<>();
        int move = 0;

        for(int x:nums){
            while (true){
                if(!a.isEmpty() && a.peekLast().equals(x)){
                    a.pollLast();
                    break;
                }
                if(!b.isEmpty() && b.peekLast().equals(x)){
                    b.pollLast();
                    break;
                }
                //目标值在临时区
                if(inTemp.contains(x)){
                    int t = b.pollLast();
                    a.add(t);
                    inTemp.remove(t);
                    move++;
                }else{ // 在主仓区
                    int t = a.pollLast();
                    b.add(t);
                    inTemp.add(t);
                    move++;
                }

            }
        }

        return move;


    }

    //少儿爬山闯关积分游戏 dp多状态
    public static  int multiDp(int n,int[] nums){

        if(n==1) return nums[0];

        int[][] dp = new int[n+1][2];

        for(int i=0;i<nums.length;i++){
            dp[i][0] = dp[i][1] = Integer.MIN_VALUE;
        }

        dp[1][0] = nums[0];
        dp[2][0] = dp[1][0] + nums[1];

        for(int i=3;i<=n;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]) + nums[i-1];
            dp[i][1] = dp[i-2][0] + nums[i-1];
        }

        return Math.max(dp[n][0],dp[n][1]);
    }

    // 嵌入式传感器寄存器数据解析
    public static int parse(int packet) {
        // 1. 状态检查
        int status = packet & 1;
        if (status == 0) return -1;

        int regId    = (packet >> 1) & 0x3;        // bit1~2
        int dataType = (packet >> 3) & 1;          // bit3
        int factor   = (packet >> 4) & 0xFF;       // bit4~11
        int length   = (packet >> 12) & 0xF;       // bit12~15
        int dataRaw  = (packet >>> 16) & 0x7FFF;   // bit16~30
        int parity   = (packet >>> 31) & 1;        // bit31

        // 有效数据
        int validData;
        if (dataType == 1) {
            validData = (length == 0) ? 0 : (dataRaw & ((1 << length) - 1));
        } else {
            validData = dataRaw;
        }

        // 2. 奇偶校验：有效数据1的个数 + 校验位 必须为偶数
        if ((Integer.bitCount(validData) + parity) % 2 != 0) {
            return -2;
        }

        // 3. 变长但长度为0
        if (dataType == 1 && length == 0) {
            return -3;
        }

        // 4~7 按寄存器ID运算
        switch (regId) {
            case 0:  return validData & factor;          // 与
            case 1:  return validData | factor;          // 或
            case 2:  return validData ^ factor;          // 异或
            case 3:  return ~(validData ^ factor);       // 同或
            default: return 0;
        }
    }

}
