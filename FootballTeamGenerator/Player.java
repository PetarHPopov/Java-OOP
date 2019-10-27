package FootballTeamGenerator;

public class Player {

    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name.trim().length() == 0) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    private void setEndurance(int endurance) {
        validateState("Endurance", endurance);
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        validateState("Sprint", sprint);
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        validateState("Dribble", dribble);
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        validateState("Passing", passing);
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        validateState("Shooting", shooting);
        this.shooting = shooting;
    }

    private void validateState(String name, int stat) {
        if (stat < 0 || stat > 100) {
            throw new IllegalArgumentException(name + " should be between 0 and 100.");
        }
    }
    public double 	overallSkillLevel(){
        return (this.dribble + this.endurance + this.passing + this.shooting + this.sprint)/5.0;
    }
}
