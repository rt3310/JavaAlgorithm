package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q1949 {
    
    private static BufferedReader br;
    private static int n;
    private static int k;
    private static int[][] map;
    private static boolean[][] visited;
    private static int maxHeight;
    private static List<int[]> maxHeights;
    private static int maxDistance;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            sb.append("#").append(i);
            testCase();
        }

        System.out.print(sb);
    }
    
    public static void testCase() throws IOException {
        String[] nk = br.readLine().split(" ");
        n = Integer.parseInt(nk[0]);
        k = Integer.parseInt(nk[1]);
        map = new int[n][n];
        visited = new boolean[n][n];
        maxHeight = 0;
        maxHeights = new ArrayList<>();
        maxDistance = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == maxHeight) {
                    maxHeights.add(new int[]{i, j});
                }
            }
        }

        for (int[] top : maxHeights) {
            visited[top[0]][top[1]] = true;
            search(top, 1, false, false, 0);
            visited[top[0]][top[1]] = false;
        }

        sb.append(" ").append(maxDistance).append("\n");
    }

    public static void search(int[] cur, int distance, boolean isCut, boolean isHere, int cutHeight) {
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        boolean isSeek = false;
        for (int[] direction : directions) {
            int row = cur[0] + direction[0];
            int col = cur[1] + direction[1];

            if (row < 0 || row >= n || col < 0 || col >= n) {
                continue;
            }

            if (visited[row][col]) {
                continue;
            }

            for (int i = 1; i <= k; i++) {
                if (!isCut && map[row][col] - i < map[cur[0]][cur[1]]) {
                    isSeek = true;
                    visited[row][col] = true;
                    search(new int[]{row, col}, distance + 1, true, true, i);
                    visited[row][col] = false;
                }
            }

            if (map[row][col] >= map[cur[0]][cur[1]]) {
                continue;
            }

            if (isHere && map[row][col] >= map[cur[0]][cur[1]] - cutHeight) {
                continue;
            }

            isSeek = true;
            visited[row][col] = true;
            search(new int[]{row, col}, distance + 1, isCut, false, 0);
            visited[row][col] = false;
        }

        if (!isSeek) {
            maxDistance = Math.max(maxDistance, distance);
        }
    }
}
