package PracticeHome;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class MakeASalad {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<String> vegetableQu = new ArrayDeque<>();
        ArrayDeque<Integer> caloriesSt = new ArrayDeque<>();

        Arrays.stream(reader.readLine().split("\\s+")).forEach(vegetableQu::offer);
        Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(caloriesSt::push);

        while (!vegetableQu.isEmpty() && !caloriesSt.isEmpty()) {
            int currentCalories = caloriesSt.peek();

            while (currentCalories > 0 && !vegetableQu.isEmpty()) {
                String product = vegetableQu.poll();

                switch (product) {
                    case "tomato":
                        currentCalories -= 80;
                        break;
                    case "carrot":
                        currentCalories -= 136;
                        break;
                    case "lettuce":
                        currentCalories -= 109;
                        break;
                    case "potato":
                        currentCalories -= 215;
                        break;
                }
            }
            System.out.print(caloriesSt.pop() + " ");

        }
        System.out.println();

        if (!caloriesSt.isEmpty()) {
            for (Integer integer : caloriesSt) {
                System.out.print(integer + " ");
            }
        }

        if (!vegetableQu.isEmpty()) {
            for (String integer : vegetableQu) {
                System.out.print(integer + " ");
            }
        }
    }
}
