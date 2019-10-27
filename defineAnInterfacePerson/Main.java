package defineAnInterfacePerson;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();
        List<Pet> pets = new ArrayList<>();
        List<Robot> robots = new ArrayList<>();
        List<Citizen> citizens = new ArrayList<>();

        while (!"End".equals(line)) {
            String[] tokens = line.split("\\s+");
            String clas = tokens[0];
            switch (clas) {
                case "Citizen":
                    citizens.add(new Citizen(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]));
                    break;
                case "Pet":
                    pets.add(new Pet(tokens[1], tokens[2]));
                    break;
                case "Robot":
                    robots.add(new Robot(tokens[1], tokens[2]));
                    break;
            }
            line = reader.readLine();
        }
        String criteria = reader.readLine();
        for (Citizen citizen : citizens) {
            if (citizen.getBirthDate().endsWith(criteria)){
                System.out.println(citizen.getBirthDate());
            }
        }
        for (Pet pet : pets) {
            if (pet.getBirthDate().endsWith(criteria)){
                System.out.println(pet.getBirthDate());
            }
        }
    }
}
