package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10971 {

    private static int n;
    private static String[][] map;
    private static int minCost = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new String[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().split(" ");
        }

        int[] visited = new int[n];

        search(visited, 0);
        System.out.println(minCost);
    }

    public static void search(int[] visited, int count) {
        if (count == n) {
            calcCost(visited);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                visited[i] = count + 1;
                search(visited, count + 1);
                visited[i] = 0;
            }
        }
    }

    public static void calcCost(int[] visited) {
        int[] path = new int[n];
        for (int i = 0; i < n; i++) {
            path[visited[i] - 1] = i;
        }

        int total = 0;
        for (int i = 0; i < n; i++) {
            int cost = Integer.parseInt(map[path[i]][path[(i+1) % n]]);

            if (cost == 0) {
                return;
            }
            total += cost;
        }

        minCost = Math.min(minCost, total);
    }
}
