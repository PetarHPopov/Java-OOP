
package greedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long input = Long.parseLong(scanner.nextLine());
        String[] safe = scanner.nextLine().split("\\s+");

        LinkedHashMap<String, LinkedHashMap<String, Long>> bagWhitItems = new LinkedHashMap<String, LinkedHashMap<String, Long>>();
        long gold = 0;
        long gem = 0;
        long money = 0;

        for (int i = 0; i < safe.length; i += 2) {
            String name = safe[i];
            long count = Long.parseLong(safe[i + 1]);

            String item = "";

            if (name.length() == 3) {
                item = "Cash";
            } else if (name.toLowerCase().endsWith("gem")) {
                item = "Gem";
            } else if (name.toLowerCase().equals("gold")) {
                item = "Gold";
            }

            if (item.equals("")) {
                continue;
            } else if (input < bagWhitItems.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum() + count) {
                continue;
            }

            switch (item) {
                case "Gem":
                    if (!bagWhitItems.containsKey(item)) {
                        if (bagWhitItems.containsKey("Gold")) {
                            if (count > bagWhitItems.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bagWhitItems.get(item).values().stream().mapToLong(e -> e).sum() + count > bagWhitItems.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!bagWhitItems.containsKey(item)) {
                        if (bagWhitItems.containsKey("Gem")) {
                            if (count > bagWhitItems.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bagWhitItems.get(item).values().stream().mapToLong(e -> e).sum() + count > bagWhitItems.get("Gem").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
            }

            if (!bagWhitItems.containsKey(item)) {
                bagWhitItems.put((item), new LinkedHashMap<String, Long>());
            }

            if (!bagWhitItems.get(item).containsKey(name)) {
                bagWhitItems.get(item).put(name, 0L);
            }


            bagWhitItems.get(item).put(name, bagWhitItems.get(item).get(name) + count);
            if (item.equals("Gold")) {
                gold += count;
            } else if (item.equals("Gem")) {
                gem += count;
            } else if (item.equals("Cash")) {
                money += count;
            }
        }

        for (Map.Entry<String, LinkedHashMap<String, Long>> x : bagWhitItems.entrySet()) {
            Long sumValues = x.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.println(String.format("<%s> $%s", x.getKey(), sumValues));

            x.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }
}