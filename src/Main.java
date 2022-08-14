import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        List<Car> list = new ArrayList<>();

        Thread producer = new Thread(new Producer(reentrantLock, condition, list));
        producer.start();


        for (int a = 0; a < 10; a++) {
            new Thread(new Consumer(reentrantLock, condition, list), "Thread " + a).start();
        }

        Thread.sleep(3000);
        producer.interrupt();


    }
}