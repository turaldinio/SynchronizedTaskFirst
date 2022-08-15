package restaurant;

import java.util.ArrayList;
import java.util.List;

public class Client implements Runnable {
    private final List<Meat> selectedDishes;
    protected Order order;

    public Client() {
        this.selectedDishes = new ArrayList<>();
    }


    @Override
    public void run() {
        String clientName = Thread.currentThread().getName();
        synchronized (selectedDishes) {
            System.out.println(clientName + " : в ресторане");
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //           System.out.println(clientName + " : выбираю блюда");
            int meatCount = (int) (Math.random() * Meat.values().length);
            for (int a = 0; a < meatCount; a++) {
                selectedDishes.add(Meat.values()[(int) (Math.random() * Meat.values().length)]);

            }
            selectedDishes.add(Meat.Beef);
            selectedDishes.add(Meat.Water);

            // System.out.println(clientName + " Отдаю официанту");
            selectedDishes.notify();
        }
        while (this.order == null) {
            // System.out.println(clientName + " :жду заказ");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //    System.out.println(clientName + " :получил заказ");
        eatEverything(order);
        System.out.println(clientName + " :Спасибо, до свидания");
    }


    public void eatEverything(Order order) {
        //  System.out.println("Клиент ест");
        for (Meat m : order.getOrderList()) {
            try {
                Thread.sleep(m.getCookingTime() * (int) (Math.random() * 5));
                //        System.out.println("Клиент съедает " + m.name());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<Meat> getSelectedDishes() {
        return selectedDishes;
    }
}
