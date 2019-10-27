package HealthyHeaven;

import java.util.ArrayList;
import java.util.List;

public class Salad {
    private String name;
    private List<Vegetable> products;

    public Salad(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }
    public String getName(){
        return this.name ;
    }
    public int getTotalCalories(){
        int sum = 0;
        for (Vegetable product : products) {
            sum += product.getCalories();
        }
        return sum;
    }
    public int getProductCount(){
        return this.products.size();
    }
    public void add(Vegetable product){
        this.products.add(product);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("* Salad %s is %d calories and have %d products:%n",this.getName(),this.getTotalCalories(),this.getProductCount()));
        for (Vegetable product : products) {
            sb.append(product).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}