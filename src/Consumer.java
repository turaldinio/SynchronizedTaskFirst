import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Consumer implements Runnable {
    private final ReentrantLock reentrantLock;
    private final Condition condition;
    private final List<Car> list;

    public Consumer(ReentrantLock reentrantLock, Condition condition, List<Car> list) {
        this.reentrantLock = reentrantLock;
        this.condition = condition;
        this.list = list;
    }

    @Override
    public void run() {
        reentrantLock.lock();
        while (list.isEmpty()) {
            try {
                Thread.sleep(150);
                System.out.printf("Машин нет, покупатель %s ожидает\n", Thread.currentThread().getName());

                condition.await();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Покупатель %s забирает машину\n", Thread.currentThread().getName());
        list.remove(0);

        reentrantLock.unlock();
    }
}
