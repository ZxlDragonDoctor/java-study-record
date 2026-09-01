package ACW;

public class Main_14 {
    //树状数组
    static int N = 500010;
    static int[] tree = new int[N];//tree树//树状数组是从下标为1到n的原数组建立起来的;
    static int n;//数组长度;
    public static int lowBit(int x){//返回以x为下标的tree[x]的长度;
        return x&(-x);
    }
    public static void add(int x,int d){//单点修改
        while (x<=n){
            tree[x] += d;
            x += lowBit(x);
        }
    }
    public static int sum(int x){//区间查询
        int res = 0;
        while (x>0){
            res += tree[x];
            x -= lowBit(x);
        }
        return res;
    }
    public static int liSan(int[] a){//求逆序对数
        int res=0,ans=0;
        for(int i=0;i<a.length;i++){
            add(a[i],1);
            res = sum(a[i]);//将值映射成下标
            System.out.println(res+":res");
            ans += i+1-res;//该值就是逆序对数
            System.out.println(ans+"\\");
        }
        return ans;
    }
    public static void main(String[] args) {
        int nums[] = {1, 31, 23, 123, 1, 2, 3, 7};
         n  = 123;
        System.out.println("逆序对数:"+liSan(nums));
    }
}
