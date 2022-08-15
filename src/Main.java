import restaurant.Client;
import restaurant.Cook;
import restaurant.Waiter;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Cook cook = new Cook();

        List<Waiter> waiterList = new ArrayList<>();
        List<Client> clientList = new ArrayList<>();

        for (int a = 0; a < 5; a++) {
            clientList.add(new Client());
            waiterList.add(new Waiter(cook, clientList.get(a)));
        }

        for (int a = 0; a < waiterList.size(); a++) {
            new Thread(waiterList.get(a), "Официант " + a).start();
        }

        Thread.sleep(1000);

        for (int a = 0; a < clientList.size(); a++) {
            Thread.sleep((long) (Math.random() * 750));
            new Thread(clientList.get(a), "Клиент " + a).start();
        }

    }
}