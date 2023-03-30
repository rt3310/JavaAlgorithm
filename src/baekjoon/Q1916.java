package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1916 {

    private static int n;
    private static List<List<int[]>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);
            graph.get(s).add(new int[]{e, cost});
        }
        String[] inter = br.readLine().split(" ");
        int start = Integer.parseInt(inter[0]);
        int dest = Integer.parseInt(inter[1]);

        System.out.println(search(start, dest));
    }

    public static int search(int start, int dest) {
        int[] weights = new int[n + 1];
        Arrays.fill(weights, Integer.MAX_VALUE);
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(v -> v[1]));
        pq.offer(new int[]{start, 0});
        weights[start] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (cur[1] > weights[cur[0]]) {
                continue;
            }

            for (int[] next : graph.get(cur[0])) {
                int nextNode = next[0];
                int nextWeight = next[1];

                if (weights[nextNode] > cur[1] + nextWeight) {
                    weights[nextNode] = cur[1] + nextWeight;
                    pq.offer(new int[]{nextNode, cur[1] + nextWeight});
                }
            }
        }

        return weights[dest];
    }
}
