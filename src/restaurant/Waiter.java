package restaurant;

public class Waiter  {
    private Cook cook;
    private Client client;

    public void serveTheCustomer(Client client) {
        Order order = new Order();
        order.addToOrder(client.chooseADish());
        System.out.println("официант " + Thread.currentThread().getName() + " принял заказ");
        cook.startCooking(this, order);

    }

    public void takeTheOrder(Order order) {
        client.takeFood(order.getOrder());
    }

}
