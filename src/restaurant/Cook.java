package restaurant;

import java.util.List;

public class Cook {

    public void startCooking(Waiter waiter, Order order) {
        try {
            for (Meat meat : order.getOrder()) {
                Thread.sleep(meat.getCookingTime());
                System.out.println("Блюдо " + meat.name() + " готово");
            }

        } catch (InterruptedException e) {
            return;
        }
        System.out.println("все блюда приготовлены");
        giveItToTheWaiter(waiter, order);
    }

    public void giveItToTheWaiter(Waiter waiter, Order order) {
        waiter.takeTheOrder(order);
    }


}
