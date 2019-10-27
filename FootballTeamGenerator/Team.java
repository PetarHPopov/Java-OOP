package FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.trim().length() == 0) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addPlayer(Player player) {
        if (this.players != null) {
            this.players.add(player);
        }

    }

    public void removePlayer(String name) {
        Player player = this.players.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
        if (player == null){
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.",name,this.getName()));
        }
        this.players.removeIf(p -> p.getName().equals(name));
    }
    public double getRating(){
        if (this.players == null){
            throw new IllegalArgumentException("Team "+this.getName()+" does not exist.");
        }
        return this.players.stream().mapToDouble(Player::overallSkillLevel).average().orElse(0);
    }

    @Override
    public String toString() {
        return String.format("%s - %.0f",this.getName(),this.getRating());
    }
}
