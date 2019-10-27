package FootballTeamGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while (!"END".equals(line = reader.readLine())) {

            String[] tokens = line.split(";");

            try {
                String command = tokens[0];
                String teamName = tokens[1];
                switch (command) {
                    case "Team":

                        Teams.add(new Team(teamName));
                        break;
                    case "Add":
                        Team team = Teams.get(teamName);
                        Player player = new Player(
                                tokens[2],
                                Integer.parseInt(tokens[3]),
                                Integer.parseInt(tokens[4]),
                                Integer.parseInt(tokens[5]),
                                Integer.parseInt(tokens[6]),
                                Integer.parseInt(tokens[7])
                        );
                        team.addPlayer(player);
                        break;
                    case "Remove":
                        Teams.get(tokens[1]).removePlayer(tokens[2]);
                        break;
                    case "Rating":
                        System.out.println(Teams.get(tokens[1]).toString());
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
