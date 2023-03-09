package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1167 {

    private static List<List<int[]>> tree;
    private static boolean[] visited;
    private static int maxVertex;
    private static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        visited = new boolean[n + 1];
        max = Integer.MIN_VALUE;

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
            }
        }

        visited[1] = true;
        search(1, 0);
        visited[1] = false;
        visited[maxVertex] = true;
        search(maxVertex, 0);

        System.out.println(max);
    }

    public static void search(int cur, int total) {
        if (total > max) {
            max = total;
            maxVertex = cur;
        }

        for (int[] next : tree.get(cur)) {
            if (!visited[next[0]]) {
                visited[next[0]] = true;
                search(next[0], total + next[1]);
                visited[next[0]] = false;
            }
        }
    }
}