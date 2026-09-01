package 算法实践;

// 并查集
public class JionAndFind {

    int[] pre = new int[Integer.MAX_VALUE]; //x指向其前区节点
    public void initPre(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            pre[nums[i]] = nums[i];
            rankX[nums[i]] = 1;
            rankY[nums[i]] = 1;
        }
    }
    //查找方式一
    public int find(int x){
        if(pre[x]!=x){
            return find(x);
        }
        return x;
    }
    // 查找方式二 路径压缩，儿子直接直向根节点
    //该算法存在一个缺陷：只有当查找了某个节点的代表元（教主）后，才能对该查找路径上的各节点进行路径压缩。
    // 换言之，第一次执行查找操作的时候是实现没有压缩效果的，只有在之后才有效。
    public int find2(int x){
        if(pre[x] == x ) return x;
        return pre[x] = find2(pre[x]);
    }

    // 合并方式一
   public void join(int x,int y){
        int fx = find(x);
        int fy = find(y);
        if(fx!=fy){
            pre[fy] = fx;
        }
   }
   // 合并方式二: 加权合并
    int[] rankX = new int[Integer.MAX_VALUE]; //记录节点树的高度，一开始所有节点高度为1
    int[] rankY = new int[Integer.MAX_VALUE];
    public void join2(int x,int y){
        int fx = find(x);
        int fy = find(y);
        if(fx==fy) return;
        if(rankX[fx]<rankY[fy]){
            pre[fx] = fy;  //高度低的指向高度高的

        }else{ // fx>=fy
            if(rankX[fx] == rankY[fy]) rankX[fx]++;
            pre[fy] = fx;

        }
    }
}
