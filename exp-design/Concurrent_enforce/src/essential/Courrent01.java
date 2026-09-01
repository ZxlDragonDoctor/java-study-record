package essential;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.logging.Logger;


public class Courrent01 {
    private final static Logger log = Logger.getLogger("main");
    public static void main(String[] args) throws Exception {
        for(int i=0;i<100;i++){
            new A().start();
        }
        for(int i=0;i<100;i++){
           new Thread(new B()).start();
        }
        for(int i=0;i<100;i++){
            FutureTask<Integer> futureTask = new FutureTask<>(new C());
            futureTask.run();
//            new Thread(futureTask).start();
        }

       new Thread(new Runnable() {
           @Override
           public void run() {
               System.out.println("555");
           }
       }).start();

    }
}
class A extends Thread{
    @Override
    public void run() {
        System.out.println("111");
    }
}
class B implements Runnable{
    @Override
    public void run() {
        System.out.println("222");
    }
}
class C implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        System.out.println("333");
        return  1;
    }
}
