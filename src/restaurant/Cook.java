package restaurant;

import java.util.List;

public class Cook {

    public void startCooking(List<Meat> orders) {
        try {
            for (Meat meat : orders) {
                Thread.sleep((int) (Math.random() * 1000));
                System.out.println("Блюдо " + meat.name() + " готово");
            }

        } catch (InterruptedException e) {
            return;
        }
    }

    public void theDishIsReady() {

    }
}
