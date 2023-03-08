package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q11724 {

    private static int n;
    private static int m;
    private static List<List<Integer>> graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        graph = new ArrayList<>();

        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] v = br.readLine().split(" ");
            int v1 = Integer.parseInt(v[0]);
            int v2 = Integer.parseInt(v[1]);
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }
            count++;
            visited[i] = true;
            search(i);
        }

        System.out.println(count);
    }

    public static void search(int cur) {
        for (int next : graph.get(cur)) {
            if (visited[next]) {
                continue;
            }
            visited[next] = true;
            search(next);
        }
    }
}
