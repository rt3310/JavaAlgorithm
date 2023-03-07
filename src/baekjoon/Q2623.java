package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q2623 {

    private static int n;
    private static int m;
    private static List<List<Integer>> graph;
    private static boolean[] visited;
    private static Stack<Integer> result;
    private static boolean isCycle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        graph = new ArrayList<>();
        result = new Stack<>();

        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int c = Integer.parseInt(input[0]);
            for (int j = 1; j < c; j++) {
                graph.get(Integer.parseInt(input[j])).add(Integer.parseInt(input[j + 1]));
            }
        }

        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }
            search(i);
        }

        while (!result.isEmpty()) {
            sb.append(result.pop()).append("\n");
        }
        System.out.print(sb);
    }
    public static void search(int cur) {
        visited[cur] = true;

        for (int next : graph.get(cur)) {
            if (visited[next]) {
                continue;
            }
            search(next);
        }

        result.push(cur);
    }
}
