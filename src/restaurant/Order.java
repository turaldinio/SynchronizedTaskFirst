package restaurant;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Meat> order;


    public void addToOrder(List<Meat> order) {
        this.order = order;
    }
}
