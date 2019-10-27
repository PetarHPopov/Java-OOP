import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class TrojanInvasion {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countWaves = Integer.parseInt(reader.readLine());

        ArrayDeque<Integer> defenders = new ArrayDeque<>();

        Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(defenders::offer);

        ArrayDeque<Integer> attackers = new ArrayDeque<>();

        for (int i = 1; i <= countWaves && !defenders.isEmpty() ; i++) {

            Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(attackers::push);

            if (i % 3 == 0) {
                int newPlate = Integer.parseInt(reader.readLine());
                defenders.offer(newPlate);
            }
            while (!attackers.isEmpty() && !defenders.isEmpty()) {
                int attacker = attackers.pop();
                int defender = defenders.poll();


                if (attacker > defender) {
                    attacker -= defender;
                    attackers.push(attacker);
                } else if (attacker < defender) {
                    defender -= attacker;
                    defenders.addFirst(defender);
                }
            }
        }
        if (defenders.isEmpty()) {
            System.out.print(String.format("The Trojans successfully destroyed the Spartan defense.%nWarriors left: "));
            StringBuilder sb = new StringBuilder();
            for (Integer attacker : attackers) {
                sb.append(attacker).append(", ");
            }
            System.out.print(sb.substring(0,sb.length() - 2));

        }else {
            System.out.print(String.format("The Spartans successfully repulsed the Trojan attack.%nPlates left: "));
            StringBuilder sb = new StringBuilder();
            for (Integer defender : defenders) {
                sb.append(defender).append(", ");
            }
            System.out.print(sb.substring(0,sb.length() - 2));
        }
    }
}
