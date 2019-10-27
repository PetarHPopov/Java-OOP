package Exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExcelFunctions {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(reader.readLine());

        String[][] matrix = new String[count][];

        for (int i = 0; i < count; i++) {
            matrix[i] = reader.readLine().split(", ");
        }
        String[] criteria = reader.readLine().split("\\s+");

        String command = criteria[0];

        if (command.equals("hide")) {
            String argument = criteria[1];
            int index = -1;

            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[0][j].equals(argument)) {
                    index = j;
                    break;
                }
            }
            for (String[] strings : matrix) {
                for (int j = 0; j < strings.length; j++) {
                    if (j == index) {
                        continue;
                    }
                    System.out.print(strings[j]);
                    if (j != strings.length - 1) {
                        System.out.print(" | ");
                    }
                }
                System.out.println();
            }
        }else if (command.equals("filter")){
            int index = -1;

            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[0][j].equals(criteria[1])) {
                    index = j;
                    break;
                }
            }
            System.out.print(String.join(" | ",matrix[0]));
            System.out.println();
            for (String[] strings : matrix) {
                if (strings[index].equals(criteria[2])) {
                    System.out.print(String.join(" | ", strings));
                }
            }
        }else {

        }
    }
}
