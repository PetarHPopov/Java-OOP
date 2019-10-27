package vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] data = reader.readLine().split(" ");
        Vehicle car = new Car(
                Double.parseDouble(data[1]),
                Double.parseDouble(data[2]),
                Double.parseDouble(data[3])
        );

        data = reader.readLine().split(" ");
        Vehicle truck = new Truck(
                Double.parseDouble(data[1]),
                Double.parseDouble(data[2]),
                Double.parseDouble(data[3])
        );

        data = reader.readLine().split(" ");
        Vehicle bus = new Bus(
                Double.parseDouble(data[1]),
                Double.parseDouble(data[2]),
                Double.parseDouble(data[3])
        );

        int count = Integer.parseInt(reader.readLine());

        while (count-- > 0) {
            data = reader.readLine().split(" ");

            String command = data[0];
            String vehicle = data[1];
            double argument = Double.parseDouble(data[2]);

            switch (vehicle) {
                case "Car":
                    switch (command) {
                        case "Drive":
                            car.drive(argument);
                            break;
                        case "Refuel":
                            car.refuel(argument);
                            break;
                    }
                    break;
                case "Truck":
                    switch (command) {
                        case "Drive":
                            truck.drive(argument);
                            break;
                        case "Refuel":
                            truck.refuel(argument);
                            break;
                    }
                    break;
                case "Bus":
                    switch (command) {
                        case "Drive":
                            bus.setAirConditionStatus(true);
                            bus.drive(argument);
                            break;
                        case "DriveEmpty":
                            bus.setAirConditionStatus(false);
                            bus.drive(argument);
                            break;
                        case "Refuel":
                            bus.refuel(argument);
                            break;
                    }
                    break;
            }
        }
        System.out.println(car.toString());
        System.out.println(truck.toString());
        System.out.println(bus.toString());
    }
}
