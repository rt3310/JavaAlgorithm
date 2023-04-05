package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q2458 {

    private static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        graph = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            graph[a][b] = 1;
        }

        for (int mid = 1; mid <= n; mid++) {
            for (int start = 1; start <= n; start++) {
                for (int end = 1; end <= n; end++) {
                    if (start == end) {
                        continue;
                    }
                    if (graph[start][mid] != 0 && graph[mid][end] != 0) {
                        graph[start][end] = Math.max(graph[start][end], graph[start][mid] + graph[mid][end]);
                    }
                }
            }
        }

        int[] counts = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] > 0 || graph[j][i] > 0) {
                    counts[i]++;
                }
            }
        }

        int answer = 0;
        for (int count : counts) {
            if (count == n - 1) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
