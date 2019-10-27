package pizzaCalories;

class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    private void setFlourType(String flourType) {
        try {
            // throw IllegalArgumentException
            DoughModifiers type = DoughModifiers.valueOf(flourType);
            this.flourType = type.name();

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setBakingTechnique(String bakingTechnique) {
        try {
            // throw IllegalArgumentException
            DoughModifiers technique = DoughModifiers.valueOf(bakingTechnique);
            this.bakingTechnique = technique.name();

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    double calculateCalories() {

        double flourCalories = DoughModifiers.valueOf(this.flourType).getValue();
        double bakingCalories = DoughModifiers.valueOf(this.bakingTechnique).getValue();

        return 2 * this.weight * flourCalories * bakingCalories;
    }

    String getFlourType() { return this.flourType; }
    String getBakingTechnique() { return this.bakingTechnique; }
    double getWeight() { return this.weight; }
}


