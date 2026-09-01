package ACW;

public class Main_26 {
    //并查集 模板 与优化后的模板
     static int N = 100010;
     static int[] x = new int[N];
     static int[] rank = new int[N];//存每个节点的高度
      public static int find(int i){
         if(x[i]==i){
             return i;
         }
         return find(x[i]);
     }
     public static int updatefind(int i){
         if(x[i]==i){
             return i;
         }
         return x[i] = updatefind(x[i]);
     }
     public static void union(int a,int b){
         int h = find(a);
         int t = find(b);
         if(h==t){
             return;
         }
         x[t] = h;
     }
     public static void updtaeunion(int a,int b){//
         int h = find(a);
         int t = find(b);
         if(h==t){
             return;
         }
         if(rank[h]>rank[t]){
             x[t] = h;
         }else if(rank[h]<rank[t]){
             x[h] = t;
         }else {
             x[t] = h;
             rank[t]++;//更新高度
         }

     }
    public static void init(){
        for(int i=0;i<N;i++){
            x[i]=i;
            rank[i] = 0;
        }

    }
    public static void main(String[] args) {

    }
}
