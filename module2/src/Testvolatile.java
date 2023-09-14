import javax.management.MXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Testvolatile {
    public static int inc = 0;
    Lock lock = new ReentrantLock();
    public  void increase() {
        lock.lock();
        inc++;
        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        Testvolatile volatileDemo = new Testvolatile();
        for (int i = 0; i < 5; i++) {
            threadPool.execute(() -> {
                for (int j = 0; j <1000 ; j++) {
                    volatileDemo.increase();
                }
            });
        }

        Thread.sleep(1500);
        System.out.println(inc);
        threadPool.shutdown();
    }
}
