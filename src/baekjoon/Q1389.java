package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1389 {

    private static int n;
    private static int m;
    private static List<List<Integer>> graph;
    private static boolean[] visited;
    private static int total;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<int[]> pq = new PriorityQueue<>((v1, v2) -> {
            if (v1[1] == v2[1]) {
                return v1[0] - v2[0];
            }
            return v1[1] - v2[1];
        });

        graph = new ArrayList<>();

        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 1; i <= n; i++) {
            total = 0;
            visited[i] = true;
            search(i, 0);
            visited[i] = false;
            pq.offer(new int[]{i, total});
        }

        System.out.println(pq.poll()[0]);
    }

    public static void search(int cur, int count) {
        total += count;
        for (int next : graph.get(cur)) {
            if (visited[next]) {
                continue;
            }
            visited[next] = true;
            search(next, count + 1);
            visited[next] = false;
        }
    }
}
