package restaurant;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Meat> order;

    public List<Meat> getOrder() {
        return order;
    }

    public void addToOrder(List<Meat> order) {
        this.order = order;
    }
}
