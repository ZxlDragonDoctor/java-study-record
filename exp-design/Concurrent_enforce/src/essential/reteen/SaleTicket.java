package essential.reteen;

//资源类中内聚操作资源的方法，降低线程操作资源的耦合性
class Ticket{
 
    //  定义一个票数
    private int number = 20;
 
    //  定义一个卖票的方法: 出现了资源抢占；
    //  synchronized: 使用synchronized同步方法解决
    public synchronized void sale(){
 
        //  判断
        if (number<=0){
            System.out.println(Thread.currentThread().getName() + "票已售罄！");
            return;
        }
 
        try {
            System.out.println(Thread.currentThread().getName() + "开始售票，当前票数：" + number);
            Thread.sleep(200);
            System.out.println(Thread.currentThread().getName() + "买票售票，剩余票数：" + --number);
 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
 
 
public class SaleTicket {
 
    public static void main(String[] args) {
        //  创建资源类对象
        Ticket ticket = new Ticket();
 
        //  创建线程
        new Thread(()->{
            for (int i = 0; i < 21; i++) {
                ticket.sale();
            }
        },"A").start();
 
        new Thread(()->{
            for (int i = 0; i < 21; i++) {
                ticket.sale();
            }
        },"B").start();
 
        new Thread(()->{
            for (int i = 0; i < 21; i++) {
                ticket.sale();
            }
        },"C").start();
    }
}