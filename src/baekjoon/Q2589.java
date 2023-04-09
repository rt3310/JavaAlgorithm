package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Q2589 {

    private static int r;
    private static int c;
    private static String[][] map;
    private static int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static int maxDistance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] rc = br.readLine().split(" ");
        r = Integer.parseInt(rc[0]);
        c = Integer.parseInt(rc[1]);
        map = new String[r][c];
        maxDistance = 0;

        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().split("");
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j].equals("W")) {
                    continue;
                }

                maxDistance = Math.max(maxDistance, search(new int[]{i, j, 0}));
            }
        }

        System.out.println(maxDistance);
    }

    public static int search(int[] start) {
        Deque<int[]> dq = new ArrayDeque<>();
        boolean[][] visited = new boolean[r][c];
        dq.offerLast(start);
        visited[start[0]][start[1]] = true;

        int maxDistance = 0;
        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            maxDistance = Math.max(maxDistance, cur[2]);

            for (int[] direction : directions) {
                int row = cur[0] + direction[0];
                int col = cur[1] + direction[1];

                if (row < 0 || row >= r || col < 0 || col >= c) {
                    continue;
                }

                if (map[row][col].equals("W")) {
                    continue;
                }

                if (visited[row][col]) {
                    continue;
                }

                visited[row][col] = true;
                dq.offerLast(new int[]{row, col, cur[2] + 1});
            }
        }
        return maxDistance;
    }
}
