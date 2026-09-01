package 美团;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
// 美团春招第六次技术笔试第二题
public class Main_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<T;i++){
            int len = in.nextInt();
            for(int j=0;j<len;j++){
                 int num = in.nextInt();
                 map.put(num,map.getOrDefault(num,0)+1);
            }
            ArrayList<Integer> list = new ArrayList<>(map.keySet());
            Collections.sort(list);
            long ans = 0;
            for(int x:list){
                if(map.get(x)>=3) ans++;
            }
            for(int x:list){
                if(map.get(x)>=2){
                    int pos = lowerBound(list.toArray(new Integer[0]), 2 * x);
                    ans += pos;
                    // 判断下标为0~pos-1的数是否存在x
                    // 因为list有序，且y是小于2*x的最大数，所以如果存在x，则x一定在0~pos-1中
                    ans--;
                }
            }
            System.out.println(ans);
             map.clear();
        }
    }

    //二分查找小于目标值的最大值下标
    public static int lowerBound(Integer[] nums,Integer target){
        int l = 0,r = nums.length;  // 如果所有元素都小于目标值，返回nums.length
        while(l<r){
            int mid = (l + r) >>> 1;
            if(nums[mid]<target) {
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return l;
    }
    public static boolean isValiad(int a,int c){
        return a + a > c;  //a+a==c也不行
    }
}