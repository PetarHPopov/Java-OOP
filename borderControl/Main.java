package borderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        List<Robot> robots = new ArrayList<>();
        List<Citizen> citizens = new ArrayList<>();

        while (!"End".equals(input)) {

            String[] tokens = input.split("\\s+");

            if (tokens.length == 2) {
                Robot robot = new Robot(tokens[0], tokens[1]);
                robots.add(robot);
            } else if (tokens.length == 3) {
                citizens.add(new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2]));
            }

            input = reader.readLine();
        }
        int criteria = Integer.parseInt(reader.readLine());
        if (!citizens.isEmpty()) {
            for (Citizen citizen : citizens) {
                if (citizen.getId().endsWith(String.valueOf(criteria))) {
                    System.out.println(citizen.getId());
                }
            }
        }
        if (!robots.isEmpty()) {
            for (Robot robot : robots) {
                if (robot.getId().endsWith(String.valueOf(criteria))) {
                    System.out.println(robot.getId());
                }
            }
        }
    }
}
