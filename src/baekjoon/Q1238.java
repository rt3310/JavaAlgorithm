package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1238 {

    private static List<List<int[]>> graph;
    private static int n;
    private static int x;
    private static int time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        graph = new ArrayList<>();

        String[] nmx = br.readLine().split(" ");
        n = Integer.parseInt(nmx[0]);
        int m = Integer.parseInt(nmx[1]);
        x = Integer.parseInt(nmx[2]);
        time = 0;
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int t = Integer.parseInt(input[2]);
            graph.get(a).add(new int[]{b, t});
        }

        for (int i = 1; i <= n; i++) {
            time = Math.max(time, search(i, x) + search(x, i));
        }

        System.out.println(time);
    }
    
    public static int search(int start, int dest) {
        int[] weights = new int[n + 1];
        Arrays.fill(weights, Integer.MAX_VALUE);
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(v -> v[1]));
        pq.offer(new int[]{start, 0});
        weights[start] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            for (int[] next : graph.get(cur[0])) {
                if (weights[next[0]] > cur[1] + next[1]) {
                    pq.offer(new int[]{next[0], cur[1] + next[1]});
                    weights[next[0]] = cur[1] + next[1];
                }
            }
        }

        return weights[dest];
    }
}
