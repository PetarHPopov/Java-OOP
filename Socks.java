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

        ArrayDeque<Integer> leftSocksStack = new ArrayDeque<>();
        ArrayDeque<Integer> rightSocksQueue = new ArrayDeque<>();

        Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(leftSocksStack::push);
        Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(rightSocksQueue::offer);

        List<Integer> pair = new ArrayList<>();

        while (!leftSocksStack.isEmpty() && !rightSocksQueue.isEmpty()) {

            int leftSock = leftSocksStack.peek();
            int rightSock = rightSocksQueue.peek();

            if (leftSock > rightSock) {
                pair.add(rightSock + leftSock);
                leftSocksStack.pop();
                rightSocksQueue.poll();
            } else if (leftSock < rightSock) {
                leftSocksStack.pop();
            } else {
                rightSocksQueue.poll();
                int current = leftSocksStack.pop();
                leftSocksStack.push(current + 1);
            }
        }
         pair.stream().max(Integer::compareTo).ifPresent(System.out::println);
        for (Integer sock : pair) {
            System.out.print(sock + " ");
        }
    }
}
