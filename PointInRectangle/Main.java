package PointInRectangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] coordination = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int bottomLeftX = coordination[0];
        int bottomLeftY = coordination[1];
        int topRightX = coordination[2];
        int topRightY = coordination[3];

        Point bottomLeft = new Point(bottomLeftX, bottomLeftY);
        Point topRight = new Point(topRightX,topRightY);

        Rectangle rectangle = new Rectangle(bottomLeft,topRight);

        int countPoints = Integer.parseInt(reader.readLine());

        while (countPoints-- > 0) {

            int[] coordinationXY = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int x = coordinationXY[0];
            int y = coordinationXY[1];
            Point newPoint = new Point(x, y);

            System.out.println(rectangle.contains(newPoint));
        }
    }
}
