import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TestFuture {
    public static void main(String[] args) {
        TestFuture inst = new TestFuture();
        List<FutureTask<Integer>> taskList =new ArrayList<>();
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            FutureTask<Integer> ft = new FutureTask<>(inst.new ComputeTask(i, "" + i));
            taskList.add(ft);
            //线程池新建了futureTask就是任务，线程池提交任务
            exec.submit(ft);
        }
        System.out.println("所有计算任务提交完毕, 主线程接着干其他事情！");
        int totalResult = 0;
        for (FutureTask<Integer> ft : taskList) {
            try {
                totalResult = totalResult + ft.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        exec.shutdown();
        System.out.println("多任务计算后的总结果是:" + totalResult);

    }
    private class ComputeTask implements Callable<Integer> {
        private Integer result = 0;
        private String taskName = "";

        public ComputeTask(Integer iniResult, String taskName) {
            result = iniResult;
            this.taskName = taskName;
            System.out.println("生成子线程计算任务: " + taskName);
        }
        public String getTaskName() {
            return this.taskName;
        }
        public Integer getResult() {
            return this.result;
        }
        @Override
        public Integer call() throws Exception {
            System.out.println("子线程计算任务: " + taskName + "开始计算!");
            for (int i = 0; i < 100; i++) {
                result =+ i;
            }
            Thread.sleep(5000);
            System.out.println("子线程计算任务: " + taskName + "计算完成! 结果为: " + result);
            return result;
        }
    }
}
