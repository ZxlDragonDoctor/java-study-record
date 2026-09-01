package Sort;

public class heapSort_5 {
    // 堆排序 nlogn
    // 建立大根堆
    // 根节点序号应该是1
    public void sift(int[] tree,int l,int r){
        int i = l,j = 2*i;
        int tmp = tree[i];
        while(j<r){
            if(j+1<=r && tree[j+1]>tree[j]){
                j++;
            }
            if(tree[i]<tree[j]){
                 tree[i] = tree[j];
                 i = j;
                 j = 2*i;
            }else{
                break;
            }
        }
        tree[i] = tmp;
    }
    public void buildHeap(int[] tree,int n){
        for(int i=n/2;i>0;i--){
            sift(tree,i,n);
        }
    }

    public void heapSort(int[] tree,int n){
        buildHeap(tree,n);
        for(int i=n;i>=2;i--){
            int tmp = tree[i];
            tree[i] = tree[1];
            tree[1] = tmp;
            sift(tree,1,i-1);
        }
    }

}
