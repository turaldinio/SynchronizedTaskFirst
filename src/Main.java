import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        List<Car> list = new ArrayList<>();

        Thread producer = new Thread(new Producer(reentrantLock, condition, list));
        producer.start();


        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<Future<?>> runnables = new ArrayList<>();

        Thread t = new Thread(new Consumer(reentrantLock, condition, list), "as");
        for (int a = 0; a < 10; a++) {
            runnables.add(executorService.submit(t));
        }
        runnables.forEach(x -> {
            try {
                x.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

        executorService.shutdown();
        producer.interrupt();


    }
}