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
        System.out.println("Официант: стартует");
        synchronized (client.getSelectedDishes()) {
            System.out.println("Официант: блокирует монитор");
            while (client.getSelectedDishes().isEmpty()) {
                System.out.println("Официант: лист пуст, отдаю монитор");
                try {
                    client.getSelectedDishes().wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Официант: список не пуст, отдам повару");

        }

    }
}