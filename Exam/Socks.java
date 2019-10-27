package Exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Socks {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> leftSocks = new ArrayDeque<>();
        ArrayDeque<Integer> rightSocks = new ArrayDeque<>();

        List<Integer> pair = new ArrayList<>();

        Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(leftSocks::push);
        Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(rightSocks::offer);

        while (!leftSocks.isEmpty() && !rightSocks.isEmpty()) {
            int left = leftSocks.peek();
            int right = rightSocks.peek();

            leftSocks.pop();

            if (left == right) {
                rightSocks.poll();
                leftSocks.push(left + 1);

            } else if (left > right){
                pair.add(left + right);
                rightSocks.poll();
            }
        }
        pair.stream().max(Integer::compareTo).ifPresent(System.out::println);
        pair.forEach(e -> System.out.print(e + " "));
    }
}
