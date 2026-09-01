//package Test_2;
//
//import java.util.Scanner;
//@SuppressWarnings({"all"})
////颜色平衡树
//public class Tree {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        TopNode[] topNodes = new TopNode[n];
//        int np,data;
//        for(int i=0;i<n;i++){
//            np = scanner.nextInt();
//            data = scanner.nextInt();
//            if(np==0) {
//                topNodes[i] = new TopNode(i + 1);
//                topNodes[i].setData(data);
//            }else {
//                topNodes[i] = new TopNode(i + 1);
//                topNodes[i].setData(data);
//                TopNode nextNode = Tree.searchTop(np,topNodes);
//                nextNode.addNode(new Node(i+1,data));
//            }
//        }
//
//
//
//    }
//    //查找
//    public static TopNode searchTop(int np,TopNode[] topNodes){
//        for(int i=0;i<topNodes.length;i++){
//            TopNode topNode = topNodes[i];
//            if(topNode.getNum()==np){
//                return topNode;
//            }
//        }
//    }
//    //核心  判断是否是颜色平衡树
//    public static int judge(TopNode[] topNodes){
//
//    }
//
//}
//class TopNode{
//    int num;//编号
//    int data;//颜色
//    Node next;//指针
//    int count;
//    //添加节点
//    public void addNode(Node node){
//        Node p = next;
//        if(this.next==null){
//            next = node;
//        }else{
//           if(p.next!=null) {
//               p = p.next;
//           }
//           p.next = node;
//        }
//    }
//
//    public TopNode(int num) {
//        this.num = num;
//        this.next = null;
//    }
//
//    public int getNum() {
//        return num;
//    }
//
//    public void setNum(int num) {
//        this.num = num;
//    }
//
//    public int getData() {
//        return data;
//    }
//
//    public void setData(int data) {
//        this.data = data;
//    }
//
//    public Node getNext() {
//        return next;
//    }
//
//    public void setNext(Node next) {
//        this.next = next;
//    }
//}
//class Node{
//    int num;
//    int data;
//    Node next;
//    public Node(int num,int data){
//        this.num = num;
//        this.data = data;
//        this.next = null;
//    }
//}
