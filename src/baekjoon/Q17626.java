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
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 1;

        int count = 3;
        for (int i = 5; i <= n; i++) {
            if (i == (int) Math.pow(count, 2)) {
                dp[i] = 1;
                count++;
                continue;
            }

            int left = 1;
            int right = i - 1;
            int min = Integer.MAX_VALUE;
            while (left <= Math.pow((count / 2) + 1, 2) && left <= i / 2) {
                min = Math.min(min, dp[left] + dp[right]);
                left++;
                right--;
            }

            dp[i] = min;
        }

        System.out.println(dp[n]);
    }
}
