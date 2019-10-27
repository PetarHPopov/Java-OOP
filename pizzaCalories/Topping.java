package pizzaCalories;

class Topping {
    private String toppingType;
    private double weight;

    Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private String getToppingType() {
        return this.toppingType;
    }

    private void setToppingType(String toppingType) {
        try {
            ToppingsModifiers top = ToppingsModifiers.valueOf(toppingType);
            this.toppingType = top.name();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");
        }

    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(this.toppingType + " weight should be in the range [1..50].");
        }
        this.weight = weight;
    }

    double calculateCalories() {
        return 2 * this.weight * ToppingsModifiers.valueOf(this.getToppingType()).getValue();
    }
}
