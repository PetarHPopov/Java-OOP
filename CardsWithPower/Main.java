package CardsWithPower;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Rank rank = Rank.valueOf(reader.readLine());
        Suit suit = Suit.valueOf(reader.readLine());

        Card card = new Card(rank,suit);
        System.out.println(card);
    }

}
