package pizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while (!"END".equals(line = reader.readLine())) {

            String[] data = line.split("\\s+");

            if (data[0].equals("Pizza")) {

                // pizza
                Pizza pizza = null;
                try {
                    pizza = new Pizza(data[1], Integer.parseInt(data[2]));

                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }

                // dough
                Dough dough = null;
                if (pizza != null) {

                    data = reader.readLine().split("\\s+");

                    if (data[0].equals("Dough")) {
                        try {
                            dough = new Dough(data[1], data[2], Integer.parseInt(data[3]));
                            pizza.setDough(dough);

                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }

                // toppings
                Topping topping = null;
                if (dough != null) {

                    for (int i = 0; i < pizza.getToppingsCount(); i++) {

                        line = reader.readLine();
                        if (line.equals("END")) { break; }

                        data = line.split("\\s+");

                        if (data[0].equals("Topping")) {

                            try {
                                topping = new Topping(data[1], Integer.parseInt(data[2]));
                                pizza.addTopping(topping);

                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                }

                // finish pizza
                if (pizza != null && dough != null && topping != null && (pizza.getToppingsCount() == pizza.getToppings().size())) {

                    System.out.println(pizza.toString());
                }
            }
        }
    }
}
