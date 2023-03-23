package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17404 {

    private static int n;
    private static int[][] houses;
    private static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        houses = new int[n][3];
        min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                houses[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 3; i++) {
            int[][] dp = new int[n][3];
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    dp[1][j] = Integer.MAX_VALUE;
                    continue;
                }
                dp[1][j] = houses[0][i] + houses[1][j];
            }
            for (int j = 2; j < n - 1; j++) {
                dp[j][0] = Math.min(dp[j - 1][2], dp[j - 1][1]) + houses[j][0];
                dp[j][1] = Math.min(dp[j - 1][0], dp[j - 1][2]) + houses[j][1];
                dp[j][2] = Math.min(dp[j - 1][1], dp[j - 1][0]) + houses[j][2];
            }
            if (i != 0) {
                dp[n - 1][0] = Math.min(dp[n - 2][2], dp[n - 2][1]) + houses[n - 1][0];
            }
            if (i != 1) {
                dp[n - 1][1] = Math.min(dp[n - 2][0], dp[n - 2][2]) + houses[n - 1][1];
            }
            if (i != 2) {
                dp[n - 1][2] = Math.min(dp[n - 2][1], dp[n - 2][0]) + houses[n - 1][2];
            }

            for (int j = 0; j < 3; j++) {
                if (j != i) {
                    min = Math.min(min, dp[n - 1][j]);
                }
            }
        }

        System.out.println(min);
    }
}
