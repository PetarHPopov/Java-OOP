import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class ClubParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<String> hallsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> reservationQueue = new ArrayDeque<>();

        int maxCapacity = Integer.parseInt(reader.readLine());

        ArrayDeque<String> inputStack = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split("\\s+")).forEach(inputStack::push);
        int currantCapacity = 0;

        while (!inputStack.isEmpty()) {
            String element = inputStack.pop();
            if (Character.isLetter(element.charAt(0))) {
                hallsQueue.offer(element);
            } else {
                int reservation = Integer.parseInt(element);
                if (currantCapacity + reservation > maxCapacity){
                    printHall(hallsQueue,reservationQueue);
                    currantCapacity = 0;
                }
                if (hallsQueue.isEmpty()){
                    continue;
                }
                currantCapacity += reservation;
                reservationQueue.offer(reservation);
            }
        }
    }

    public static void printHall(ArrayDeque<String> halls, ArrayDeque<Integer> reservation) {
        System.out.print(halls.poll() + " -> ");
        while (!reservation.isEmpty()) {
            if (reservation.size() == 1) {
                System.out.print(reservation.poll());
            } else {
                System.out.print(reservation.poll() + ", ");
            }
        }
        System.out.println();
    }
}
