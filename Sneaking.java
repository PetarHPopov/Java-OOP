import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sneaking {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        String[][] matrix = new String[n][];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = reader.readLine().split("");
        }


        String[] commands = reader.readLine().split("");

        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            matrix = changeElementsInMatrix(matrix);
            printMatrix(matrix);
            matrix = movePositionSam(matrix, command);
            System.out.println("-----------------");
            System.out.println();

        }
        printMatrix(matrix);


    }

    private static String[][] movePositionSam(String[][] matrix, String command) {
        int[] position = findPosition(matrix);
        int row = position[0];
        int col = position[1];

        if (findBoss(matrix, matrix[row])) return matrix;
        if(checkEnemies(row, col, matrix[row])){
            return matrix;
        }


        matrix[row][col] = ".";

         switch (command){
            case "U":
                row--;
                matrix[row][col] = "S";
                if (findBoss(matrix, matrix[row])) return matrix;
                checkEnemies(row, col, matrix[row]);

                return matrix;
            case "D":
                row++;
                matrix[row][col] = "S";
                if (findBoss(matrix, matrix[row])) return matrix;
                checkEnemies(row, col, matrix[row]);
                return matrix;
            case "L":
                col--;
                matrix[row][col] = "S";
                if (findBoss(matrix, matrix[row])) return matrix;
                checkEnemies(row, col, matrix[row]);

                return matrix;
            case "R":
                col++;
                matrix[row][col] = "S";
                if (findBoss(matrix, matrix[row])) return matrix;
                checkEnemies(row, col, matrix[row]);

                return matrix;
        }

        return matrix;
    }

    private static boolean checkEnemies(int row, int col, String[] matrix2) {
        boolean flag = false;
        for (int i = col + 1; i < matrix2.length; i++) {
            if (matrix2[i].equals("d")) {
                System.out.println(String.format("Sam died at %d, %d", row, col));
                matrix2[col] = "X";
                flag = true;
                break;
            }
        }
        if(flag) {
            return flag;
        }
            for (int i = col - 1; i >= 0; i--) {
                if (matrix2[i].equals("b")) {
                    System.out.println(String.format("Sam died at %d, %d", row, col));
                    matrix2[col] = "X";
                    flag = true;
                    break;
                }
            }

        return flag;
    }

    private static boolean findBoss(String[][] matrix, String[] matrix1) {
        for (int i = 0; i < matrix1.length; i++) {
            if(matrix1[i].equals("N")){
                matrix1[i] = "X";
                System.out.println("Nikoladze killed!");
                return true;
            }
        }
        return false;
    }

    private static int[] findPosition(String[][] matrix){

        int[] position = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {

                if(matrix[row][col].equals("S")){
                    position[0] = row;
                    position[1] = col;
                }

            }
        }

        return position;
    }


    private static String[][] changeElementsInMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                String currentElement = matrix[row][col];

                if (currentElement.equals("b") && col < matrix[row].length - 1) {
                    matrix[row][col] = ".";
                    matrix[row][col + 1] = currentElement;
                    break;
                } if (col == 0 && currentElement.equals("d")) {
                    matrix[row][col] = "b";
                    break;
                } else if (currentElement.equals("b") && col == matrix[row].length - 1) {
                    matrix[row][col] = "d";
                    break;
                } else if (col >= 1 && currentElement.equals("d")) {
                    matrix[row][col] = ".";
                    matrix[row][col - 1] = currentElement;
                    break;
                }
            }
        }

        return matrix;
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
