package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Q2638 {
    private static int h;
    private static int w;
    private static String[][] cheeses;
    private static int[][] visited;
    private static int time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] hw = br.readLine().split(" ");
        h = Integer.parseInt(hw[0]);
        w = Integer.parseInt(hw[1]);
        time = 0;

        cheeses = new String[h][w];
        visited = new int[h][w];

        for (int i = 0; i < h; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < w; j++) {
                if (row[j].equals("1")) {
                    visited[i][j] = 5;
                }
                cheeses[i][j] = row[j];
            }
        }

        do {
            time++;
        } while (search(new int[]{0, 0}) > 0);

        System.out.println(time);
    }

    public static int search(int[] start) {
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offerLast(start);
        visited[start[0]][start[1]] = 6;

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();

            for (int[] direction : directions) {
                int row = cur[0] + direction[0];
                int col = cur[1] + direction[1];

                if (row < 0 || row >= h || col < 0 || col >= w) {
                    continue;
                }

                if (visited[row][col] == 6 || (visited[row][col] <= 3 && visited[row][col] != 0)) {
                    continue;
                }

                if (visited[row][col] >= 4) {
                    visited[row][col]--;
                    continue;
                }

                visited[row][col] = 6;
                dq.offerLast(new int[]{row, col});
            }
        }
        return copyCheeses();
    }

    public static int copyCheeses() {
        int nextCheeses = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (visited[i][j] == 0 || visited[i][j] == 6) {
                    visited[i][j] = 0;
                    continue;
                }

                if (visited[i][j] <= 3) {
                    cheeses[i][j] = "0";
                    visited[i][j] = 0;
                    continue;
                }

                if (visited[i][j] >= 4) {
                    nextCheeses++;
                    visited[i][j] = 5;
                    continue;
                }

                visited[i][j] = 0;
            }
        }

        return nextCheeses;
    }
}
