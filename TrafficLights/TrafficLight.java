package TrafficLights;

public class TrafficLight {
    private LightStates states;

    public TrafficLight(LightStates states) {
        this.states = states;
    }
    public void update(){
        switch (this.states){
            case RED:
                this.states = LightStates.GREEN;
                break;
            case GREEN:
                this.states = LightStates.YELLOW;
                break;
            case YELLOW:
                this.states = LightStates.RED;
                break;
        }
    }
    @Override
    public String toString() {
        return this.states.toString();
    }
}
