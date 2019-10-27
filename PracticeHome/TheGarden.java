package PracticeHome;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheGarden {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int carrots = 0;
        int potatoes = 0;
        int lettuce = 0;
        int totalCount = 0;

        String[][] matrix = new String[n][];
        for (int row = 0; row < n; row++) {
            matrix[row] = reader.readLine().split("\\s+");
        }
        String line = reader.readLine();
        while (!"End of Harvest".equals(line)) {
            String[] tokens = line.split("\\s+");
            String command = tokens[0];
            int row = Integer.parseInt(tokens[1]);
            int col = Integer.parseInt(tokens[2]);
            if (isValid(matrix, row, col)) {
                if (command.equals("Harvest")) {
                    switch (matrix[row][col]) {
                        case "C":
                            carrots++;
                            break;
                        case "L":
                            lettuce++;
                            break;
                        case "P":
                            potatoes++;
                            break;
                    }
                    matrix[row][col] = " ";

                } else if (command.equals("Mole")) {
                    String direction = tokens[3];
                    switch (direction) {
                        case "up":
                            for (int r = row; r >= 0; r -= 2) {
                                if (!matrix[r][col].equals(" ")) {
                                    matrix[r][col] = " ";
                                    totalCount++;
                                }

                            }
                            break;
                        case "down":
                            for (int r = row; r < matrix.length; r += 2) {
                                if (!matrix[r][col].equals(" ")) {
                                    matrix[r][col] = " ";
                                    totalCount++;
                                }

                            }
                            break;
                        case "left":
                            for (int c = col; c >= 0; c -= 2) {
                                if (!matrix[row][c].equals(" ")) {
                                    matrix[row][c] = " ";
                                    totalCount++;
                                }

                            }
                            break;
                        case "right":
                            for (int c = col; c < matrix[row].length; c += 2) {
                                if (!matrix[row][c].equals(" ")) {
                                    matrix[row][c] = " ";
                                    totalCount++;
                                }

                            }
                            break;
                    }
                }

            }
            line = reader.readLine();
        }
        printMetrix(matrix);

        System.out.println("Carrots: " + carrots);
        System.out.println("Potatoes: " + potatoes);
        System.out.println("Lettuce: " + lettuce);
        System.out.println("Harmed vegetables: " + totalCount);

    }

    public static void printMetrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isValid(String[][] matrix, int row, int col) {
        if (row >= 0 && col >= 0 && row < matrix.length && col < matrix[row].length) {
            return true;
        }
        return false;
    }
}
