package 乐信圣文;


// 基于Int数组实现动态循环链表扩容
public class dynamicQueue {

    int[] queue = new int [10];

    int head = 0,tail = 0;
    public void Enqueue(int n){
        //是否需要扩容
        if((tail+1)%queue.length == head){
             int oldLength = queue.length;
             int newLength = queue.length * 2;
             int[] newQueue = new int[newLength];

             int index = 0;
             for(int i = head ;i != tail ; i=(i+1)%oldLength){
                 newQueue[index++] = queue[i];
             }
             queue = newQueue;
             head = 0;
             tail = index;
        }
        //添加数据
        queue[tail] = n;
        tail = (tail+1)%queue.length;
    }
    public void Dequeue(){
        if(head==tail){
            System.out.println("队为空");
            return;
        }
        head = (head+1)% queue.length;

    }
}
