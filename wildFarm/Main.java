package wildFarm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //{AnimalType} {AnimalName} {AnimalWeight} {AnimalLivingRegion} [{CatBreed}
        List<Animal> animals = new ArrayList<>();

        String input = reader.readLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            String animalType = tokens[0];
            String animalName = tokens[1];
            double animalWeight = Double.parseDouble(tokens[2]);
            String animalLivingRegion = tokens[3];

            Animal animal = null;
            if (animalType.equals("Cat")) {
                String catBreed = tokens[4];
                animal = new Cat( animalName,animalType, animalWeight, animalLivingRegion, catBreed);
            } else if (animalType.equals("Tiger")) {
                animal = new Tiger(animalName,animalType,  animalWeight, animalLivingRegion);
            } else if (animalType.equals("Zebra")) {
                animal = new Zebra( animalName,animalType, animalWeight, animalLivingRegion);
            } else if (animalType.equals("Mouse")) {
                animal = new Mouse( animalName,animalType, animalWeight, animalLivingRegion);
            }


            String[] foods = reader.readLine().split("\\s+");
            String foodType = foods[0];
            int quantity = Integer.parseInt(foods[1]);

            Food food = null;

            if (foodType.equals("Meat")) {
                food = new Meat(quantity);
            } else if (foodType.equals("Vegetable")){
                food = new Vegetable(quantity);
            }

            if (animal != null && food != null) {
                animal.makeSound();
                animal.eat(food);
                animals.add(animal);
            }
            input = reader.readLine();
        }
        animals.forEach(System.out::println);
    }
}
