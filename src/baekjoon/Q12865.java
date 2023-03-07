package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q12865 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<int[]> list = new ArrayList<>();

        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] wv = br.readLine().split(" ");
            int w = Integer.parseInt(wv[0]);
            int v = Integer.parseInt(wv[1]);
            list.add(new int[]{w, v});
        }
        list.sort(Comparator.comparingInt(v -> v[0]));

        dp[0][0] = list.get(0)[0];
        dp[0][1] = list.get(0)[1];
        for (int i = 1; i < n; i++) {
            if (list.get(i)[0] + dp[i - 1][0] <= k) {
                dp[i][0] = list.get(i)[0] + dp[i - 1][0];
                dp[i][1] = list.get(i)[1] + dp[i - 1][1];
                continue;
            }
            if (dp[i - 1][1] > list.get(i)[0]) {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = dp[i - 1][1];
                continue;
            }
            dp[i][0] = list.get(i)[0];
            dp[i][1] = list.get(i)[1];
        }

        int max = 0;
        for (int[] dr : dp) {
            max = Math.max(max, dr[1]);
        }
        System.out.println(max);
    }
}
