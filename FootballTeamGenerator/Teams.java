package FootballTeamGenerator;

import java.util.HashMap;

public class Teams {
    private final static HashMap<String, Team> collection = new HashMap<>();

    static void add(Team team) {
        if (team != null) {
            Teams.collection.putIfAbsent(team.getName(), team);
        }
    }

    static Team get(String name) {

        Team team = Teams.collection.get(name);

        if (team == null) {
            throw new IllegalArgumentException("Team " + name + " does not exist.");
        }
        return team;
    }
}
