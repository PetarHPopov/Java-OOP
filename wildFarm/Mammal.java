package wildFarm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {
    private String livingRegion;

    public Mammal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.setLivingRegion(livingRegion);
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    private void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }

    @Override
    public void eat(Food food) {
        if (!food.getClass().getSimpleName().equals("Vegetable")) {
            System.out.println(String.format("%ss are not eating that type of food!", this.getClass().getSimpleName()));
            return;
        }
        super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        return String.format("%s[%s, %s, %s, %d]",
                super.getAnimalType(),
                super.getAnimalName(),
                decimalFormat.format(super.getAnimalWeight()),
                this.getLivingRegion(),
                super.getFoodEaten()
        );
    }
}
