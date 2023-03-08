package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11403 {

    private static int n;
    private static int[][] graph;
    private static boolean[] visited;
    private static int[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        result = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            visited[i] = true;
            search(i, i);
            visited[i] = false;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    public static void search(int cur, int start) {
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            if (graph[cur][i] == 0) {
                continue;
            }

            visited[i] = true;
            result[start][i] = 1;
            search(i, start);
            visited[i] = false;
        }
    }
}
