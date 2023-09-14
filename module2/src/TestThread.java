import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class TestThread {
    static volatile boolean running = true;

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
               try{
                   System.out.println("t1 wait1000");
                     lock.wait(1000);
                     System.out.println("t1 wait ");
                     lock.wait();
                     System.out.println("t1 wait end");
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
            }
        });
        t1.start();
        Thread.sleep(500);
        synchronized (lock){
            System.out.println("t1 state"+t1.getState());
            lock.notify();
            Thread.sleep(1000);
            System.out.println("t1 state"+t1.getState());
        }
        Thread.sleep(3000);
        System.out.println("t1 state"+t1.getState());
        Thread.sleep(1000);
        synchronized (lock){
            lock.notify();
        }
        System.out.println("t1 state"+t1.getState());
        Thread.sleep(1000);
        System.out.println("t1 state"+t1.getState());

    }
    public static void testsynchronied(String[] args) throws InterruptedException {
        //线程管
        Thread t = new Thread(()->{
           synchronized (TestThread.class){
              System.out.println("t1 得到锁");
           }
        });
        synchronized (TestThread.class){
            t.start();
            Thread.sleep(1000);
            System.out.println("t1 等待锁"+t.getState());

        }
    }
}
