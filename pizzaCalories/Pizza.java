package pizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private int toppingsCount;

    private void setName(String name) {
        String testName = name.replaceAll("[\\s]", "");

        if (testName.length() == 0 || testName.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = testName;
    }

    void setDough(Dough dough) {
        this.dough = dough;
    }

    private void setToppings(int count) {
        if (count < 0 || count > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppingsCount = count;
    }

    Pizza(String name, int toppingsCount) {
        this.setName(name);
        this.setToppings(toppingsCount);
        this.dough = null;
        this.toppings = new ArrayList<>();
    }

    void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    String getName() { return this.name; }
    Dough getDough() { return this.dough; }
    List<Topping> getToppings() { return this.toppings; }
    int getToppingsCount() { return this.toppingsCount; }

    private double getOverallCalories() {
        double calories = 0;
        calories += this.dough.calculateCalories();

        for (Topping toping : this.getToppings()) {
            calories += toping.calculateCalories();
        }
        return calories;
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f", this.name, this.getOverallCalories());
    }
}
