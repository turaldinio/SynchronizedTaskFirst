package restaurant;

import java.util.List;

public class Cook {
    public Cook() {
        System.out.println("Повар на работе");
    }

    public Order startPreparingTheOrder(List<Meat> orderList) {
        synchronized (Cook.class) {
            for (Meat m : orderList) {
                try {
                    Thread.sleep(m.getCookingTime());
                    System.out.println("Повар: блюдо " + m.name() + " приготовлено");
                } catch (InterruptedException e) {
                    System.out.println("Повар прерван на половине работы");
                }
            }
            Order order = new Order();
            order.setOrderList(orderList);
            System.out.println("Повар: все готово");
            return order;

        }
    }
}
