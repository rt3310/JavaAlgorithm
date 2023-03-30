package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17070 {

    private static int n;
    private static int[][] map;
    private static int[][] directions = {{0, 1}, {1, 1}, {1, 0}};
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        count = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        search(0, 1, 0);
        System.out.println(count);
    }

    // 0 가로, 1 대각선, 2 세로
    public static void search(int curRow, int curCol, int prevDirect) {
        if (curRow == n - 1 && curCol == n - 1) {
            count++;
            return;
        }

        if (prevDirect == 0) {
            for (int i = 0; i < 2; i++) {
                int row = curRow + directions[i][0];
                int col = curCol + directions[i][1];

                if (isOutOfIndex(row, col)) {
                    continue;
                }

                if (map[row][col] == 1) {
                    continue;
                }

                if (i == 1 && (map[row][col] == 1 || map[row - 1][col] == 1 || map[row][col - 1] == 1)) {
                    continue;
                }
                search(row, col, i);
            }
            return;
        }

        if (prevDirect == 1) {
            for (int i = 0; i < 3; i++) {
                int row = curRow + directions[i][0];
                int col = curCol + directions[i][1];

                if (isOutOfIndex(row, col)) {
                    continue;
                }

                if (map[row][col] == 1) {
                    continue;
                }

                if (i == 1 && (map[row][col] == 1 || map[row - 1][col] == 1 || map[row][col - 1] == 1)) {
                    continue;
                }
                search(row, col, i);
            }
            return;
        }

        if (prevDirect == 2) {
            for (int i = 1; i < 3; i++) {
                int row = curRow + directions[i][0];
                int col = curCol + directions[i][1];

                if (isOutOfIndex(row, col)) {
                    continue;
                }

                if (map[row][col] == 1) {
                    continue;
                }

                if (i == 1 && (map[row][col] == 1 || map[row - 1][col] == 1 || map[row][col - 1] == 1)) {
                    continue;
                }
                search(row, col, i);
            }
            return;
        }
    }

    public static boolean isOutOfIndex(int row, int col) {
        return row < 0 || row >= n || col < 0 || col >= n;
    }
}
