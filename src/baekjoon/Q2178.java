package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Q2178 {

    private static String[][] map;
    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");

        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        map = new String[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().split("");
        }

        search();
    }

    public static void search() {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Deque<int[]> q = new ArrayDeque<>();
        q.offerLast(new int[]{0, 0});
        map[0][0] = "2";

        while (!q.isEmpty()) {
            int[] cur = q.pollFirst();

            for (int[] direction : directions) {
                int row = cur[0] + direction[0];
                int col = cur[1] + direction[1];

                if (row < 0 || row >= n || col < 0 || col >= m) {
                    continue;
                }

                if (!map[row][col].equals("1")) {
                    continue;
                }

                map[row][col] = String.valueOf(Integer.parseInt(map[cur[0]][cur[1]]) + 1);

                if (row == n - 1 && col == m - 1) {
                    System.out.println(Integer.parseInt(map[row][col]) - 1);
                    return;
                }

                q.offerLast(new int[]{row, col});
            }
        }
    }
}
