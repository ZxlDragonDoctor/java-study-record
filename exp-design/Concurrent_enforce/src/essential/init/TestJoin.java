package essential.init;

public class TestJoin {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            System.out.println("线程1开始执行");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程1执行完毕");
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("线程2开始执行");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程2执行完毕");
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join(); // 等待线程1执行完毕
            thread2.join(); // 等待线程2执行完毕
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("所有线程执行完毕");
    }

}
