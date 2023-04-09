package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1937 {

    private static int n;
    private static int[][] map;
    private static int[][] dp;
    private static int[][] directions;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new int[n][n];
        directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxDistance = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] != 0) {
                    continue;
                }
                maxDistance = Math.max(maxDistance, search(i, j));
            }
        }

        System.out.println(maxDistance);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int search(int curRow, int curCol) {
        if (dp[curRow][curCol] != 0) {
            return dp[curRow][curCol];
        }

        dp[curRow][curCol] = 1;
        for (int[] direction : directions) {
            int row = curRow + direction[0];
            int col = curCol + direction[1];

            if (row < 0 || row >= n || col < 0 || col >= n) {
                continue;
            }

            if (map[row][col] <= map[curRow][curCol]) {
                continue;
            }

            dp[curRow][curCol] = Math.max(dp[curRow][curCol], search(row, col) + 1);
        }


        return dp[curRow][curCol];
    }
}
