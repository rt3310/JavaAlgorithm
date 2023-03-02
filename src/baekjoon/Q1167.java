package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1167 {

    private static List<List<int[]>> tree = new ArrayList<>();
    private static int[] weights;
    private static int[] linkCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        weights = new int[n + 1];
        linkCount = new int[n + 1];
        tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            while (true) {
                int vertex2 = Integer.parseInt(st.nextToken());
                if (vertex2 == -1) {
                    break;
                }
                int weight = Integer.parseInt(st.nextToken());
                tree.get(vertex1).add(new int[]{vertex2, weight});
                linkCount[vertex1]++;
                linkCount[vertex2]++;
            }
        }

        search(tree.get(1).get(0));
        System.out.println(Arrays.toString(weights));
    }

    public static void search(int[] start) {
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(c -> -c[1]));
        pq.offer(start);
        weights[start[0]] = start[1];

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int curVertex = poll[0];
            int curWeight = poll[1];

            if (weights[curVertex] > curWeight) {
                continue;
            }

            for (int[] next : tree.get(curVertex)) {
                int nextVertex = next[0];
                int nextWeight = next[1];

                if (weights[nextVertex] < weights[curVertex] + nextWeight) {
                    pq.offer(new int[] {nextVertex, weights[curVertex] + nextWeight});
                    weights[nextVertex] = weights[curVertex] + nextWeight;
                }
            }
        }

    }
}