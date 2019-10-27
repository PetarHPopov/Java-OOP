import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TronRacers {
    private static String[][] matrix;
    private static int
            fRow = -1,
            fCol = -1,
            sRow = -1,
            sCol = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        matrix = new String[n][];

        for (int r = 0; r < n; r++) {
            String line = reader.readLine();
            matrix[r] = line.split("");
            if (line.contains("f")) {
                fRow = r;
                fCol = line.indexOf("f");
            } else if (line.contains("s")) {
                sRow = r;
                sCol = line.indexOf("s");
            }
        }

        boolean firstIsAlive = true;
        boolean secondIsAlive = true;

        while (secondIsAlive) {
            String[] commands = reader.readLine().split("\\s+");
            String firstDirection = commands[0];
            String secondDirection = commands[1];

            firstIsAlive = movePlayer("f", fRow, fCol, firstDirection);
            if (!firstIsAlive) {
                break;
            }
            secondIsAlive = movePlayer("s", sRow, sCol, secondDirection);

        }

        printMatrix(matrix);
    }

    private static boolean movePlayer(String player, int playerX, int playerY, String direction) {
        int newPlayerX = playerX;
        int newPlayerY = playerY;

        switch (direction) {
            case "up":
                // newPlayerX = playerX - 1 < 0 ? matrix.length - 1 : playerX - 1;
                if (playerX - 1 < 0) {
                    newPlayerX = matrix.length - 1;
                } else {
                    newPlayerX = playerX - 1;
                }
                break;
            case "down":
                //newPlayerX = playerX + 1 >= playfield.length ?
                //                        0 : playerX + 1;
                if (playerX + 1 >= matrix.length) {
                    newPlayerX = 0;
                } else {
                    newPlayerX = playerX + 1;
                }
                break;
            case "left":
                //newPlayerY = playerY - 1 < 0 ?
                //                        playfield.length - 1 : playerY - 1;
                if (playerY - 1 < 0) {
                    newPlayerY = matrix.length - 1;
                } else {
                    newPlayerY = playerY - 1;
                }
                break;
            case "right":
                //newPlayerY = playerY + 1 >= playfield.length ?
                //                        0 : playerY + 1;
                if (playerY + 1 >= matrix.length) {
                    newPlayerY = 0;
                } else {
                    newPlayerY = playerY + 1;
                }
                break;
        }
        if ((matrix[newPlayerX][newPlayerY].equals("f") && player.equals("s")) ||
                (matrix[newPlayerX][newPlayerY].equals("s") && player.equals("f"))) {
            matrix[newPlayerX][newPlayerY] = "x";
            return false;
        }

        matrix[newPlayerX][newPlayerY] = player;

        if (player.equals("f")) {
            fRow = newPlayerX;
            fCol = newPlayerY;
        } else if (player.equals("s")) {
            sRow = newPlayerX;
            sCol = newPlayerY;
        }


        return true;
    }

    private static void printMatrix(String[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }
}
