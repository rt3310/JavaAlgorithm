package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q1012 {
    private static BufferedReader br;
    private static StringBuilder sb;
    private static int t;
    private static int m;
    private static int n;
    private static int[][] map;
    private static int[][] directions;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            testCase();
        }

        System.out.print(sb);
    }

    public static void testCase() throws IOException {
        String[] mnk = br.readLine().split(" ");
        m = Integer.parseInt(mnk[0]);
        n = Integer.parseInt(mnk[1]);
        int k = Integer.parseInt(mnk[2]);
        map = new int[n][m];

        for (int i = 0; i < k; i++) {
            String[] pos = br.readLine().split(" ");
            int x = Integer.parseInt(pos[0]);
            int y = Integer.parseInt(pos[1]);
            map[y][x] = 1;
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    continue;
                }
                count++;
                map[i][j] = 0;
                search(new int[]{i, j});
            }
        }

        sb.append(count).append("\n");
    }

    public static void search(int[] cur) {
        for (int[] direction : directions) {
            int row = cur[0] + direction[0];
            int col = cur[1] + direction[1];

            if (row < 0 || row >= n || col < 0 || col >= m) {
                continue;
            }

            if (map[row][col] == 0) {
                continue;
            }

            map[row][col] = 0;
            search(new int[]{row, col});
        }
    }
}
