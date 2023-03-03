package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q4485 {

    private static BufferedReader br;
    private static StringBuilder sb;
    private static int n;
    private static int[][] map;
    private static int[][] weights;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int count = 1;
        while (true) {
            int i = Integer.parseInt(br.readLine());
            if (i == 0) {
                break;
            }
            n = i;
            sb.append("Problem ").append(count++).append(": ");
            testCase();
        }
        System.out.print(sb);
    }

    public static void testCase() throws IOException {
        map = new int[n][n];
        weights = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                weights[i][j] = Integer.MAX_VALUE;
            }
        }
        sb.append(search()).append("\n");
    }

    public static int search() {
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(c -> c[2]));
        pq.offer(new int[]{0, 0, map[0][0]});
        weights[0][0] = map[0][0];

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (weights[cur[0]][cur[1]] < cur[2]) {
                continue;
            }

            for (int[] direction : directions) {
                int row = cur[0] + direction[0];
                int col = cur[1] + direction[1];

                if (row < 0 || row >= n || col < 0 || col >= n) {
                    continue;
                }

                int nextWeight = map[row][col];
                if (weights[row][col] > weights[cur[0]][cur[1]] + nextWeight) {
                    pq.offer(new int[]{row, col, weights[cur[0]][cur[1]] + nextWeight});
                    weights[row][col] = weights[cur[0]][cur[1]] + nextWeight;
                }
            }
        }
        return weights[n - 1][n - 1];
    }
}
