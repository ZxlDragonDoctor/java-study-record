package ACW;

public class Stack_<Item>{
    //实现下压栈
    private Node first;
    private int N;
    private class Node{
        Item data;
        Node next;
    }
    public boolean isEmpity(){
        return first!=null;
    }
    public int length(){
        return N;
    }
    public void push(Item item){
        Node oldfirst = first;
        Node node = new Node();
        node.data = item;
        node.next = oldfirst;
        first = node;
        N++;
    }
    public void pop(){
        first = first.next;
        N--;
    }
    public Iterable iterator(){
        return new Iterable();
    }
    public class Iterable{
        public boolean hasNext(){
            return first!=null;
        }
        public Item next(){
            Item item = first.data;
            first=first.next;
            return item;
        }
        public void remove(){}
    }
    //便利
    public void print(){
        for(Node X = first;X!=null;X=X.next){
            System.out.println(X.data);
        }
    }
}
class Test{
    public static void main(String[] args) {
        String str_1 = "wukai";
        String str_2 = "zhuxiallog";
        String str_3 ="wangzeng";
        Stack_<String> stack = new Stack_<>();
        stack.push(str_1);
        stack.push(str_2);
        stack.push(str_3);
        stack.print();
//        stack.pop();
//        stack.pop();
//        stack.print();
        Stack_<String>.Iterable iterator = stack.iterator();
        while (iterator.hasNext()) {
            String next =  iterator.next();
            System.out.println(next);
        }

    }
}
