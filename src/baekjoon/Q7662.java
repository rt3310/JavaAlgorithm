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
        Map<Long, Integer> counts = new HashMap<>();
        Queue<Long> minpq = new PriorityQueue<>(Comparator.comparingLong(v -> v));
        Queue<Long> maxpq = new PriorityQueue<>(Comparator.comparingLong(v -> -v));

        int n = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            String command = input[0];
            long x = Long.parseLong(input[1]);
            if (command.equals("I")) {
                minpq.offer(x);
                maxpq.offer(x);
                counts.put(x, counts.getOrDefault(x, 0) + 1);
                count++;
                continue;
            }

            if (count == 0) {
                minpq.clear();
                maxpq.clear();
                counts.clear();
                continue;
            }

            if (x == -1) {
                while (!minpq.isEmpty()) {
                    long minValue = minpq.poll();
                    if (counts.getOrDefault(minValue, 0) > 0) {
                        counts.put(minValue, counts.get(minValue) - 1);
                        count--;
                        if (count == 0) {
                            minpq.clear();
                            maxpq.clear();
                            counts.clear();
                            continue;
                        }
                        break;
                    }
                }
                continue;
            }

            while (!maxpq.isEmpty()) {
                long maxValue = maxpq.poll();
                if (counts.getOrDefault(maxValue, 0) > 0) {
                    counts.put(maxValue, counts.get(maxValue) - 1);
                    count--;
                    if (count == 0) {
                        minpq.clear();
                        maxpq.clear();
                        counts.clear();
                        continue;
                    }
                    break;
                }
            }
        }

        long max = 0;
        long min = Long.MAX_VALUE;
        boolean isEmpty = true;
        for (Map.Entry<Long, Integer> v : counts.entrySet()) {
            if (v.getValue() > 0) {
                isEmpty = false;
                long key = v.getKey();
                max = Math.max(max, key);
                min = Math.min(min, key);
            }
        }

        if (isEmpty) {
            sb.append("EMPTY\n");
            return;
        }

        sb.append(max).append(" ").append(min).append("\n");
    }
}