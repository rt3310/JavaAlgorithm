package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q16724 {

    private static String[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        map = new String[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().split("");
        }

        int total = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j]) {
                    continue;
                }
                visited[i][j] = true;
                search(new int[]{i, j});
                total++;
            }
        }

        System.out.println(total);
    }

    public static void search(int[] cur) {
        int r = cur[0];
        int c = cur[1];
        if (map[r][c].equals("U") && !visited[r - 1][c]) {
            visited[r - 1][c] = true;
            search(new int[]{r - 1, c});
            return;
        }
        if (map[r][c].equals("D") && !visited[r + 1][c]) {
            visited[r + 1][c] = true;
            search(new int[]{r + 1, c});
            return;
        }
        if (map[r][c].equals("L") && !visited[r][c - 1]) {
            visited[r][c - 1] = true;
            search(new int[]{r, c - 1});
            return;
        }
        if (map[r][c].equals("R") && !visited[r][c + 1]) {
            visited[r][c + 1] = true;
            search(new int[]{r, c + 1});
            return;
        }
    }
}
