package Sort;

@SuppressWarnings({"all"})
public class Sort_1 {
    //快排
    public void sort(int nums[],int left,int right){
        //主要是一种分治的思想
        //挖坑法
        int mid = nums[left]; //作为基准元素
        int i = left;
        int j = right;
        if(left<right) {
            while (i < j) {
                while (i < j && nums[j] >= mid) {//不要省略=号
                    j--;
                }
                nums[i] = nums[j];
                while (i < j && nums[i] <= mid) {
                    i++;
                }
                nums[j] = nums[i];
            }
            nums[i] = mid;
            sort(nums,left,i-1);
            sort(nums,i+1,right);
        }

    }

    public static void main(String[] args) {
        int nums[] = {1,31,23,123,1,2,3,7};
        Sort_1 sort1 = new Sort_1();
        sort1.sort(nums,0,nums.length-1);
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
    }
}
