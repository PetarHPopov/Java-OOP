import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RhombusOfStars {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(reader.readLine());

        for (int startCount = 1; startCount <= size; startCount++) {
            printRow(size, startCount);
        }
        for (int startCount = size - 1; startCount >= 1 ; startCount--) {
            printRow(size, startCount);
        }


    }

    private static void printRow(int size, int startCount) {
        for (int i = 0; i < size - startCount ; i++) {
            System.out.print(" ");
        }
        for (int i = 1; i < startCount ; i++) {
            System.out.print("* ");
        }
        System.out.println("*");
    }
}
