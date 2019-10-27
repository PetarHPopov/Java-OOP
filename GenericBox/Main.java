package GenericBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        List<Box<Double>> boxList = new ArrayList<>();

        while (n-- > 0) {
            String line = reader.readLine();
            Box<Double> box = new Box<>(Double.parseDouble(line));
            boxList.add(box);


            System.out.println();
        }

        String line = reader.readLine();
        Box<Double> comparatorBox = new Box<>(Double.parseDouble(line));
        System.out.print(countValue(boxList,comparatorBox));

    }

    public static <T extends Comparable<T>> int countValue(List<Box<T>> list, Box<T> box){
        int count = 0;
        for (Box<T> t : list) {
            if (t.compareTo(box) > 0){
                count++;
            }
        }
        return count;
    }
}
