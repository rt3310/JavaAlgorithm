package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q14772 {

    private static int n;
    private static int[][] map;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    int max = dp[i][j];
                    if (i > 0) {
                        if (dp[i - 1][j] % 3 == 0) {
                            max = Math.max(max, dp[i - 1][j] + 1);
                        } else {
                            max = Math.max(max, dp[i - 1][j]);
                        }
                    }
                    if (j > 0) {
                        if (dp[i][j - 1] % 3 == 0) {
                            max = Math.max(max, dp[i][j - 1] + 1);
                        } else {
                            max = Math.max(max, dp[i][j - 1]);
                        }
                    }
                    dp[i][j] = Math.max(dp[i][j], max);
                    continue;
                }
                if (map[i][j] == 1) {
                    int max = dp[i][j];
                    if (i > 0) {
                        if (dp[i - 1][j] % 3 == 1) {
                            max = Math.max(max, dp[i - 1][j] + 1);
                        } else {
                            max = Math.max(max, dp[i - 1][j]);
                        }
                    }
                    if (j > 0) {
                        if (dp[i][j - 1] % 3 == 1) {
                            max = Math.max(max, dp[i][j - 1] + 1);
                        } else {
                            max = Math.max(max, dp[i][j - 1]);
                        }
                    }
                    dp[i][j] = Math.max(dp[i][j], max);
                    continue;
                }

                int max = dp[i][j];
                if (i > 0) {
                    if (dp[i - 1][j] % 3 == 2) {
                        max = Math.max(max, dp[i - 1][j] + 1);
                    } else {
                        max = Math.max(max, dp[i - 1][j]);
                    }
                }
                if (j > 0) {
                    if (dp[i][j - 1] % 3 == 2) {
                        max = Math.max(max, dp[i][j - 1] + 1);
                    } else {
                        max = Math.max(max, dp[i][j - 1]);
                    }
                }
                dp[i][j] = Math.max(dp[i][j], max);
            }
        }

        int max = 0;
        for (int[] row : dp) {
            for (int i : row) {
                max = Math.max(max, i);
            }
        }

        System.out.println(max);
    }
}