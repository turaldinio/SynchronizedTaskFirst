package restaurant;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Client {

    public List<Meat> chooseADish() {
        return new Random().
                ints(3, 0, (int) (Math.random() * Meat.values().length)).
                mapToObj(x -> Meat.values()[x]).collect(Collectors.toList());
    }

    public void takeFood(List<Meat> orders) {
        for (Meat a : orders) {
            try {
                Thread.sleep(a.getCookingTime() * 300L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
