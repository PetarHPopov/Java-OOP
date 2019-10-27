package wildFarm;

public abstract class Felime extends Mammal {
    public Felime(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }
    @Override
    public void eat(Food food){
        if (!food.getClass().getSimpleName().equals("Meat")){
            System.out.println(String.format("%ss are not eating that type of food!",this.getClass().getSimpleName()));
            return;
        }
        super.setFoodEaten(super.getFoodEaten() + food.getQuantity());
    }
}
