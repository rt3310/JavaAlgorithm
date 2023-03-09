package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q16236 {

    private static int n;
    private static int[] shark;
    private static int[][] map;
    private static Queue<int[]> pq;
    private static int curSize;
    private static int time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        pq = new PriorityQueue<>((v1, v2) -> {
            if (v1[0] == v2[0]) {
                if (v1[1] == v2[1]) {
                    return v1[2] - v2[2];
                }
                return v1[1] - v2[1];
            }
            return v1[0] - v2[0];
        });
        curSize = 2;
        time = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    map[i][j] = 0;
                    shark = new int[]{i, j};
                }
            }
        }
        int row = shark[0];
        int col = shark[1];
        int start = 0;
        int eatCount = 0;
        while (true) {
            search(new int[]{row, col, 0});

            if (pq.isEmpty()) {
                break;
            }

            int[] poll = pq.poll();
            time += poll[0];
            row = poll[1];
            col = poll[2];
            map[row][col] = 0;
            eatCount++;

            if (eatCount == curSize) {
                curSize++;
                eatCount = 0;
            }
            pq.clear();
        }

        System.out.println(time);
    }

    public static void search(int[] start) {
        boolean[][] visited = new boolean[n][n];
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        Deque<int[]> q = new ArrayDeque<>();
        q.offerLast(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        while (!q.isEmpty()) {
            int[] cur = q.pollFirst();

            for (int[] direction : directions) {
                int row = cur[0] + direction[0];
                int col = cur[1] + direction[1];

                if (row < 0 || row >= n || col < 0 || col >= n) {
                    continue;
                }

                if (visited[row][col]) {
                    continue;
                }

                if (map[row][col] > curSize) {
                    continue;
                }

                if (map[row][col] != 0 && map[row][col] < curSize) {
                    pq.offer(new int[]{cur[2] + 1, row, col});
                }

                visited[row][col] = true;
                q.offerLast(new int[]{row, col, cur[2] + 1});
            }
        }
    }
}
