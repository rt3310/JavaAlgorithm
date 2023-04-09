package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1520 {

    private static int m;
    private static int n;
    private static int[][] map;
    private static int[][] dp;
    private static int[][] directions;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] mn = br.readLine().split(" ");
        m = Integer.parseInt(mn[0]);
        n = Integer.parseInt(mn[1]);
        map = new int[m][n];
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(search(0, 0));
    }

    public static int search(int curRow, int curCol) {
        if (curRow == m - 1 && curCol == n - 1) {
            return 1;
        }

        if (dp[curRow][curCol] != -1) {
            return dp[curRow][curCol];
        }

        dp[curRow][curCol] = 0;

        int curHeight = map[curRow][curCol];
        for (int[] direction : directions) {
            int row = curRow + direction[0];
            int col = curCol + direction[1];

            if (row < 0 || row >= m || col < 0 || col >= n) {
                continue;
            }

            if (map[row][col] < curHeight) {
                dp[curRow][curCol] += search(row, col);
            }
        }

        return dp[curRow][curCol];
    }
}
