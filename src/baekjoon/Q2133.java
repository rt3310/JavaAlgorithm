package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2133 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[31];

        if (n == 1) {
            System.out.println(0);
            return;
        }

        dp[2] = 3;

        for (int i = 4; i <= n; i+=2) {
            dp[i] = (dp[i - 2] * 3) + 2;
        }

        System.out.println(dp[n]);
    }
}
