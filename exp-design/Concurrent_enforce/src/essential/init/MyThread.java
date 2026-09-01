package essential.init;

class MyThread extends Thread {

    @Override
    public void run() {
        // do something
        getLock();
    }

    /**
     * 阻塞当前线程
     */
    public synchronized void getLock() {
        try {
            System.out.println(1);
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 唤醒当前线程
     */
    public synchronized void releaseLock() {
        System.out.println(2);
        notify();
    }
}
