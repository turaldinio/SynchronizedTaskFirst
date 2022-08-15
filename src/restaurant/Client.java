package restaurant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Client implements Runnable {
    private final Order order;
    private final List<Meat> selectedDishes;

    public Client() {
        this.order = new Order();
        this.selectedDishes = new ArrayList<>();
    }


    @Override
    public void run() {
        synchronized (order.getOrderList()) {
            System.out.println("Клиент: блокирую монитор");
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Клиент: выбираю блюда");

            order.addToOrder(Meat.Beef);
            order.addToOrder(Meat.Water);

            System.out.println("Клиент: Отдаю официанту");
            order.getOrderList().notify();
        }
    }

    public Order getOrder() {
        return order;
    }
}
