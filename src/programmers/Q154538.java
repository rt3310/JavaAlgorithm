package programmers;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q154538 {

    public static void main(String[] args) {

    }

    public int solution(int x, int y, int n) {
        return search(x, y, n);
    }

    public static int search(int x, int y, int n) {
        Deque<int[]> dq = new ArrayDeque<>();
        boolean[] visited = new boolean[y + 1];

        if (x == y) {
            return 0;
        }

        dq.offerLast(new int[]{x, 0});
        visited[x] = true;

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int number = cur[0];
            int count = cur[1];

            if (number + n <= y && !visited[number + n]) {
                if (number + n == y) {
                    return count + 1;
                }
                visited[number + n] = true;
                dq.offerLast(new int[]{number + n, count + 1});
            }

            if (number * 2 <= y && !visited[number * 2]) {
                if (number * 2 == y) {
                    return count + 1;
                }
                visited[number * 2] = true;
                dq.offerLast(new int[]{number * 2, count + 1});
            }

            if (number * 3 <= y && !visited[number * 3]) {
                if (number * 3 == y) {
                    return count + 1;
                }
                visited[number * 3] = true;
                dq.offerLast(new int[]{number * 3, count + 1});
            }
        }

        return -1;
    }
}
