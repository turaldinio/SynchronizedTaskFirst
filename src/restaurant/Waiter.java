package restaurant;


public class Waiter implements Runnable {
    private Client client;
    private Cook cook;

    public Waiter(Cook cook, Client client) {
        this.cook = cook;
        this.client = client;
    }

    @Override
    public void run() {
        String waiterName = Thread.currentThread().getName();

        System.out.println(waiterName + ": на работе");
        synchronized (client.getSelectedDishes()) {
            while (client.getSelectedDishes().isEmpty()) {
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