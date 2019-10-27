package GenericSwap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        List<Box<String>> boxStrings = new ArrayList<>();

        while (n-- > 0) {
            String line = reader.readLine();
            Box<String> box = new Box<>(line);
            boxStrings.add(box);
        }
        int[] swapIndex = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();


        swapValues(boxStrings, swapIndex[0], swapIndex[1]);
        for (Box<String> box : boxStrings) {
            System.out.println(box.toString());
        }
    }

    private static <E> void swapValues(List<E> list, int firstIndex, int secondIndex) {
        E temp = list.get(firstIndex);
        list.set(firstIndex, list.get(secondIndex));
        list.set(secondIndex, temp);
    }
}
