package TrafficLights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");

        int count = Integer.parseInt(reader.readLine());

        ArrayList<TrafficLight> trafficLights = new ArrayList<>();

        for (String s : input) {
            TrafficLight trafficLight = new TrafficLight(LightStates.valueOf(s));
            trafficLights.add(trafficLight);
        }
        for (int i = 0; i <count; i++) {
            for (TrafficLight light : trafficLights) {
                light.update();
                System.out.print(light.toString() + " ");
            }
            System.out.println();
        }
    }
}
