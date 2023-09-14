public class TestDeadLock {
    private static Object resource1 = new Object();
    private static Object resource2 = new Object();

    public static void main(String[] args) throws InterruptedException {
       Thread t1 =  new Thread(()->{
         synchronized (resource1){
             System.out.println(Thread.currentThread()+"线程1得到了resource1的锁");
             try {
                 Thread.sleep(1000);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             System.out.println(Thread.currentThread()+"线程1等待获取resource2的锁");
             synchronized (resource2){
                 System.out.println(Thread.currentThread()+"线程1得到了resource2的锁");
             }
         }
        });
        Thread t2 = new Thread(()->{
            synchronized (resource2){
                System.out.println(Thread.currentThread()+"线程2得到了resource2的锁");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread()+"线程2等待获取resource1的锁");
                synchronized (resource1){
                    System.out.println(Thread.currentThread()+"线程2得到了resource1的锁");
                }
            }
        });
        t1.start();
        t2.start();
        Thread.sleep(100);
        System.out.println(t1.getState());
        System.out.println(t2.getState());
    }
}
