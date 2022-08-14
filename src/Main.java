import restaurant.Client;
import restaurant.Waiter;

public class Main {
    public static void main(String[] args) {
        Client client = new Client();

        Waiter waiter = new Waiter();
        waiter.serveTheCustomer(client);

    }
}