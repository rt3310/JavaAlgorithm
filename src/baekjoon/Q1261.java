package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q1261 {

    private static int n;
    private static int m;
    private static int[][] map;
    private static int[][] count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        map = new int[m][n];
        count = new int[m][n];

        for (int i = 0; i < m; i++) {
            String[] row = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(row[j]);
                count[i][j] = Integer.MAX_VALUE;
            }
        }

        search();
        System.out.println(count[m - 1][n - 1] == Integer.MAX_VALUE ? 0 : count[m - 1][n - 1]);
    }

    public static void search() {
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(v -> v[2]));
        pq.offer(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curRow = cur[0];
            int curCol = cur[1];
            int curCount = cur[2];

            if (curCount > count[curRow][curCol]) {
                continue;
            }

            for (int[] direction : directions) {
                int row = curRow + direction[0];
                int col = curCol + direction[1];

                if (row < 0 || row >= m || col < 0 || col >= n) {
                    continue;
                }

                if (count[row][col] > map[row][col] + curCount) {
                    count[row][col] = map[row][col] + curCount;
                    pq.offer(new int[]{row, col, map[row][col] + curCount});
                }
            }
        }
    }
}
