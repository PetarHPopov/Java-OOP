package RandomArrayList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        RandomArrayList<Integer> randomArrayList = new RandomArrayList<Integer>();

        randomArrayList.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9));

        System.out.println(randomArrayList.getRandomElement());

    }
}
