package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14500 {

    private static int n;
    private static int m;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[][] directions;
    private static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        map = new int[n][m];
        visited = new boolean[n][m];
        max = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                search(new int[]{i, j}, 1, map[i][j]);
                visited[i][j] = false;
            }
        }

        for (int i = 0; i < n; i++) {
            int total = 0;
            for (int j = 0; j < 3; j++) {
                total += map[i][j];
            }
            for (int j = 1; j < m - 1; j++) {
                if (i > 0) {
                    max = Math.max(max, total + map[i - 1][j]);
                }
                if (i < n - 1) {
                    max = Math.max(max, total + map[i + 1][j]);
                }
                if (j == m - 2) {
                    break;
                }
                total -= map[i][j - 1];
                total += map[i][j + 2];
            }
        }

        for (int i = 0; i < m; i++) {
            int total = 0;
            for (int j = 0; j < 3; j++) {
                total += map[j][i];
            }
            for (int j = 1; j < n - 1; j++) {
                if (i > 0) {
                    max = Math.max(max, total + map[j][i - 1]);
                }
                if (i < m - 1) {
                    max = Math.max(max, total + map[j][i + 1]);
                }
                if (j == n - 2) {
                    break;
                }
                total -= map[j - 1][i];
                total += map[j + 2][i];
            }
        }

        System.out.println(max);
    }

    public static void search(int[] cur, int depth, int total) {
        if (depth == 4) {
            max = Math.max(max, total);
            return;
        }

        for (int[] direction : directions) {
            int row = cur[0] + direction[0];
            int col = cur[1] + direction[1];

            if (row < 0 || row >= n || col < 0 || col >= m) {
                continue;
            }

            if (visited[row][col]) {
                continue;
            }

            visited[row][col] = true;
            search(new int[]{row, col}, depth + 1, total + map[row][col]);
            visited[row][col] = false;
        }
    }
}
