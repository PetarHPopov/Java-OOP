import org.w3c.dom.stylesheets.LinkStyle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SpaceshipCrafting {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> chemicalQueue = new ArrayDeque<>();
        ArrayDeque<Integer> physicalItemsStack = new ArrayDeque<>();

        Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(chemicalQueue::offer);
        Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(physicalItemsStack::push);

        List<Integer> output = new ArrayList<>();
        int aluminium = 0;
        int carbon = 0;
        int glass = 0;
        int lithium = 0;

        while (!chemicalQueue.isEmpty() && !physicalItemsStack.isEmpty()) {

            int elementQueue = chemicalQueue.peek();
            int elementStack = physicalItemsStack.peek();
            int sumElement = elementQueue + elementStack;
            String element = "";
            int num = 0;
            if (sumElement == 25 || sumElement == 50 || sumElement == 75 || sumElement == 100) {
                if (sumElement == 25) {
                    element = "Glass";
                    glass++;

                } else if (sumElement == 50) {
                    element = "Aluminium";
                    aluminium++;
                    num = 50;
                } else if (sumElement == 75) {
                    element = "Lithium";
                    lithium++;
                    num = 75;
                } else if (sumElement == 100) {
                    element = "Carbon fiber";
                    carbon++;
                    num = 100;
                }
                chemicalQueue.poll();
                physicalItemsStack.pop();

                output.add(num);

            } else {
                chemicalQueue.poll();
                physicalItemsStack.pop();
                elementStack += 3;
                physicalItemsStack.push(elementStack);
            }


        }
        if (aluminium != 0 && carbon != 0 && glass != 0 && lithium != 0) {
            System.out.println("Wohoo! You succeeded in building the spaceship!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to build the spaceship.");
        }
        if (!chemicalQueue.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Liquids left: ");
            for (Integer integer : chemicalQueue) {
                sb.append(integer + ", ");
            }
            System.out.print(sb.substring(0, sb.length() - 2));
        } else {
            System.out.println("Liquids left: none");
        }

        if (!physicalItemsStack.isEmpty()) {
            System.out.print("Physical items left: ");
            StringBuilder sb = new StringBuilder();
            for (Integer integer : physicalItemsStack) {
                sb.append(integer).append(", ");
            }
            System.out.println(sb.substring(0, sb.length() - 2));

        } else {
            System.out.println("Physical items left: none");
        }

        System.out.println("Aluminium: " + aluminium);
        System.out.println("Carbon fiber: " + carbon);
        System.out.println("Glass: " + glass);
        System.out.println("Lithium: " + lithium);

    }
}
