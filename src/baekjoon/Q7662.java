package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q7662 {
    private static BufferedReader br;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            testCase();
        }

        System.out.print(sb);
    }

    public static void testCase() throws IOException {
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> minpq = new PriorityQueue<>(Comparator.comparingInt(v -> v));
        Queue<Integer> maxpq = new PriorityQueue<>((v1, v2) -> -(v1.compareTo(v2)));
        Map<Integer, Integer> counts = new HashMap<>();

        int count = 0;
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            String command = input[0];
            int x = Integer.parseInt(input[1]);

            if (command.equals("I")) {
                minpq.offer(x);
                maxpq.offer(x);
                counts.put(x, counts.getOrDefault(x, 0) + 1);
                count++;
                continue;
            }

            if (count == 0) {
                maxpq.clear();
                minpq.clear();
                counts.clear();
                continue;
            }

            if (x == 1) {
                while (!maxpq.isEmpty()) {
                    int maxValue = maxpq.poll();
                    if (counts.getOrDefault(maxValue, 0) > 0) {
                        counts.put(maxValue, counts.get(maxValue) - 1);
                        count--;
                        if (count == 0) {
                            maxpq.clear();
                            minpq.clear();
                            counts.clear();
                        }
                        break;
                    }
                }
                continue;
            }

            while (!minpq.isEmpty()) {
                int minValue = minpq.poll();
                if (counts.getOrDefault(minValue, 0) > 0) {
                    counts.put(minValue, counts.get(minValue) - 1);
                    count--;
                    if (count == 0) {
                        maxpq.clear();
                        minpq.clear();
                        counts.clear();
                    }
                    break;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > 0) {
                int key = entry.getKey();
                max = Math.max(max, key);
                min = Math.min(min, key);
            }
        }

        if (count == 0) {
            sb.append("EMPTY").append("\n");
            return;
        }

        sb.append(max).append(" ").append(min).append("\n");
    }
}
