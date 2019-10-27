package HealthyHeaven;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private List<Salad> data;

    public Restaurant(String name) {
        this.name = name;
        this.data = new ArrayList<>();
    }

    public void add(Salad salad) {
        this.data.add(salad);
    }

    public boolean buy(String name) {
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getName().equals(name)) {
                this.data.remove(i);
                return true;
            }
        }
        return false;
    }

    public Salad getHealthiestSalad() {
        int minCalories = Integer.MAX_VALUE;
        Salad saladBest = null;
        for (Salad salad : data) {
            if (salad.getTotalCalories() < minCalories) {
                minCalories = salad.getTotalCalories();
                saladBest = salad;
            }
        }
        return saladBest;
    }

    public String generateMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s have %d salads:%n",this.name,this.data.size()));
        for (Salad salad : data) {
            sb.append(salad).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
