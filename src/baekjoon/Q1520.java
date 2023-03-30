package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1520 {

    private static int m;
    private static int n;
    private static int[][] map;
    private static int[][] directions;
    private static int[][] counts;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] mn = br.readLine().split(" ");
        m = Integer.parseInt(mn[0]);
        n = Integer.parseInt(mn[1]);
        map = new int[m][n];
        directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        counts = new int[m][n];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        search(0, 0, 1);

        for (int[] r : counts) {
            for (int v : r) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

    public static void search(int curRow, int curCol, int prevCount) {
        if (counts[curRow][curCol] != 0) {
            counts[curRow][curCol] += prevCount;
            return;
        }

        counts[curRow][curCol] += prevCount;
        int curHeight = map[curRow][curCol];
        for (int[] direction : directions) {
            int row = curRow + direction[0];
            int col = curCol + direction[1];

            if (row < 0 || row >= m || col < 0 || col >= n) {
                continue;
            }

            if (map[row][col] < curHeight) {
                search(row, col, counts[curRow][curCol]);
            }
        }
    }
}