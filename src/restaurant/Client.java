package restaurant;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Client {
    private Order order;

    public List<Meat> chooseADish() {
        return new Random().
                ints(3, 0, (int) (Math.random() * Meat.values().length)).
                mapToObj(x -> Meat.values()[x]).collect(Collectors.toList());
    }


}
