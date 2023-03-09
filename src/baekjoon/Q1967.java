package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q1967 {

    private static List<List<int[]>> tree = new ArrayList<>();
    private static boolean[] visited;
    private static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        visited = new boolean[n + 1];

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            tree.get(vertex1).add(new int[]{vertex2, weight});
            tree.get(vertex2).add(new int[]{vertex1, weight});
        }

        for (int i = 1; i <= n; i++) {
            visited[i] = true;
            search(i, 0);
            visited[i] = false;
        }

        System.out.println(max);
    }

    public static void search(int cur, int total) {

        boolean notExist = true;
        for (int[] next : tree.get(cur)) {
            int nextVertex = next[0];
            int weight = next[1];

            if (visited[nextVertex]) {
                continue;
            }

            notExist = false;
            visited[nextVertex] = true;
            search(nextVertex, total + weight);
            visited[nextVertex] = false;
        }

        if (notExist) {
            max = Math.max(max, total);
        }
    }
}