package jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] fild = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int row = fild[0];
        int col = fild[1];

        int[][] matrix = new int[row][col];

        int value = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                matrix[r][c] = value++;
            }
        }

        String command = scanner.nextLine();
        long sum = 0;
        while (!command.equals("Let the Force be with you")) {

            int[] ivoS = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] evil = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int xE = evil[0];
            int yE = evil[1];

            while (xE >= 0 && yE >= 0) {
                if (xE < matrix.length &&  yE < matrix[0].length) {
                    matrix[xE] [yE] = 0;
                }
                xE--;
                yE--;
            }

            int xI = ivoS[0];
            int yI = ivoS[1];

            while (xI >= 0 && yI < matrix[1].length) {
                if ( xI < matrix.length && yI >= 0 && yI < matrix[0].length) {
                    sum += matrix[xI][yI];
                }
                yI++;
                xI--;
            }
            command = scanner.nextLine();
        }
        System.out.println(sum);
    }
}
