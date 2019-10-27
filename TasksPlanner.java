import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TasksPlanner {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> input = Arrays.stream(reader.readLine().split("\\s+")).
                map(Integer::parseInt).
                collect(Collectors.toList());

        int countCompleted = 0;
        int countIncomplete = 0;
        int countDropped = 0;

        String line;

        while (!"End".equalsIgnoreCase(line = reader.readLine())) {

            String[] tokens = line.split("\\s+");
            String command = tokens[0];

            if (tokens.length == 2) {
                if ("Complete".equals(command)) {
                    int index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index < input.size()) {
                        input.set(index, 0);
                    }

                } else if ("Drop".equals(command)) {
                    int index2 = Integer.parseInt(tokens[1]);
                    if (index2 >= 0 && index2 < input.size()) {
                        input.set(index2, -1);
                    }
                } else if ("Count".equals(command)) {
                    if (tokens[1].equals("Completed")) {
                        for (Integer integer : input) {
                            if (integer == 0) {
                                countCompleted++;
                            }
                        }
                        System.out.println(countCompleted);
                    }
                    if (tokens[1].equals("Incomplete")) {
                        for (Integer integer : input) {
                            if (integer > 0) {
                                countIncomplete++;
                            }
                        }
                        System.out.println(countIncomplete);
                    }
                    if (tokens[1].equals("Dropped")) {
                        for (Integer integer : input) {
                            if (integer == -1) {
                                countDropped++;
                            }
                        }
                        System.out.println(countDropped);
                    }
                }
            } else {
                int index1 = Integer.parseInt(tokens[1]);
                int time = Integer.parseInt(tokens[2]);

                if (index1 >= 0 && index1 < input.size()) {
                    input.set(index1, time);
                }
            }
        }
        input.stream().filter(e -> e != 0 && e != -1).forEach(e -> System.out.print(e + " "));
    }
}

