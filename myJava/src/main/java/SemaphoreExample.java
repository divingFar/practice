import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    public static void main(String[] args) {
        final int clientCount = 3;
        final int totalRequestCount = 10;
        Semaphore semaphore = new Semaphore(clientCount);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < totalRequestCount; i++) {
            executorService.execute(()->{
                try {
                    //获取资源
                    semaphore.acquire();
                    String name = Thread.currentThread().getName();
                    System.out.println(name+"获取到资源，开始工作");
                    Thread.sleep(1000);
                    System.out.println(name + "使用完毕，释放资源");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
        String a = "2";
        for(;;);
        //a.hashCode();
    }
}