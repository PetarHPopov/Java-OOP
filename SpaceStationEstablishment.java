import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SpaceStationEstablishment {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        char[][] space = new char[n][];

        int energy = 0;

        int[] positionStefan = new int[2];

        int[] oFirst = new int[2];
        oFirst[0] = -1;
        int[] oSecond = new int[2];

        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            space[i] = line.toCharArray();

            if (line.contains("S")) {
                positionStefan[0] = i;
                positionStefan[1] = line.indexOf('S');
            }
            if (line.contains("O") && oFirst[0] == -1) {
                oFirst[0] = i;
                oFirst[1] = line.indexOf('O');
            }
            if (line.contains("O") && oFirst[0] != -1) {
                oSecond[0] = i;
                oSecond[1] = line.lastIndexOf('O');
            }
        }
        boolean outOfSpace = true;

        while (energy < 50 && outOfSpace) {
            String command = reader.readLine();
            switch (command) {
                case "up":
                    outOfSpace = canMove(positionStefan[0] - 1, positionStefan[1], space);
                    if (outOfSpace) {
                        space[positionStefan[0]][positionStefan[1]] = '-';
                        positionStefan[0] -= 1;
                        char whichOne = space[positionStefan[0]][positionStefan[1]];
                        if (whichOne >= 48 && whichOne <= 57) {
                            energy += whichOne - 48;
                        } else if (whichOne == 'O') {
                            if (positionStefan[0] == oFirst[0] && positionStefan[1] == oFirst[1]) {
                                space[positionStefan[0]][positionStefan[1]] = '-';
                                positionStefan[0] = oSecond[0];
                                positionStefan[1] = oSecond[1];
                            } else {
                                space[positionStefan[0]][positionStefan[1]] = '-';
                                positionStefan[0] = oFirst[0];
                                positionStefan[1] = oFirst[1];
                            }
                        }
                        space[positionStefan[0]][positionStefan[1]] = 'S';
                    }
                    break;
                case "down":
                    outOfSpace = canMove(positionStefan[0] + 1, positionStefan[1], space);
                    if (outOfSpace) {
                        space[positionStefan[0]][positionStefan[1]] = '-';
                        positionStefan[0] += 1;
                        char whichOne = space[positionStefan[0]][positionStefan[1]];
                        if (whichOne >= 48 && whichOne <= 57) {
                            energy += whichOne - 48;
                        } else if (whichOne == 'O') {
                            if (positionStefan[0] == oFirst[0] && positionStefan[1] == oFirst[1]) {
                                space[positionStefan[0]][positionStefan[1]] = '-';
                                positionStefan[0] = oSecond[0];
                                positionStefan[1] = oSecond[1];
                            } else {
                                space[positionStefan[0]][positionStefan[1]] = '-';
                                positionStefan[0] = oFirst[0];
                                positionStefan[1] = oFirst[1];
                            }
                        }
                        space[positionStefan[0]][positionStefan[1]] = 'S';
                    }
                    break;
                case "left":
                    outOfSpace = canMove(positionStefan[0], positionStefan[1] - 1, space);
                    if (outOfSpace) {
                        space[positionStefan[0]][positionStefan[1]] = '-';
                        positionStefan[1] -= 1;
                        char whichOne = space[positionStefan[0]][positionStefan[1]];
                        if (whichOne >= 48 && whichOne <= 57) {
                            energy += whichOne - 48;
                        } else if (whichOne == 'O') {
                            if (positionStefan[0] == oFirst[0] && positionStefan[1] == oFirst[1]) {
                                space[positionStefan[0]][positionStefan[1]] = '-';
                                positionStefan[0] = oSecond[0];
                                positionStefan[1] = oSecond[1];
                            } else {
                                space[positionStefan[0]][positionStefan[1]] = '-';
                                positionStefan[0] = oFirst[0];
                                positionStefan[1] = oFirst[1];
                            }
                        }
                        space[positionStefan[0]][positionStefan[1]] = 'S';
                    }
                    break;
                case "right":
                    outOfSpace = canMove(positionStefan[0], positionStefan[1] + 1, space);
                    if (outOfSpace) {
                        space[positionStefan[0]][positionStefan[1]] = '-';
                        positionStefan[1] += 1;
                        char whichOne = space[positionStefan[0]][positionStefan[1]];
                        if (whichOne >= 48 && whichOne <= 57) {
                            energy += whichOne - 48;
                        } else if (whichOne == 'O') {
                            if (positionStefan[0] == oFirst[0] && positionStefan[1] == oFirst[1]) {
                                space[positionStefan[0]][positionStefan[1]] = '-';
                                positionStefan[0] = oSecond[0];
                                positionStefan[1] = oSecond[1];
                            } else {
                                space[positionStefan[0]][positionStefan[1]] = '-';
                                positionStefan[0] = oFirst[0];
                                positionStefan[1] = oFirst[1];
                            }
                        }
                        space[positionStefan[0]][positionStefan[1]] = 'S';
                    }
                    break;
            }
        }
        if (!outOfSpace) {
            System.out.println("Bad news, the spaceship went to the void.");
            space[positionStefan[0]][positionStefan[1]] = '-';
        } else System.out.println("Good news! Stephen succeeded in collecting enough star power!");

        System.out.printf("Star power collected: %d%n", energy);

        for (int row = 0; row < space.length; row++) {
            for (int col = 0; col < space[row].length; col++) {
                System.out.print(space[row][col] + "");
            }
            System.out.println();
        }
    }


    private static boolean canMove(int newRow, int newCol, char[][] matrix) {
        return newRow >= 0 && newRow < matrix.length && newCol >= 0 && newCol < matrix[newRow].length;
    }


}
