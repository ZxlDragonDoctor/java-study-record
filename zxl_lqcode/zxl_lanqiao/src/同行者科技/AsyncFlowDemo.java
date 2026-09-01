package 同行者科技;

import java.util.concurrent.*;
import java.util.function.Consumer;

public class AsyncFlowDemo {

    private static final Executor POOL = ForkJoinPool.commonPool();

    private static CompletableFuture<Void> read(String name) {
        return CompletableFuture.runAsync(() -> {
            sleep(50 + (int) (Math.random() * 100));
            System.out.println(name + " 读操作 完成");
        }, POOL);
    }

    private static CompletableFuture<Void> write(String name) {
        return CompletableFuture.runAsync(() -> {
            sleep(50 + (int) (Math.random() * 100));
            System.out.println(name + " 写操作 完成");
        }, POOL);
    }

    private static void sleep(int ms) {
        try { Thread.sleep(ms); } catch (InterruptedException ignore) {}
    }

    public static void main(String[] args) throws Exception {
        CompletableFuture<Void> c = read("任务C");
        CompletableFuture<Void> h = read("任务H");

        CompletableFuture<Void> a = c.thenAcceptBoth(h, (__, ___) -> {
            System.out.println("C、H 全部结束 → 启动任务A");
        }).thenCompose(__ -> write("任务A"));

        CompletableFuture<Void> x = read("任务X");

        CompletableFuture<Void> w = read("任务W");
        CompletableFuture<Void> y = write("任务Y");

        CompletableFuture<Void> either = w.acceptEither(y, new Consumer<Void>() {
            public void accept(Void v) {
                System.out.println("W、Y 任一结束 → 流程继续");
            }
        });

        CompletableFuture<Void> p = read("任务P");

        CompletableFuture.allOf(a, x, either, p).join();
        System.out.println("=== 整个请求流程 结束 ===");
    }
}