package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q2170 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Queue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(c -> c[0]));
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            pq.offer(new long[]{Long.parseLong(input[0]), Long.parseLong(input[1])});
        }

        long[] poll = pq.poll();
        long start = poll[0];
        long end = poll[1];

        long total = 0;
        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long left = cur[0];
            long right = cur[1];
            if (left <= end) {
                if (right > end) {
                    end = right;
                }
                continue;
            }
            total += end - start;
            start = left;
            end = right;
        }
        total += end - start;

        System.out.println(total);
    }
}
