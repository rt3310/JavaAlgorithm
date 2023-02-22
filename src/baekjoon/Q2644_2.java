package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q2644_2 {

    private static int N, M, a, b;
    private static List<List<Integer>> graph;
    private static boolean[] visited;
    private static int chon = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        graph = new ArrayList<>();

        graph.add(new ArrayList<>());
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            graph.get(child).add(parent);
            graph.get(parent).add(child);
        }

        search(a, 0);
        System.out.println(chon);
    }

    public static void search(int cur, int count) {
        if (cur == b) {
            chon = count;
            return;
        }

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
