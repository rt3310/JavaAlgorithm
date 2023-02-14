package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Q2206 {

    private static int n;
    private static int m;
    private static int[][] map;
    private static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        map = new int[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(row[j]);
                visited[i][j] = Integer.MAX_VALUE;
            }
        }

        search();
    }

    public static void search() {
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offerLast(new int[]{0, 0, 1, 0});
        visited[0][0] = 0;


        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();

            if (cur[0] == n - 1 && cur[1] == m - 1) {
                System.out.println(cur[2]);
                return;
            }

            for (int[] direction : directions) {
                int row = cur[0] + direction[0];
                int col = cur[1] + direction[1];

                if (row < 0 || row >= n || col < 0 || col >= m) {
                    continue;
                }

                if (visited[row][col] <= cur[3]) {
                    continue;
                }

                if (map[row][col] == 0) {
                    dq.offerLast(new int[]{row, col, cur[2] + 1, cur[3]});
                    visited[row][col] = cur[3];
                    continue;
                }

                if (cur[3] == 0) {
                    dq.offerLast(new int[]{row, col, cur[2] + 1, cur[3] + 1});
                    visited[row][col] = cur[3] + 1;
                }
            }
        }
        System.out.println(-1);
    }
}
