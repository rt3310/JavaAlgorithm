package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q13334 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<int[]> pq = new PriorityQueue<>((v1, v2) -> {
            if (v1[1] == v2[1]) {
                return v2[0] - v1[0];
            }
            return v1[1] - v2[1];
        });

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            if (a < b) {
                pq.offer(new int[]{a, b});
                continue;
            }
            pq.offer(new int[]{b, a});
        }
        int size = Integer.parseInt(br.readLine());

        int start = -100_000_001;
        int end = -100_000_001;
        int count = 0;
        int maxCount = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curLeft = cur[0];
            int curRight = cur[1];

            if (curRight - curLeft > size) {
                continue;
            }

            if (curRight <= end) {
                System.out.println("start, end = " + start + ", " + end);
                System.out.println("curLeft, curRight = " + curLeft + ", " + curRight);
                System.out.println("count = " + count);
                if (curLeft < start) {
                    start = curLeft;
                }
                count++;
                maxCount = Math.max(maxCount, count);
                continue;
            }

            if (curRight - start <= size) {
                System.out.println("start, end = " + start + ", " + end);
                System.out.println("curLeft, curRight = " + curLeft + ", " + curRight);
                System.out.println("count = " + count);
                count++;
                end = curRight;
            } else {
                count = 1;
                end = curRight;
                start = curLeft;
            }
            maxCount = Math.max(maxCount, count);
        }

        System.out.println(maxCount);
    }
}
