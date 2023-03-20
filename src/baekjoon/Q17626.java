package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q17626 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        dp[1] = 1;

        int sqrt = 2;
        for (int i = 2; i <= n; i++) {
            if (i == Math.pow(sqrt, 2)) {
                dp[i] = 1;
                sqrt++;
                continue;
            }

            int minCount = 5;
            for (int j = 1; j*j < i; j++) {
                int count = dp[i - j*j] + 1;
                minCount = Math.min(minCount, count);
            }

            dp[i] = minCount;
        }

        System.out.println(dp[n]);
    }
}