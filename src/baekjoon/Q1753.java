package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1753 {

    private static int v;
    private static int[] weights;
    private static List<List<int[]>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ve = br.readLine().split(" ");
        v = Integer.parseInt(ve[0]);
        int e = Integer.parseInt(ve[1]);

        weights = new int[v + 1];
        graph = new ArrayList<>();

        int start = Integer.parseInt(br.readLine());

        for (int i = 0; i <= v; i++) {
            weights[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            String[] uvw = br.readLine().split(" ");
            int u = Integer.parseInt(uvw[0]);
            int v = Integer.parseInt(uvw[1]);
            int w = Integer.parseInt(uvw[2]);
            graph.get(u).add(new int[]{v, w});
        }

        search(start);
        printResult();
    }

    private static void printResult() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= v; i++) {
            sb.append(weights[i] == Integer.MAX_VALUE ? "INF" : weights[i]).append("\n");
        }
        System.out.print(sb);
    }

    public static void search(int start) {
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(c -> c[0]));
        pq.offer(new int[]{0, start});
        weights[start] = 0;

        while (!pq.isEmpty()){
            int[] poll = pq.poll();
            int curWeight = poll[0];
            int curVertex = poll[1];

            if (weights[curVertex] < curWeight) {
                continue;
            }

            for (int[] next : graph.get(curVertex)) {
                int nextVertex = next[0];
                int nextWeight = next[1];

                if (weights[nextVertex] > weights[curVertex] + nextWeight) {
                    pq.offer(new int[]{weights[curVertex] + nextWeight, nextVertex});
                    weights[nextVertex] = weights[curVertex] + nextWeight;
                }
            }
        }
    }
}
