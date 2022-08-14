package restaurant;

public class Waiter {

    public void serveTheCustomer(Client client) {
        Order order = new Order();
        order.addToOrder(client.chooseADish());
        
    }

}
