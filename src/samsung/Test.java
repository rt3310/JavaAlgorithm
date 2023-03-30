package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Test {

    private static BufferedReader br;
    private static StringBuilder sb;
    private static int[][] directions;
    private static int x1, x2, y1, y2;
    private static int lr, hr, lc, hc;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            sb.append("#").append(i).append(" ");
            testcase();
        }

        System.out.print(sb);
    }

    private static void testcase() throws IOException {
        String[] xy = br.readLine().split(" ");
        x1 = Integer.parseInt(xy[0]) + 200;
        y1 = Integer.parseInt(xy[1]) + 200;
        x2 = Integer.parseInt(xy[2]) + 200;
        y2 = Integer.parseInt(xy[3]) + 200;

        if (y1 > y2) {
            hr = y1;
            lr = y2;
        } else {
            hr = y2;
            lr = y1;
        }

        if (x1 > x2) {
            hc = x1;
            lc = x2;
        } else {
            hc = x2;
            lc = x1;
        }

        sb.append(Math.min(search(new int[]{y1, x1}, 0), search(new int[]{y1, x1}, 1))).append("\n");
    }

    private static int search(int[] start, int startDirect) {
        int[][] map = new int[401][401];
        for (int i = 0; i < 401; i++) {
            Arrays.fill(map[i], Integer.MAX_VALUE);
        }
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(v -> v[1]));
        pq.offer(new int[]{start[0], start[1], 0, startDirect}); // [2] weight, [3] 0 가로, 1 세로
        map[start[0]][start[1]] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curWeight = cur[2];
            int curDirect = cur[3];

            for (int i = curDirect; i < 4; i += 2) {
                int row = cur[0] + directions[i][0];
                int col = cur[1] + directions[i][1];

                if (row < lr - 1 || row > hr + 1 || col < lc - 1 || col > hc + 1) {
                    continue;
                }

                if (curWeight + 1 < map[row][col]) {
                    pq.offer(new int[]{row, col, curWeight + 1, (curDirect + 1) % 2});
                    map[row][col] = curWeight + 1;
                }
            }
        }
        return map[y2][x2];
    }
}