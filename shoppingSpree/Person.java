package shoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }


    private void setName(String name) {
        name = name.replaceAll("[\\s+]","");
        if (name.length() == 0){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }
    void buyProduct(Product product){
            if (this.money >= product.getCost()){
                this.products.add(product);
                this.setMoney(this.money - product.getCost());
            }else {
                throw new IllegalArgumentException
                        (String.format("%s can't afford %s",
                                this.getName()
                                ,product.getName()
                        ));
            }
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.name).append(" - ");
        if (this.products.size() > 0) {
            stringBuilder.append(String.join(", ", this.products.stream().
                    map(Product::getName).
                    collect(Collectors.toUnmodifiableList())));
        } else {
            stringBuilder.append("Nothing bought");
        }
        return stringBuilder.toString();
    }

}
