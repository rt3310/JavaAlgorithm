package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Q2606 {

    private static int n;
    private static int v;
    private static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        v = Integer.parseInt(br.readLine());
        graph = new int[n + 1][n + 1];
        boolean[] visited = new boolean[n + 1];

        for (int i = 0; i < v; i++) {
            String[] input = br.readLine().split(" ");
            int first = Integer.parseInt(input[0]);
            int second = Integer.parseInt(input[1]);
            graph[first][second] = 1;
            graph[second][first] = 1;
        }

        search(visited);
    }

    public static void search(boolean[] visited) {
        Deque<Integer> q = new ArrayDeque<>();
        q.offerLast(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int cur = q.pollFirst();

            for (int i = 1; i <= n; i++) {
                if (i == cur) {
                    continue;
                }

                if (visited[i]) {
                    continue;
                }

                if (graph[cur][i] == 0) {
                    continue;
                }

                visited[i] = true;
                q.offerLast(i);
            }
        }

        int count = 0;
        for (boolean v : visited) {
            if (v) {
                count++;
            }
        }

        System.out.println(count - 1);
    }
}
