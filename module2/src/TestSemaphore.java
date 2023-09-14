import java.util.Random;
import java.util.concurrent.Semaphore;

//停车场的管理的例子,acquire获取不到就会被阻塞
public class TestSemaphore {
    static final Semaphore semaphore = new Semaphore(10);
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                    System.out.println("===="+Thread.currentThread().getName()+"来到停车场");
                    if(semaphore.availablePermits()==0){
                        System.out.println("车位不足，请耐心等待");
                    }
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"成功进入停车场");
                    Thread.sleep(new Random().nextInt(10000));
                    System.out.println(Thread.currentThread().getName()+"驶出停车场");
                    semaphore.release();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            },i+"号车");
            thread.start();
        }
    }
}
