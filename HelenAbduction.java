import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HelenAbduction {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int energy = Integer.parseInt(reader.readLine());
        int countRows = Integer.parseInt(reader.readLine());

        String[][] field = new String[countRows][];

        int parisRow = -1;
        int parisCol = -1;

        for (int row = 0; row < countRows; row++) {
            String line = reader.readLine();
            field[row] = line.split("");
            if (line.contains("P")) {
                parisRow = row;
                parisCol = line.indexOf("P");
            }

        }
        boolean isAbducted = false;
        while (energy > 0 && !isAbducted) {
            energy--;
            String[] tokens = reader.readLine().split(" ");
            String direction = tokens[0];
            int row = Integer.parseInt(tokens[1]);
            int col = Integer.parseInt(tokens[2]);

            field[row][col] = "S";

            if (direction.equals("up") && canMove(parisRow - 1, parisCol, field)) {
                field[parisRow][parisCol] = "-";
                parisRow--;
                if (field[parisRow][parisCol].equals("S")) {
                    energy -= 2;
                } else if (field[parisRow][parisCol].equals("H")) {
                    isAbducted = true;
                }
                field[parisRow][parisCol] = "P";
            } else if (direction.equals("down") && canMove(parisRow + 1, parisCol, field)) {
                field[parisRow][parisCol] = "-";
                parisRow++;
                if (field[parisRow][parisCol].equals("S")) {
                    energy -= 2;
                } else if (field[parisRow][parisCol].equals("H")) {
                    isAbducted = true;
                }
                field[parisRow][parisCol] = "P";
            } else if (direction.equals("left") && canMove(parisRow, parisCol - 1, field)) {
                field[parisRow][parisCol] = "-";
                parisCol--;
                if (field[parisRow][parisCol].equals("S")) {
                    energy -= 2;
                } else if (field[parisRow][parisCol].equals("H")) {
                    isAbducted = true;
                }
                field[parisRow][parisCol] = "P";
            } else if (direction.equals("right") && canMove(parisRow, parisCol + 1, field)) {
                field[parisRow][parisCol] = "-";
                parisCol++;
                if (field[parisRow][parisCol].equals("S")) {
                    energy -= 2;
                } else if (field[parisRow][parisCol].equals("H")) {
                    isAbducted = true;
                }
                field[parisRow][parisCol] = "P";
            }
        }
            if (isAbducted) {
                field[parisRow][parisCol] = "-";
                System.out.println("Paris has successfully abducted Helen! Energy left: " + energy);
            }else {
                field[parisRow][parisCol] = "X";
                System.out.println(String.format("Paris died at %d;%d.",parisRow,parisCol));
            }

        printMatrix(field);
    }

    private static boolean canMove(int newParisRow, int newParisCol, String[][] field) {
        return newParisRow >= 0 && newParisRow < field.length && newParisCol >= 0 && newParisCol < field[newParisRow].length;
    }

    private static void printMatrix(String[][] field) {
        for (int r = 0; r < field.length; r++) {
            for (int c = 0; c < field[r].length; c++) {
                System.out.print(field[r][c]);
            }
            System.out.println();
        }
    }

}
