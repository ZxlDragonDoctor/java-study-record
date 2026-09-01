package zxl.darws;

public class Montion {
    public static void main(String[] args) {
        //山峰数组
        int[] arr = {3, 5, 3, 2, 0};
        int i = binsearch(arr);
        System.out.println(i);
    }

    public static int binsearch(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid == 0) {
                if (arr[mid] > arr[mid + 1]) {
                    return mid;
                } else return mid + 1;
            }
            if (mid == arr.length - 1) {
                if (arr[mid] > arr[mid - 1]) {
                    return mid;
                } else return mid - 1;
            }
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            } else if (arr[mid] < arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                high = mid - 1;
            }
        }
        return -1;
    }
}

//    public static int heapsearch(int arr[]) {
//        //二叉排序树构建
//        TreeNode top = new TreeNode();
//        top.data = arr[0];//头节点
//        TreeNode node = top;//指针
//        for (int i = 1; i < arr.length; i++) {
//            TreeNode Node = new TreeNode();
//            Node.data = arr[i];
////            if(node.left == null&&Node.data<node.data){
////                node.left = Node;
////            }else if(node.right==null&&Node.data>node.data){
////                node.right = Node;
////            }
//            while(node.left!=null){
//                node = node.left;
//            }
//
//        }
//
//    }
//}
//class TreeNode {
//    int data;
//    TreeNode left = null;//左节点
//    TreeNode right = null;//左节点
//
//    public int getData() {
//        return data;
//    }
//
//    public void setData(int data) {
//        this.data = data;
//    }
//
//    public TreeNode getLeft() {
//        return left;
//    }
//
//    public void setLeft(TreeNode left) {
//        this.left = left;
//    }
//
//    public TreeNode getRight() {
//        return right;
//    }
//
//    public void setRight(TreeNode right) {
//        this.right = right;
//    }
//}

