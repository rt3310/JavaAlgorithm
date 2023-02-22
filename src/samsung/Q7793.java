package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q7793 {

    private static BufferedReader br;
    private static StringBuilder sb;
    private static int n;
    private static int m;
    private static String[][] map;
    private static boolean[][] visited;
    private static int[] dest;
    private static int[] start;
    private static List<int[]> devils;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            sb.append("#").append(i).append(" ");
            testCase();
        }
        System.out.print(sb);
    }

    public static void testCase() throws IOException {
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        map = new String[n][m];
        visited = new boolean[n][m];
        devils = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                String str = map[i][j];
                if (str.equals("D")) {
                    dest = new int[]{i, j};
                    continue;
                }

                if (str.equals("S")) {
                    start = new int[]{i, j};
                    map[i][j] = ".";
                    continue;
                }

                if (str.equals("*")) {
                    devils.add(new int[]{i, j});
                }
            }
        }

        search();
    }

    public static void search() {
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offerLast(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        int count = -1;
        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();

            if (cur[2] > count) {
                spreadDevils();
                count = cur[2];
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

                if (row == dest[0] && col == dest[1]) {
                    sb.append(cur[2] + 1).append("\n");
                    return;
                }

                if (map[row][col].equals(".")) {
                    visited[row][col] = true;
                    dq.offerLast(new int[]{row, col, cur[2] + 1});
                }
            }
        }
        sb.append("GAME OVER").append("\n");
    }

    public static void spreadDevils() {
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        List<int[]> nextDevils = new ArrayList<>();

        for (int[] devil : devils) {
            for (int[] direction : directions) {
                int row = devil[0] + direction[0];
                int col = devil[1] + direction[1];

                if (row < 0 || row >= n || col < 0 || col >= m) {
                    continue;
                }

                if (map[row][col].equals(".")) {
                    map[row][col] = "*";
                    nextDevils.add(new int[]{row, col});
                }
            }
        }

        devils = nextDevils;
    }
}
