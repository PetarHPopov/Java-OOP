package shoppingSpree;

public class Product {
    private String name;
    private double cost;

    Product(String name, double cost) {
        this.setName(name);
        this.setCost(cost);
    }

    private void setName(String name) {
        name = name.replaceAll("[\\s+]","");
        if (name.length() == 0){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setCost(double cost) {
        if (cost < 1){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
