import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCountDown {
    private static final int threadCount = 6 ;
    public static void main(String[] args) throws InterruptedException{
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i ;
            threadPool.execute(()->{
                try {
                    Thread.sleep(1000);
                    System.out.println("threadNum:"+threadNum);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }
            });
            countDownLatch.await();
            threadPool.shutdown();
            System.out.println("finish");
        }
    }
}
