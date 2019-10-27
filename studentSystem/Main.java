package studentSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StudentSystem studentSystem = new StudentSystem();
        String line = reader.readLine();
        while (!"Exit".equals(line)) {
            String[] input = line.split(" ");

            studentSystem.ParseCommand(input);

            line = reader.readLine();
        }
    }
}
