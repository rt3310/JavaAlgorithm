package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] times = new int[n][2];
        Queue<Integer> stands = new PriorityQueue<>(List.of(0));

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            times[i] = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        }

        Arrays.sort(times, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        for (int i = 0; i < n; i++) {
            Queue<Integer> pq = new PriorityQueue<>();
            boolean isExist = false;

            while (!stands.isEmpty()) {
                int stand = stands.poll();

                if (times[i][0] >= stand) {
                    isExist = true;
                    pq.offer(-stand);
                    continue;
                }

                stands.offer(stand);
                break;
            }

            if (isExist) {
                pq.poll();
            }

            while (!pq.isEmpty()) {
                stands.offer(-pq.poll());
            }

            stands.offer(times[i][1]);
        }

        System.out.println(stands.size());
    }
}
