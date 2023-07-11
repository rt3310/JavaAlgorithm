package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q22948 {

    private static int[][] circles;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        circles = new int[n + 1][2];
        for (int i = 0; i < n; i++) {
            String[] circle = br.readLine().split(" ");

            int number = Integer.parseInt(circle[0]);
            int x = Integer.parseInt(circle[1]);
            int r = Integer.parseInt(circle[2]);

            circles[number] = new int[]{x, r};
        }

        String[] ab = br.readLine().split(" ");
        int a = Integer.parseInt(ab[0]);
        int b = Integer.parseInt(ab[1]);

        Queue<int[]> startpq = new PriorityQueue<>(Comparator.comparingInt(c -> c[1]));
        startpq.offer(new int[]{a, circles[a][0], circles[a][1]});
        if (Math.abs(circles[a][0] - circles[b][0]) < Math.abs(circles[a][1] - circles[b][1])) {
            startpq.offer(new int[]{b, circles[b][0], circles[b][1]});
        }
        Queue<int[]> endpq = new PriorityQueue<>(Comparator.comparingInt(c -> c[1]));
        endpq.offer(new int[]{b, circles[b][0], circles[b][1]});
        for (int i = 1; i < n; i++) {
            if (i == a) {
                continue;
            }
            if (Math.abs(circles[a][0] - circles[i][0]) < Math.abs(circles[a][1] - circles[i][1])) {
                startpq.offer(new int[]{i, circles[i][0], circles[i][1]});
            }

            if (Math.abs(circles[b][0] - circles[i][0]) < Math.abs(circles[b][1] - circles[i][1])) {
                endpq.offer(new int[]{i, circles[i][0], circles[i][1]});
            }
        }

        List<Integer> results = new ArrayList<>();
        while (!startpq.isEmpty()) {
            int[] circle = startpq.poll();

            int number = circle[0];
            if (number == b) {
                System.out.println(results.size() + 1);
                for (int result : results) {
                    System.out.print(result + " ");
                }
                System.out.println(b);
                return;
            }
            results.add(number);
        }

        int[] endEntry = endpq.poll();
        if (endEntry[0] != results.get(results.size() - 1)) {
            results.add(0);
            results.add(endEntry[0]);
        }

        while (!endpq.isEmpty()) {
            int[] circle = endpq.poll();

            int number = circle[0];
            if (number == b) {
                System.out.println(results.size() + 1);
                for (int result : results) {
                    System.out.print(result + " ");
                }
                System.out.println(b);
                return;
            }
            results.add(number);
        }

        System.out.println(results.size() + 1);
        for (int result : results) {
            System.out.print(result + " ");
        }
    }
}
