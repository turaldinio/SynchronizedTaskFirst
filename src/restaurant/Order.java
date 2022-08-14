package restaurant;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Meat> order;

    public Order() {
        order = new ArrayList<>();
    }

    public void addToOrder(Meat meat) {
        order.add(meat);
    }
}
