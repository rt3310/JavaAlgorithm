package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q16928 {

    private static int n;
    private static int m;
    private static Map<Integer, Integer> ladders;
    private static Map<Integer, Integer> snakes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        ladders = new HashMap<>();
        snakes = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            ladders.put(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        }

        for (int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            snakes.put(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        }

        search(1);
    }

    public static void search(int start) {
        int[] visited = new int[101];
        for (int i = 0; i < 101; i++) {
            visited[i] = Integer.MAX_VALUE;
        }
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offerLast(new int[]{start, 0});
        visited[start] = 0;

        while (!dq.isEmpty()) {
            int[] cur = dq.poll();

            for (int i = 1; i <= 6; i++) {
                if (cur[0] + i > 100) {
                    continue;
                }

                if (visited[cur[0] + i] <= cur[1] + 1) {
                    continue;
                }

                Integer snake = snakes.get(cur[0] + i);
                if (snake != null) {
                    if (visited[snake] <= cur[1] + 1) {
                        continue;
                    }
                    visited[snake] = cur[1] + 1;
                    dq.offerLast(new int[]{snake, cur[1] + 1});
                    continue;
                }

                Integer ladder = ladders.get(cur[0] + i);
                if (ladder != null) {
                    if (visited[ladder] <= cur[1] + 1) {
                        continue;
                    }
                    visited[ladder] = cur[1] + 1;
                    dq.offerLast(new int[]{ladder, cur[1] + 1});
                    continue;
                }

                visited[cur[0] + i] = cur[1] + 1;
                dq.offerLast(new int[]{cur[0] + i, cur[1] + 1});
            }
        }

        System.out.println(visited[100]);
    }
}
