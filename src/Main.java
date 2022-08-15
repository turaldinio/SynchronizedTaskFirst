import restaurant.Client;
import restaurant.Cook;
import restaurant.Waiter;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        for (int a = 0; a < 1; a++) {
            Client client = new Client();
            Waiter waiter = new Waiter(client);
            new Thread(waiter, "Официант " + a).start();
            Thread.sleep(400);
            new Thread(client, "Клиент " + a).start();
        }


    }
}