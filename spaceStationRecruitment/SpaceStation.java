package spaceStationRecruitment;

import java.util.ArrayList;
import java.util.List;

public class SpaceStation {
    private List<Astronaut> data;
    private String name;
    private int capacity;

    public SpaceStation(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }
    public int getCount(){
        return this.data.size();
    }
    public void add(Astronaut astronaut){
        if (getCount() < this.capacity){
            this.data.add(astronaut);
        }
    }
    public boolean remove(String name){

        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getName().equals(name)){
                this.data.remove(i);
                return true;
            }
        }

        return false;
    }
    public Astronaut getOldestAstronaut(){
        Astronaut astronaut = null;
        int oldest = Integer.MIN_VALUE;
        for (Astronaut datum : data) {
          if (datum.getAge() > oldest ){
              oldest = datum.getAge();
              astronaut = datum;
          }
        }
        return astronaut;
    }
    public Astronaut getAstronaut(String name){
        Astronaut astronaut = null;
        for (Astronaut datum : data) {
            if (datum.getName().equals(name)){
                astronaut = datum;
            }
        }
        return astronaut;
    }
    public String report (){
        StringBuilder sb = new StringBuilder();
        sb.append("Astronauts working at Space Station :").append(System.lineSeparator());
        for (Astronaut astronaut : data) {
            sb.append(astronaut).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

}
