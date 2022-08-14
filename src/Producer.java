import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Producer implements Runnable {
    private final ReentrantLock reentrantLock;
    private final Condition condition;
    private final List<Car> list;

    public Producer(ReentrantLock reentrantLock, Condition condition, List<Car> list) {
        this.reentrantLock = reentrantLock;
        this.condition = condition;
        this.list = list;
    }


    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                return;
            }
            reentrantLock.lock();

            Car car = new Car("BMV");
            list.add(car);
            System.out.println("Производитель добавил машину " + car.getName());

            condition.signal();
            reentrantLock.unlock();
        }
    }

}
