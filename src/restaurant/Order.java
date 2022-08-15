package restaurant;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Meat> orderList = new ArrayList<>();

    public List<Meat> getOrderList() {
        return orderList;
    }

    public void addToOrder(Meat meat) {
        orderList.add(meat);
    }

    public void setOrderList(List<Meat> orderList) {
        this.orderList = orderList;
    }
}
