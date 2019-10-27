package foodShortage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int lines = Integer.parseInt(reader.readLine());

        HashMap<String, Buyer> buyers = new HashMap<>();

        String name;

        while (lines-- > 0) {

            String[] data = reader.readLine().split("\\s+");
            name = data[0];

            if (data.length == 3) {
                buyers.putIfAbsent(name, new Rebel(name, Integer.parseInt(data[1]), data[2]));
            }
            else if (data.length == 4) {
                buyers.putIfAbsent(name, new Citizen(name, Integer.parseInt(data[1]), data[2], data[3]));
            }
        }



        while (!"End".equals(name = reader.readLine())) {

            Buyer buyer = buyers.get(name);

            if (buyer != null) {
                buyer.buyFood();
            }
        }

        System.out.println(buyers.values().stream().mapToInt(Buyer::getFood).sum());
    }
}
