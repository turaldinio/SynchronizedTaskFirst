import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProducerConsumer<Car> producerConsumer = new ProducerConsumer<>();
        Car car = new Car("BMV");

        Thread producer = new Thread(() -> {
            while (!Thread.interrupted()) {
                try {
                    producerConsumer.produce(car);
                    Thread.sleep(350);
                } catch (InterruptedException e) {
                    return;
                }
            }
        });
        producer.start();

        for (int a = 0; a < 5; a++) {
            Thread consumer = new Thread(() -> {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    return;
                }
                producerConsumer.consume();
            }, "Покупатель " + a);
            consumer.start();

        }

        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            return;
        }
        producer.interrupt();

    }
}

class ProducerConsumer<T> {
    private final List<T> buffer = new ArrayList<>();

    public void produce(T value) {
        synchronized (buffer) {
            buffer.add(value);
            System.out.println("Производитель добавил машину " + value);
            buffer.notify();
        }
    }

    public void consume() {
        synchronized (buffer) {
            String threadName = Thread.currentThread().getName();
            while (buffer.isEmpty()) {
                try {
                    System.out.println(threadName + " ожидает поставки машины");
                    buffer.wait();
                } catch (InterruptedException e) {
                    return;
                }
            }
            System.out.println(threadName + " покупает машину");
            buffer.remove(0);
        }
    }
}

class Car {
    private String carName;

    public Car(String carName) {
        this.carName = carName;
    }

    @Override
    public String toString() {
        return carName;
    }
}
