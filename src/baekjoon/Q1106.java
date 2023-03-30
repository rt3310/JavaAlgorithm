package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1106 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] cn = br.readLine().split(" ");
        int c = Integer.parseInt(cn[0]);
        int n = Integer.parseInt(cn[1]);
        int[] dp = new int[c + 1];
        Arrays.fill(dp, 1000000);
        dp[0] = 0;

        List<int[]> costs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int cost = Integer.parseInt(input[0]);
            int count = Integer.parseInt(input[1]);
            costs.add(new int[]{cost, count});
        }

        for (int i = 0; i <= c; i++) {
            for (int[] cost : costs) {
                dp[Math.min(i + cost[1], c)] = Math.min(dp[Math.min(i + cost[1], c)], dp[i] + cost[0]);
            }

        }

        System.out.println(dp[c]);
    }
}
