package shoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;

        LinkedHashMap<String, Person> people = new LinkedHashMap<>();
        LinkedHashMap<String, Product> products = new LinkedHashMap<>();

        for (String obj : reader.readLine().split(";")) {
            String[] personData = obj.split("=");
            try {
                String name = personData[0];
                double money = Double.parseDouble(personData[1]);
                Person person = new Person(name,money );
                people.putIfAbsent(person.getName().toLowerCase(), person);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        for (String obj : reader.readLine().split(";")) {

            String[] productData = obj.split("=");

            Product product = new Product(productData[0], Double.parseDouble(productData[1]));
            products.putIfAbsent(product.getName().toLowerCase(), product);
        }

        while (!"END".equals(line = reader.readLine())) {

            String[] data = line.trim().split("\\s+");

            Person person = people.get(data[0].toLowerCase());
            Product product = products.get(data[1].toLowerCase());

            try {
                person.buyProduct(product);
                System.out.println(String.format("%s bought %s", person.getName(), product.getName()));

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        for (Person person: people.values()) {
            System.out.println(person.toString());
        }
    }
}
