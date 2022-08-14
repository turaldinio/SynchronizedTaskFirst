package restaurant;

public enum Meat {
    Water(70), Coffee(115), Steak(2700), Beef(1470),
    Spaghetti(920), Potato(985), Fish(2360);
    private int cookingTime;

    Meat(int cookingTime) {
        this.cookingTime = cookingTime;
    }
}
