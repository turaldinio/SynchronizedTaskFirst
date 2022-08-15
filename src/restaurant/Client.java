package restaurant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Client implements Runnable {
    private final List<Meat> selectedDishes;

    public Client() {
        this.selectedDishes = new ArrayList<>();
    }


    @Override
    public void run() {
        synchronized (selectedDishes) {
            System.out.println("Клиент: блокирую монитор");
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Клиент: выбираю блюда");

            selectedDishes.add(Meat.Beef);
            selectedDishes.add(Meat.Water);

            System.out.println("Клиент: Отдаю официанту");
            selectedDishes.notify();
        }
    }

    public List<Meat> getSelectedDishes() {
        return selectedDishes;
    }
}
