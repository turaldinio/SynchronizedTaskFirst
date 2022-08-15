package restaurant;

import java.util.List;

public class Waiter implements Runnable {
    private Client client;
    private Cook cook;

    public Waiter(Client client, Cook cook) {
        this.client = client;
        this.cook = cook;
    }

    @Override
    public void run() {
        String waiterName = Thread.currentThread().getName();

        System.out.println(waiterName + ": на работе");
        synchronized (client.getSelectedDishes()) {
            //System.out.println(waiterName + " :блокирует монитор");
            while (client.getSelectedDishes().isEmpty()) {
                //    System.out.println(waiterName + ": лист пуст, отдаю монитор");
                try {
                    client.getSelectedDishes().wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(waiterName + ": передаю заказ повару");
            Order clientOrder = cook.startPreparingTheOrder(client.getSelectedDishes());
            System.out.println(waiterName + ": отдаю заказ клиенту");
            client.setOrder(clientOrder);
        }

    }
}