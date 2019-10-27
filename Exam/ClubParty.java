package Exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class ClubParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int maxCapacity = Integer.parseInt(reader.readLine());
        int freeCapacity = maxCapacity;

        boolean peopleContained = false;

        ArrayDeque<String> rooms = new ArrayDeque<>();
        ArrayDeque<Integer> people = new ArrayDeque<>();

        ArrayDeque<String> input = new ArrayDeque<>();

        Arrays.stream(reader.readLine().split("\\s+")).forEach(input::push);

        for (String token : input) {
            if (Character.isLetter(token.charAt(0))) {
                rooms.offer(token);
            } else {
                final int peopleCapacity = Integer.parseInt(token);
                while (rooms.size() >= 1) {
                    if (freeCapacity >= peopleCapacity) {
                        people.offer(peopleCapacity);
                        freeCapacity -= peopleCapacity;
                        peopleContained = true;
                        break;
                    }
                    System.out.print(rooms.peek() + " -> ");
                    int size = people.size();
                    int counter = 0;
                    for (Integer p : people) {
                        if (counter == size - 1) {
                            System.out.println(p);
                        } else {
                            System.out.print(p + ", ");
                        }
                        counter++;
                    }

                    rooms.poll();
                    people.clear();
                    freeCapacity = maxCapacity;
                }
                if ( !peopleContained) {
                    if (maxCapacity >= peopleCapacity) {
                        if (freeCapacity < peopleCapacity) {
                            while (freeCapacity < peopleCapacity) {
                                int removerdPeople = people.poll();
                                freeCapacity += removerdPeople;
                            }
                        }
                        people.offer(peopleCapacity);
                        freeCapacity -= peopleCapacity;
                    }
                }
            }
        }
    }
}
